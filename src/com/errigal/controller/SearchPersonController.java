package com.errigal.controller;

import com.errigal.model.Person;
import com.errigal.util.Constant;

import java.util.*;

/**
 * <p>Class for searching users</p>
 */
public class SearchPersonController extends BasePersonController{


    public SearchPersonController(){}

    /*************************************Search****************************************/
    //search users
    public Map<Integer, Person> searchUser(Scanner scanner, Map<Integer, Person> personMap) {
        Map<Integer, Person> searchedPeople = new LinkedHashMap<>();
        while (true) {
            try {
                System.out.println(Constant.SEARCH_BY_USER_ID);
                System.out.println(Constant.SEARCH_BY_NAME);
                System.out.println(Constant.PRESS_Q);

                String userNumber = scanner.nextLine();
                String value = userNumber.substring(0, 1);
                if (value.equals("q")) {
                    break;
                }

                else if (value.equals("1")) {
                    //search by user id
                    Person person = searchByUserId(value, personMap, scanner);
                    if (person != null) {
                        searchedPeople.put(person.getId(), person);
                    } else {
                        System.out.println(Constant.NO_USER);
                    }
                }
                else if (value.equals("2")) {
                    //search by first name and last name
                    List<Person> personList = searchByFirstNameAndLastName(value, personMap, scanner);
                    if (personList != null) {
                        for (Person person1 : personList) {
                            searchedPeople.put(person1.getId(), person1);
                        }
                    } else {
                        System.out.println(Constant.NO_USER);
                    }
                }

                System.out.println(Constant.COMPLETED);
                break;
            } catch (NumberFormatException ex) {
                System.out.println(Constant.ENTER_NUMBER);
            } catch (StringIndexOutOfBoundsException strEx) {
                System.out.println(Constant.TYPE_SOMETHING);
            }
        }

        return searchedPeople;
    }
    /*************************************Search****************************************/

    //search user
    private Person searchByUserId(String value, Map<Integer, Person> personMap, Scanner scanner) {
        Person person = null;
        try {
            System.out.println(Constant.ENTER_USER_ID);
            String userId = scanner.nextLine();
            int iUserId = Integer.parseInt(userId);
            person = personService.searchByUserId(personMap, iUserId);
        } catch (NumberFormatException ex) {
            System.out.println(Constant.ENTER_NUMBER);
        }

        return person;
    }

    private List<Person> searchByFirstNameAndLastName(String value, Map<Integer, Person> personMap, Scanner scanner) {
        List<Person> personList = null;
        System.out.println(Constant.ENTER_FIRST_NAME);
        String firstName = scanner.nextLine();
        System.out.println(Constant.ENTER_LAST_NAME);
        String lastName = scanner.nextLine();
        personList = personService.searchUserByFirstOrLastName(personMap, firstName, lastName);
        return personList;
    }

}
