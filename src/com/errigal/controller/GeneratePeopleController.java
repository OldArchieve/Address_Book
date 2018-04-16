package com.errigal.controller;

import com.errigal.model.Person;
import com.errigal.service.PersonService;
import com.errigal.util.Constant;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * <p>Class for generating random users</p>
 */
public class GeneratePeopleController extends BasePersonController{


    //PersonService personService;

    public GeneratePeopleController(){
        //personService = new PersonService();
    }


    /*********************Generate Users***************************************/
    //create random users
    public Map<Integer, Person> generateRandomUsers(Scanner scanner) {
        Map<Integer, Person> personMap = new LinkedHashMap<>();
        while (true) {
            System.out.println(Constant.RANDOM_USER);
            System.out.println(Constant.PRESS_Q);
            String userNumber = scanner.nextLine();

            try {
                String value = userNumber.substring(0, 1);
                if (value.equals("q")) {
                    break;
                }
                int number = Integer.parseInt(userNumber);

                System.out.println(Constant.GENERATING_USERS + number);
                Map<Integer, Person> users = personService.generate(number);
                personMap.putAll(users);
                System.out.println(Constant.COMPLETED);
                break;
            } catch (NumberFormatException ex) {
                System.out.println(Constant.ENTER_NUMBER);
            } catch (StringIndexOutOfBoundsException strEx) {
                System.out.println(Constant.TYPE_SOMETHING);
            }
        }

        return personMap;
    }
    /*********************Generate Users***************************************/
}
