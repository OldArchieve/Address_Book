package com.errigal.controller;

import com.errigal.model.Address;
import com.errigal.model.Person;
import com.errigal.util.Constant;

import java.util.*;


/**
 * <p> class for generating users</p>
 */
public class CreatePersonController extends BasePersonController{
    //PersonService personService;

    public CreatePersonController() {
        //personService = new PersonService();
    }

    /**************************Create user*************************/
    // create user
    public Person createUser(Scanner scanner) {
        String firstName = "";
        String lastName = "";
        //user details
        System.out.println(Constant.ENTER_USER_DETAILS);
        while (true) {
            //First name
            System.out.println(Constant.ENTER_FIRST_NAME);
            firstName = scanner.nextLine();
            //last name
            System.out.println(Constant.ENTER_LAST_NAME);
            lastName = scanner.nextLine();
            if (checkUserName(firstName, lastName)) {
                break;
            }
        }
        //email address
        System.out.println(Constant.ENTER_EMAIL);
        String emailAddress = scanner.nextLine();
        //agr
        int iAge = 0;
        iAge = getAge(scanner);
        //contact
        long iContact = 0;
        iContact = getContactNumber(scanner);

        //address section
        System.out.println(Constant.ENTER_ADDRESS_DETAILS);
        System.out.println(Constant.ENTER_HOME_ADDRESS);
        //home address
        List<Address> homeAddresses = new ArrayList<>();
        while (true) {

            homeAddresses.add(askAddressQuestions(scanner));

            System.out.println(Constant.ADD_ANOTHER_ADDRESS);
            String proceed = scanner.nextLine();

            if (!proceed.toLowerCase().equals("y")) {
                break;
            }
        }
        //office address
        System.out.println(Constant.OFFICE_ADDRESS_PROCEED);
        String proceed = scanner.nextLine();
        List<Address> officeAddresses = new ArrayList<>();
        ;
        if (proceed.toLowerCase().equals("y")) {
            while (true) {
                System.out.println(Constant.ENTER_OFFICE_ADDRESS);
                officeAddresses.add(askAddressQuestions(scanner));
                System.out.println(Constant.ADD_ANOTHER_ADDRESS);
                String proceedAgain = scanner.nextLine();

                if (!proceedAgain.toLowerCase().equals("y")) {
                    break;
                }
            }
        }
        Person person = personService.createUser
                (firstName, lastName, iContact, homeAddresses, officeAddresses, iAge, emailAddress);
        return person;
    }
    /**************************Create user*************************/



    //check if first name and last name exist
    public boolean checkUserName(String firstName, String lastName) {
        if (firstName.equals("")) {
            return false;
        }
        if( lastName.equals("")){
            return false;
        }
        return true;
    }




    /*********************************Private Methods*************************************/

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

    //keep asking user until you get a valid number
    private int getAge(Scanner scanner) {
        int iAge = 0;
        while (true) {
            try {
                System.out.println(Constant.ENTER_AGE);
                String age = scanner.nextLine();
                iAge = Integer.parseInt(age);
                break;
            } catch (NumberFormatException ex) {
                System.out.println(Constant.ENTER_NUMBER);
            }
        }
        return iAge;
    }

    //keep asking user until you get a valid number
    private long getContactNumber(Scanner scanner) {
        long iContact = 0;
        while (true) {
            try {
                System.out.println(Constant.ENTER_CONTACT_NUM);
                String contact = scanner.nextLine();
                iContact = Long.parseLong(contact);
                break;
            } catch (NumberFormatException ex) {
                System.out.println(Constant.ENTER_NUMBER);
            }
        }
        return iContact;
    }


    /*********************************Private Methods*************************************/


}
