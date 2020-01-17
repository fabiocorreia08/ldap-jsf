package br.gov.cmb.jsf.model;

public final  class Person {
	
	private String uid;
    private String fullName;
    private String lastName;
    private String physicalDeliveryOfficeName;

    public Person() {
    }

    public Person(String fullName, String lastName, String physicalDeliveryOfficeName) {
        this.fullName = fullName;
        this.lastName = lastName;
        this.physicalDeliveryOfficeName = physicalDeliveryOfficeName;
    }

    public Person(String uid, String fullName, String lastName, String physicalDeliveryOfficeName) {
        this.uid = uid;
        this.fullName = fullName;
        this.lastName = lastName;
        this.physicalDeliveryOfficeName = physicalDeliveryOfficeName;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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
                "fullName='" + fullName + '\'' +
                ", lastName='" + lastName + '\'' +
                 ", physicalDeliveryOfficeName='" + physicalDeliveryOfficeName + '\'' +
                '}';
    }
}
