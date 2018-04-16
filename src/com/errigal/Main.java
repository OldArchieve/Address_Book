package com.errigal;

import com.errigal.Exception.PersonNotFoundException;
import com.errigal.controller.*;
import com.errigal.helper.GUIHelper;
import com.errigal.model.Person;
import com.errigal.util.Constant;

import java.util.*;

/**
 * <p><strong>Assumptions</strong>
 * User will always enter first name and last name - Why because we need them for sorting functionality</p>
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GUIHelper guiHelper = new GUIHelper();


        GeneratePeopleController generatePeopleController = new GeneratePeopleController();
        SearchPersonController searchPersonController = new SearchPersonController();
        CreatePersonController createPersonController = new CreatePersonController();
        DisplayPersonController displayPersonController = new DisplayPersonController();
        ModifyPersonController modifyPersonController = new ModifyPersonController();
        DeletePersonController deletePersonController = new DeletePersonController();
        SortPersonController sortPersonController = new SortPersonController();

        Map<Integer, Person> allPersons = new LinkedHashMap<>();
        Person person;
        System.out.println(Constant.NO_OF_USERS + allPersons.size());
        try {
            while (true) {
                guiHelper.questions();
                String line = scanner.nextLine();

                try {
                    line.substring(0, 1);
                    System.out.println(line);
                    switch (line) {
                        case "1": {
                            Map<Integer, Person> personMap = generatePeopleController.generateRandomUsers(scanner);
                            allPersons.putAll(personMap);
                            System.out.println(Constant.NO_OF_USERS + allPersons.size());
                            break;
                        }
                        case "2": {
                            Map<Integer, Person> personMap = searchPersonController.searchUser(scanner, allPersons);
                            displayPersonController.displayUsers(personMap);
                            break;
                        }
                        case "3": {
                            person = createPersonController.createUser(scanner);
                            allPersons.put(person.getId(), person);
                            System.out.println(allPersons.size());
                            break;
                        }
                        case "4": {
                            person = modifyPersonController.editUser(scanner, allPersons);
                            if(person!=null){
                                allPersons.put(person.getId(),person);
                            }
                            break;
                        }
                        case "5":{
                            allPersons = deletePersonController.deleteUser(allPersons,scanner);
                            break;
                        }

                        case "6":{
                            allPersons = sortPersonController.sortPersonByFirstName(allPersons);
                            break;
                        }
                        case "7":{
                            allPersons = sortPersonController.sortPersonByLastName(allPersons);
                            break;
                        }

                        case "8": {
                            displayPersonController.displayUsers(allPersons);
                            break;
                        }
                        case "9": {
                            System.exit(0);
                            break;
                        }

                    }
                } catch (StringIndexOutOfBoundsException ex) {

                }
            }
        } catch (IllegalStateException | NoSuchElementException e) {
            // System.in has been closed
            System.out.println("System.in was closed");
        }

    }
}
