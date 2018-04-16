package com.errigal.service;

import com.errigal.Exception.PersonNotFoundException;
import com.errigal.model.Address;
import com.errigal.model.Person;
import com.errigal.util.Constant;

import java.security.SecureRandom;
import java.util.*;

/**
 * <p>This is  like a business logic where we create users </p>
 */
public class PersonService {

    private String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private String numeric = "0123456789";
    private SecureRandom rnd = new SecureRandom();
    private int random_length = 5;
    private int random_address_length = 6;

    //default constructor
    public PersonService(){ }


    /**************************Create user*************************/
    public Person createUser(String firstName,String lastName,long contactNumber,
                             List<Address> homeAddresses, List<Address> officeAddresses, int age, String emailAddress){
        int id = Person.uniqueId += 1;
        Person person = new Person(id,firstName,lastName,contactNumber,homeAddresses,officeAddresses,age,emailAddress);
        return person;

    }
    /**************************Create user*************************/


    /*********************Generate Users***************************************/
    // we are using person map so that we retrieve the data quickly O(1) time complexity
    public Map<Integer, Person> generate(int numberOfUsers){
        Map<Integer,Person> personMap = new LinkedHashMap<>();
        for(int i=1;i<=numberOfUsers;i++){
            String firstName = randomString(random_length,AB);
            String lastName = randomString(random_length,AB);
            List<Address> homeAddressList = new ArrayList<>();
            homeAddressList.add(createAddress(
                    randomString(random_address_length,AB),
                    randomString(random_address_length,AB),
                    randomString(random_address_length,AB),
                    randomString(random_address_length,AB),
                    randomString(random_address_length,AB)));

            List<Address> officeAddressList = new ArrayList<>();
            officeAddressList.add(createAddress(
                    randomString(random_address_length,AB),
                    randomString(random_address_length,AB),
                    randomString(random_address_length,AB),
                    randomString(random_address_length,AB),
                    randomString(random_address_length,AB)));
            //assuming we always get 10 digit phone number
            String conNumber = randomString(10,numeric);
            long contactNumber = Long.parseLong(conNumber);
            int age = Integer.parseInt((randomString(2,numeric)));
            String email = "address.app@test.com";
            Person person = createUser(firstName,lastName,contactNumber,homeAddressList,officeAddressList,age,email);
            personMap.put(person.getId(),person);
        }

        return personMap;

    }


    /*********************Generate Users***************************************/

    /*************************************Search****************************************/
    //search the user by first name or last name
    public List<Person> searchUserByFirstOrLastName(Map<Integer,Person> personMap,String firstName,String lastName){
        Iterator<Map.Entry<Integer,Person>> iterator = personMap.entrySet().iterator();
        List<Person> searchedPeople = new ArrayList<>();
        while (iterator.hasNext()){
            Map.Entry<Integer,Person> pair = (Map.Entry<Integer,Person>)iterator.next();
            Person person = pair.getValue();
            if(person.getFirstName().equals(firstName) || person.getLastName().equals(lastName)){
                searchedPeople.add(person);
            }
        }
        return searchedPeople;
    }

    //search the user by user id
    public Person searchByUserId(Map<Integer,Person> personMap,int id){
        return personMap.get(id);
    }
    /*************************************Search**************************************/



    public Person searchIfExists(Map<Integer,Person> personMap, int userId) throws PersonNotFoundException {
        Person searchedPerson = this.searchByUserId(personMap,userId);
        if(searchedPerson == null){
            throw new PersonNotFoundException(Constant.NO_USER);
        }
        return searchedPerson;
    }


    public Map<Integer,Person> removeUser(Map<Integer,Person> personMap,int userId){
        personMap.remove(userId);
        Person.uniqueId--;
        return personMap;
    }


    public List<Person> sortUsersByFirstNameAsc(Map<Integer,Person> personMap){
        Iterator<Map.Entry<Integer,Person>> iterator = personMap.entrySet().iterator();
        List<Person> sortedPeople = new ArrayList<>();
        while (iterator.hasNext()){
            Map.Entry<Integer,Person> pair = (Map.Entry<Integer,Person>)iterator.next();
            Person person = pair.getValue();
            sortedPeople.add(person);
        }
        Collections.sort(sortedPeople,Person.PersonFirstNameComparator);

        return sortedPeople;
    }



    public List<Person> sortUsersByLastNameAsc(Map<Integer,Person> personMap){
        Iterator<Map.Entry<Integer,Person>> iterator = personMap.entrySet().iterator();
        List<Person> sortedPeople = new ArrayList<>();
        while (iterator.hasNext()){
            Map.Entry<Integer,Person> pair = (Map.Entry<Integer,Person>)iterator.next();
            Person person = pair.getValue();
            sortedPeople.add(person);
        }
        Collections.sort(sortedPeople,Person.PersonLastNameComparator);

        return sortedPeople;
    }


    /*********************************Private Methods*************************************/

    //create address
    public Address createAddress(String addressLine1,String addressLine2, String street, String county, String pinCode){
        return new Address(addressLine1,addressLine2,street,county,pinCode);
    }

    //generates random strings
    private String randomString( int length,String str ){
        StringBuffer sb = new StringBuffer( length );
        for( int i = 0; i < length; i++ )
            sb.append( str.charAt( rnd.nextInt(str.length()) ) );
        return sb.toString();
    }


    /**********************************Private Methods************************************/


}
