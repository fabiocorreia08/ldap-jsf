package br.gov.cmb.jsf.repo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.query.LdapQueryBuilder;
import org.springframework.stereotype.Service;

import br.gov.cmb.jsf.model.Person;

@Service
public class PersonRepository {

	@Autowired
    private LdapTemplate ldapTemplate;

    public Person create(Person person) {
        ldapTemplate.create(person);
        return person;
    }

    public Person findByUid(String uid) {
        return ldapTemplate.findOne(LdapQueryBuilder.query().where("uid").is(uid), Person.class);
    }

    public void update(Person person) {
        ldapTemplate.update(person);
    }

    public void delete(Person person) {
        ldapTemplate.delete(person);
    }

    public List<Person> findAll() {
        return ldapTemplate.findAll(Person.class);
    }

    public List<Person> findByLastName(String lastName) {
        return ldapTemplate.find(LdapQueryBuilder.query().where("sn").is(lastName), Person.class);
    }
    
	/*
	 * private void modifyAdAttribute(LdapContext ldapContext, String userCN, String
	 * attribute, Object value) throws NamingException{ ModificationItem[]
	 * modificationItem = new ModificationItem[1]; modificationItem[0] = new
	 * ModificationItem(DirContext.REPLACE_ATTRIBUTE, new BasicAttribute(attribute,
	 * value)); ldapContext.modifyAttributes(userCN, modificationItem); }
	 */
    
	/*
	 * public void lockAccount(LdapContext ldapContext, String userDN) throws
	 * NamingException, UnsupportedEncodingException, IOException {
	 * 
	 * modifyAdAttribute(ldapContext, userDN, "userAccountControl",
	 * UF_NORMAL_ACCOUNT + UF_ACCOUNTDISABLE); System.out.println("Account " +
	 * userDN + " locked");
	 * 
	 * }
	 */
    
    
    
}