package test.Service;

import com.errigal.Exception.PersonNotFoundException;
import com.errigal.model.Address;
import com.errigal.model.Person;
import com.errigal.service.PersonService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class PersonServiceTest {

    PersonService personService;
    Person person;
    Map<Integer,Person> personMap;

    @Before
    public void setUp(){
        String firstName = "a";
        String lastName = "b";
        long contactNum = 123;
        String email = "as";
        int age = 1;
        Person.uniqueId = 100;

        Address address = new Address("a1", "a2", "st", "c", "dublin5");
        List<Address> homeAddress = new ArrayList<>();
        homeAddress.add(address);

        Address oAddress = new Address("o1", "o2", "ost", "oc", "odublin5");
        List<Address> officeAddress = new ArrayList<>();
        officeAddress.add(oAddress);

        person = new Person(Person.uniqueId, firstName, lastName, contactNum, homeAddress, officeAddress, age, email);
        personService = new PersonService();
        personMap = new LinkedHashMap<>();
        personMap.put(person.getId(),person);
    }


   @Test
   public void searchUserByFirstLastNameTest(){
        List<Person> returnedList =  personService.searchUserByFirstOrLastName(personMap,"a","b");
       Assert.assertEquals(100, returnedList.get(0).getId());
   }

   @Test
    public void searchUserByIdTest(){
       Person person = personService.searchByUserId(personMap,100);
       Assert.assertEquals(100,person.getId());
   }

   @Test
    public void searchIfUserExists() throws PersonNotFoundException{
        Person person = personService.searchIfExists(personMap,100);
        Assert.assertEquals(100,person.getId());
    }

    @Test
    public void generateUsersTest(){
        int size = 10;
        Map<Integer,Person> map = personService.generate(size);
        Assert.assertEquals(size,map.size());
    }


    @Test
    public void removeUserTest(){
        Map<Integer,Person> map = personService.removeUser(personMap,100);
        int uniqueId = 99;
        Assert.assertEquals(uniqueId,Person.uniqueId);
        Assert.assertEquals(0,map.size());

    }

    @Test
    public void createPersonTest(){
        String firstName = "aa";
        String lastName = "bb";
        long contactNum = 1234;
        String email = "asd";
        int age = 1;

        Address address = new Address("a11", "a22", "st2", "c2", "dublin52");
        List<Address> homeAddress = new ArrayList<>();
        homeAddress.add(address);

        Address oAddress = new Address("o12", "o22", "ost2", "oc2", "odublin52");
        List<Address> officeAddress = new ArrayList<>();
        officeAddress.add(oAddress);

        Person person = personService.createUser(firstName,lastName,contactNum,homeAddress,officeAddress,age,email);

        Assert.assertEquals(firstName,person.getFirstName());
        Assert.assertEquals(lastName, person.getLastName());
        Assert.assertEquals(contactNum, person.getContactNumber());
        Assert.assertEquals(email, person.getEmailAddress());
        Assert.assertEquals(age, person.getAge());
        Assert.assertEquals(homeAddress.size(), person.getHomeAddresses().size());
        Assert.assertEquals(officeAddress.size(), person.getOfficeAddresses().size());

        Assert.assertEquals(address.getAddressLine1(), person.getHomeAddresses().get(0).getAddressLine1());
        Assert.assertEquals(address.getAddressLine2(), person.getHomeAddresses().get(0).getAddressLine2());
        Assert.assertEquals(address.getCounty(), person.getHomeAddresses().get(0).getCounty());
        Assert.assertEquals(address.getPinCode(), person.getHomeAddresses().get(0).getPinCode());
        Assert.assertEquals(address.getStreet(), person.getHomeAddresses().get(0).getStreet());

        Assert.assertEquals(oAddress.getAddressLine1(), person.getOfficeAddresses().get(0).getAddressLine1());
        Assert.assertEquals(oAddress.getAddressLine2(), person.getOfficeAddresses().get(0).getAddressLine2());
        Assert.assertEquals(oAddress.getCounty(), person.getOfficeAddresses().get(0).getCounty());
        Assert.assertEquals(oAddress.getPinCode(), person.getOfficeAddresses().get(0).getPinCode());
        Assert.assertEquals(oAddress.getStreet(), person.getOfficeAddresses().get(0).getStreet());

        Assert.assertEquals(Person.uniqueId,person.getId());

    }


    @Test
    public void sortByFirstNameAscTest(){
        String firstName = "1";
        String lastName = "bb";
        long contactNum = 1234;
        String email = "asd";
        int age = 1;

        Address address = new Address("a11", "a22", "st2", "c2", "dublin52");
        List<Address> homeAddress = new ArrayList<>();
        homeAddress.add(address);

        Address oAddress = new Address("o12", "o22", "ost2", "oc2", "odublin52");
        List<Address> officeAddress = new ArrayList<>();
        officeAddress.add(oAddress);

        Person person = personService.createUser(firstName,lastName,contactNum,homeAddress,officeAddress,age,email);

        personMap.put(person.getId(),person);

        List<Person> personList = personService.sortUsersByFirstNameAsc(personMap);

        Assert.assertEquals(person.getId(),personList.get(0).getId());

    }

    @Test
    public void sortByLastNameAscTest(){
        String firstName = "z";
        String lastName = "1";
        long contactNum = 1234;
        String email = "asd";
        int age = 1;

        Address address = new Address("a11", "a22", "st2", "c2", "dublin52");
        List<Address> homeAddress = new ArrayList<>();
        homeAddress.add(address);

        Address oAddress = new Address("o12", "o22", "ost2", "oc2", "odublin52");
        List<Address> officeAddress = new ArrayList<>();
        officeAddress.add(oAddress);

        Person person = personService.createUser(firstName,lastName,contactNum,homeAddress,officeAddress,age,email);

        personMap.put(person.getId(),person);

        List<Person> personList = personService.sortUsersByLastNameAsc(personMap);

        Assert.assertEquals(person.getId(),personList.get(0).getId());

    }


    @Test
    public void createAddressTest(){
        Address address = new Address("a11", "a22", "st2", "c2", "dublin52");
        Address addressByService = personService.createAddress(address.getAddressLine1(),
                address.getAddressLine2(),address.getStreet(),address.getCounty(),address.getPinCode());

        Assert.assertEquals(address,addressByService);

    }


}
