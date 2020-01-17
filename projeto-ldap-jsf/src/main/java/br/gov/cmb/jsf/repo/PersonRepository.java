package br.gov.cmb.jsf.repo;

import java.util.List;

import javax.naming.Name;
import javax.naming.directory.Attributes;
import javax.naming.directory.BasicAttribute;
import javax.naming.directory.BasicAttributes;
import javax.naming.ldap.LdapName;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ldap.core.DirContextOperations;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.core.support.AbstractContextMapper;
import org.springframework.ldap.core.support.BaseLdapNameAware;
import org.springframework.ldap.filter.EqualsFilter;
import org.springframework.ldap.query.LdapQuery;
import org.springframework.ldap.query.LdapQueryBuilder;
import org.springframework.ldap.support.LdapNameBuilder;
import org.springframework.ldap.support.LdapUtils;
import org.springframework.stereotype.Service;

import br.gov.cmb.jsf.model.Person;

@Service
public class PersonRepository implements BaseLdapNameAware  {

	@Autowired
    private LdapTemplate ldapTemplate;
    private LdapName baseLdapPath;

    public void setBaseLdapPath(LdapName baseLdapPath) {
        this.baseLdapPath = baseLdapPath;
    }


    public List<Person> findAll() {
        EqualsFilter filter = new EqualsFilter("objectclass", "person");
        return ldapTemplate.search(LdapUtils.emptyLdapName(), filter.encode(), new PersonContextMapper());
    }

    public Person findOne(String uid) {
        Name dn = LdapNameBuilder.newInstance(baseLdapPath)
                .add("ou", "people")
                .add("uid", uid)
                .build();
        return ldapTemplate.lookup(dn, new PersonContextMapper());
    }

    public List<Person> findByName(String physicalDeliveryOfficeName) {
        LdapQuery q = LdapQueryBuilder.query()
                .where("objectclass").is("person")
                .and("physicalDeliveryOfficeName").whitespaceWildcardsLike(physicalDeliveryOfficeName);
        return ldapTemplate.search(q, new PersonContextMapper());
    }

    public void update(Person p) {
        ldapTemplate.rebind(buildDn(p), null, buildAttributes(p));
    }

	/*
	 * public void updateLastName(Person p) { Attribute attr = new
	 * BasicAttribute("sn", p.getLastName()); ModificationItem item = new
	 * ModificationItem(DirContext.REPLACE_ATTRIBUTE, attr);
	 * ldapTemplate.modifyAttributes(buildDn(p), new ModificationItem[] {item}); }
	 */

    public void delete(Person p) {
        ldapTemplate.unbind(buildDn(p));
    }

    private Name buildDn(Person p) {
        return LdapNameBuilder.newInstance(baseLdapPath)
                .add("ou", "people")
                .add("uid", p.getUid())
                .build();
    }

    private Attributes buildAttributes(Person p) {
        Attributes attrs = new BasicAttributes();
        BasicAttribute ocAttr = new BasicAttribute("objectclass");
        ocAttr.add("top");
        ocAttr.add("person");
        attrs.put(ocAttr);
        attrs.put("ou", "people");
        attrs.put("uid", p.getUid());
        attrs.put("cn", p.getFullName());
        attrs.put("sn", p.getLastName());
        attrs.put("physicalDeliveryOfficeName", p.getPhysicalDeliveryOfficeName());
        return attrs;
    }


    private static class PersonContextMapper extends AbstractContextMapper<Person> {
        public Person doMapFromContext(DirContextOperations context) {
            Person person = new Person();
            person.setFullName(context.getStringAttribute("cn"));
            person.setLastName(context.getStringAttribute("sn"));
            person.setUid(context.getStringAttribute("uid"));
            person.setPhysicalDeliveryOfficeName(context.getStringAttribute("physicalDeliveryOfficeName"));
            return person;
        }
    }
   
    
}