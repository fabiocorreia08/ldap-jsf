package br.gov.cmb.jsf.model;

import javax.naming.Name;

import org.springframework.ldap.odm.annotations.Attribute;
import org.springframework.ldap.odm.annotations.DnAttribute;
import org.springframework.ldap.odm.annotations.Entry;
import org.springframework.ldap.odm.annotations.Id;
import org.springframework.ldap.support.LdapNameBuilder;

@Entry(objectClasses = { "person", "top" })
public final  class Person {
	
	private static final String BASE_DN = "dc=memorynotfound,dc=com";
	
	@Id
    private Name dn;

    @DnAttribute(value="uid")
    private String uid;

    @Attribute(name="cn")
    private String fullName;

    @Attribute(name="sn")
    private String lastName; 
    
    @Attribute(name="description")
    private String description;  
    
    @Attribute(name="physicalDeliveryOfficeName")
    private String physicalDeliveryOfficeName;

	public Person() {
    }
    
    public Person(String fullName, String lastName) {
        Name dn = LdapNameBuilder.newInstance(BASE_DN)
                .add("ou", "people")
                .add("uid", fullName)
                .build();
        this.dn = dn;
        this.fullName = fullName;
        this.lastName = lastName;
        
    }

	public Name getDn() {
		return dn;
	}

	public String getUid() {
		return uid;
	}

	public String getFullName() {
		return fullName;
	}

	public String getLastName() {
		return lastName;
	}	

	public void setDn(Name dn) {
		this.dn = dn;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPhysicalDeliveryOfficeName() {
		return physicalDeliveryOfficeName;
	}

	public void setPhysicalDeliveryOfficeName(String physicalDeliveryOfficeName) {
		this.physicalDeliveryOfficeName = physicalDeliveryOfficeName;
	}

	@Override
    public String toString() {
        return "Person{" +
                "dn=" + dn +
                ", uid='" + uid + '\'' +
                ", fullName='" + fullName + '\'' +
                ", lastName='" + lastName + '\'' +
                
                '}';
    }   
	
}
