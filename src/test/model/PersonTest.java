package test.model;

import com.errigal.model.Address;
import com.errigal.model.Person;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class PersonTest {

    Person person;

    @Before
    public void setUp() {
        String firstName = "a";
        String lastName = "b";
        long contactNum = 123;
        String email = "as";
        int age = 1;

        Address address = new Address("a1", "a2", "st", "c", "dublin5");
        List<Address> homeAddress = new ArrayList<>();
        homeAddress.add(address);

        Address oAddress = new Address("o1", "o2", "ost", "oc", "odublin5");
        List<Address> officeAddress = new ArrayList<>();
        officeAddress.add(oAddress);

        person = new Person(100, firstName, lastName, contactNum, homeAddress, officeAddress, age, email);

    }

    @Test
    public void idTest(){
        Assert.assertEquals(100,person.getId());
    }


    @Test
    public void firstNameTest() {
        Assert.assertEquals("a", person.getFirstName());
    }

    @Test
    public void lastNameTest() {
        Assert.assertEquals("b", person.getLastName());
    }

    @Test
    public void contactNumTest() {
        Assert.assertEquals(123, person.getContactNumber());
    }

    @Test
    public void emailTest() {
        Assert.assertEquals("as", person.getEmailAddress());
    }

    @Test
    public void ageTest() {
        Assert.assertEquals(1, person.getAge());
    }

    @Test
    public void homeAddressLengthTest() {
        Assert.assertEquals(1, person.getHomeAddresses().size());
    }

    @Test
    public void officeAddressLengthTest() {
        Assert.assertEquals(1, person.getOfficeAddresses().size());
    }

    @Test
    public void homeAddressTest() {
        Address address = new Address("a1", "a2", "st", "c", "dublin5");
        Address homeAddress = person.getHomeAddresses().get(0);
        Assert.assertEquals(address.getAddressLine1(), homeAddress.getAddressLine1());
        Assert.assertEquals(address.getAddressLine2(), homeAddress.getAddressLine2());
        Assert.assertEquals(address.getCounty(), homeAddress.getCounty());
        Assert.assertEquals(address.getPinCode(), homeAddress.getPinCode());
        Assert.assertEquals(address.getStreet(), homeAddress.getStreet());
    }

    @Test
    public void officeAddressTest() {
        Address oAddress = new Address("o1", "o2", "ost", "oc", "odublin5");
        Address officeAddress = person.getOfficeAddresses().get(0);
        Assert.assertEquals(oAddress.getAddressLine1(), officeAddress.getAddressLine1());
        Assert.assertEquals(oAddress.getAddressLine2(), officeAddress.getAddressLine2());
        Assert.assertEquals(oAddress.getCounty(), officeAddress.getCounty());
        Assert.assertEquals(oAddress.getPinCode(), officeAddress.getPinCode());
        Assert.assertEquals(oAddress.getStreet(), officeAddress.getStreet());
    }

    @Test
    public void setFirstNameTest() {
        String firstName = "first";
        person.setFirstName(firstName);
        Assert.assertEquals(firstName, person.getFirstName());
    }

    @Test
    public void setLastNameTest() {
        String lastName = "last";
        person.setLastName(lastName);
        Assert.assertEquals(lastName, person.getLastName());
    }

    @Test
    public void setContactTest() {
        long contact = 4321;
        person.setContactNumber(contact);
        Assert.assertEquals(contact, person.getContactNumber());
    }

    @Test
    public void setAgeTest(){
        int age = 31;
        person.setAge(age);
        Assert.assertEquals(age,person.getAge());
    }

    @Test
    public void setIdTest(){
        int id = 101;
        person.setId(id);
        Assert.assertEquals(101,person.getId());
    }

    @Test
    public void setEmailTest(){
        String email = "test@test";
        person.setEmailAddress(email);
        Assert.assertEquals(email,person.getEmailAddress());
    }

    @Test
    public void setHomeAddressTest() {
        Address address = new Address("a1", "a2", "st", "c", "dublin5");
        List<Address> hAddress = new ArrayList<>();
        hAddress.add(address);
        person.setHomeAddresses(hAddress);
        Address homeAddress = person.getHomeAddresses().get(0);
        Assert.assertEquals(address.getAddressLine1(), homeAddress.getAddressLine1());
        Assert.assertEquals(address.getAddressLine2(), homeAddress.getAddressLine2());
        Assert.assertEquals(address.getCounty(), homeAddress.getCounty());
        Assert.assertEquals(address.getPinCode(), homeAddress.getPinCode());
        Assert.assertEquals(address.getStreet(), homeAddress.getStreet());
    }


    @Test
    public void setOfficeAddressTest() {
        Address oAddress = new Address("o1", "o2", "ost", "oc", "odublin5");
        List<Address> ooAddress = new ArrayList<>();
        ooAddress.add(oAddress);
        person.setHomeAddresses(ooAddress);
        Address officeAddress = person.getOfficeAddresses().get(0);
        Assert.assertEquals(oAddress.getAddressLine1(), officeAddress.getAddressLine1());
        Assert.assertEquals(oAddress.getAddressLine2(), officeAddress.getAddressLine2());
        Assert.assertEquals(oAddress.getCounty(), officeAddress.getCounty());
        Assert.assertEquals(oAddress.getPinCode(), officeAddress.getPinCode());
        Assert.assertEquals(oAddress.getStreet(), officeAddress.getStreet());
    }

}
