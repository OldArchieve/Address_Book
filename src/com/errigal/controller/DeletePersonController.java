package com.errigal.controller;

import com.errigal.Exception.PersonNotFoundException;
import com.errigal.model.Person;
import com.errigal.util.Constant;

import java.util.Map;
import java.util.Scanner;

/**
 *  Use this to delete an user
 */
public class DeletePersonController extends BasePersonController {


    public Map<Integer,Person> deleteUser(Map<Integer,Person> personMap,Scanner scanner) {
        //Person person = null;
        while(true) {
            System.out.println(Constant.ENTER_USER_ID);
            String userInput = scanner.nextLine();
            try {
                int userId = Integer.parseInt(userInput);
                personService.searchIfExists(personMap, userId);
                personMap = personService.removeUser(personMap, userId);
                break;
            } catch (NumberFormatException ex) {
                System.out.println(Constant.ENTER_NUMBER);
            } catch (PersonNotFoundException ex) {
                break;
            }
        }
        return personMap;
    }
}
