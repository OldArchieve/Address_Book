package com.errigal.controller;


import com.errigal.Exception.PersonNotFoundException;
import com.errigal.model.Address;
import com.errigal.model.Person;
import com.errigal.util.Constant;

import java.util.List;
import java.util.Map;
import java.util.Scanner;


/**
 * <p>Modify an user using this class</p>
 */
public class ModifyPersonController extends BasePersonController {

    //PersonService personService = super.personService;
    public Person editUser(Scanner scanner, Map<Integer, Person> personMap) {
        Person person = null;
        while (true) {
            System.out.println(Constant.ENTER_USER_ID);
            System.out.println(Constant.PRESS_Q);
            String userInput = scanner.nextLine();

            try {

                if(userInput.substring(0,1).equals("q")){
                    break;
                }

                int userId = Integer.parseInt(userInput);
                person = personService.searchIfExists(personMap, userId);
                System.out.println(Constant.EDIT_USER_INFO);

                //First name
                System.out.println(Constant.ENTER_FIRST_NAME);
                String scannerFirstName = scanner.nextLine();
                if (!scannerFirstName.equals("")) {
                    person.setFirstName(scannerFirstName);
                }
                //last name
                System.out.println(Constant.ENTER_LAST_NAME);
                String lastName = scanner.nextLine();
                if(!lastName.equals("")){
                    person.setLastName(lastName);
                }
                //email address
                System.out.println(Constant.ENTER_EMAIL);
                String emailAddress = scanner.nextLine();
                if(!emailAddress.equals("")){
                    person.setEmailAddress(emailAddress);
                }

                //age
                try {
                    System.out.println(Constant.ENTER_AGE);
                    String age = scanner.nextLine();
                    int iAge = Integer.parseInt(age);
                    person.setAge(iAge);
                } catch (NumberFormatException ex) {
                    //System.out.println(Constant.ENTER_NUMBER);
                }

                //contact number
                try {
                    System.out.println(Constant.ENTER_CONTACT_NUM);
                    String contact = scanner.nextLine();
                    long iContact = Long.parseLong(contact);
                    person.setContactNumber(iContact);
                } catch (NumberFormatException ex) {
                    //System.out.println(Constant.ENTER_NUMBER);
                }

               //home address
                person = homeAddress(person,scanner);

                //work address
                person = officeAddress(person,scanner);


                break;
            } catch (NumberFormatException ex) {
                System.out.println(Constant.ENTER_NUMBER);
            } catch (PersonNotFoundException ex) {
                //break;
            }
        }

        return person;
    }


    private boolean checkUserName(String firstName, String lastName) {
        if (firstName.equals("") && lastName.equals("")) {
            return false;
        }
        return true;
    }

    //get address
    private Address askAddressQuestions(Scanner scanner) {
        System.out.println(Constant.ENTER_ADDRESS_LINE_1);
        String addressLine1 = scanner.nextLine();

        System.out.println(Constant.ENTER_ADDRESS_LINE_2);
        String addressLine2 = scanner.nextLine();

        System.out.println(Constant.ENTER_STREET);
        String street = scanner.nextLine();

        System.out.println(Constant.ENTER_COUNTY);
        String county = scanner.nextLine();

        System.out.println(Constant.ENTER_PIN_CODE);
        String pinCode = scanner.nextLine();

        Address address = new Address(addressLine1, addressLine2, street, county, pinCode);
        return address;
    }

    //hanfle home address section
    private Person homeAddress(Person person,Scanner scanner){
        //add home address
        System.out.println(Constant.WHAT_YOU_WANT);
        System.out.println(Constant.ADD_HOME_ADDRESS);
        System.out.println(Constant.DELETE_ALL_HOME_ADDRESS);
        System.out.println(Constant.PRESS_Q);
        while(true){

            String userNumber = scanner.nextLine();
            try {
                String value = userNumber.substring(0, 1);
                if (value.equals("q")) {
                    break;
                }
                int number = Integer.parseInt(userNumber);

                if(number == 1){
                    Address address = askAddressQuestions(scanner);
                    List<Address> homeAddresses = person.getHomeAddresses();
                    homeAddresses.add(address);
                    person.setHomeAddresses(homeAddresses);
                }
                else if(number ==2 ){
                    person.setHomeAddresses(null);
                }

                break;
            } catch (NumberFormatException ex) {
                System.out.println(Constant.ENTER_NUMBER);
            } catch (StringIndexOutOfBoundsException strEx) {
                System.out.println(Constant.TYPE_SOMETHING);
            }
        }
        return person;
    }

    //handle office address section
    private Person officeAddress(Person person,Scanner scanner){
        //add home address
        System.out.println(Constant.WHAT_YOU_WANT);
        System.out.println(Constant.ADD_OFFICE_ADDRESS);
        System.out.println(Constant.DELETE_ALL_OFFICE_ADDRESS);
        System.out.println(Constant.PRESS_Q);
        while(true){

            String userNumber = scanner.nextLine();
            try {
                String value = userNumber.substring(0, 1);
                if (value.equals("q")) {
                    break;
                }
                int number = Integer.parseInt(userNumber);

                if(number == 1){
                    Address address = askAddressQuestions(scanner);
                    List<Address> officeAddresses = person.getOfficeAddresses();
                    officeAddresses.add(address);
                    person.setOfficeAddresses(officeAddresses);
                }
                else if(number ==2 ){
                    person.setOfficeAddresses(null);
                }

                break;
            } catch (NumberFormatException ex) {
                System.out.println(Constant.ENTER_NUMBER);
            } catch (StringIndexOutOfBoundsException strEx) {
                System.out.println(Constant.TYPE_SOMETHING);
            }
        }
        return person;
    }

}

