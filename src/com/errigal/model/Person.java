package com.errigal.model;

import java.util.Comparator;
import java.util.List;

/**
 * <p>This class is used to store person details</p>
 * <p><strong>Assumptions</strong> We are assuming that first name and last name will never be empty </p>
 * @author Srini
 */

public class Person {

    //used to as Unique Primary key
    public static int uniqueId = 0;
    private int id ;
    private String firstName;
    private String lastName;
    private long contactNumber;
    private List<Address> homeAddresses; // there is a possibility that he can have two homes
    private List<Address> officeAddresses; // Might be a CEO of a company who has multiple offices
    private int age;
    private String emailAddress;

    // let the modifier be on the public level
    public Person(int id,String firstName,String lastName,long contactNumber,
           List<Address> homeAddresses, List<Address> officeAddresses, int age, String emailAddress){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.contactNumber = contactNumber;
        this.homeAddresses = homeAddresses;
        this.officeAddresses = officeAddresses;
        this.age = age;
        this.emailAddress = emailAddress;
    }

    public Person(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public long getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(long contactNumber) {
        this.contactNumber = contactNumber;
    }

    public List<Address> getHomeAddresses() {
        return homeAddresses;
    }

    public void setHomeAddresses(List<Address> homeAddresses) {
        this.homeAddresses = homeAddresses;
    }

    public List<Address> getOfficeAddresses() {
        return officeAddresses;
    }

    public void setOfficeAddresses(List<Address> officeAddresses) {
        this.officeAddresses = officeAddresses;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }



    //Auto generated equals and hashcode methods
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;

        Person person = (Person) o;

        if (!firstName.equals(person.firstName)) return false;
        return lastName.equals(person.lastName);
    }

    @Override
    public int hashCode() {
        int result = firstName.hashCode();
        result = 31 * result + lastName.hashCode();
        return result;
    }
    //for first name ascending order
    public static Comparator<Person> PersonFirstNameComparator = new Comparator<Person>() {
        @Override
        public int compare(Person person1, Person person2) {
            String firstName1 = person1.getFirstName().toLowerCase();
            String firstName2 = person2.getFirstName().toLowerCase();
            return firstName1.compareTo(firstName2);
        }
    };

    //for last name ascending order
    public static Comparator<Person> PersonLastNameComparator = new Comparator<Person>() {
        @Override
        public int compare(Person person1, Person person2) {
            String lastName1 = person1.getLastName().toLowerCase();
            String lastName2 = person2.getLastName().toLowerCase();
            return lastName1.compareTo(lastName2);
        }
    };
}
