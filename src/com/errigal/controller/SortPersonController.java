package com.errigal.controller;

import com.errigal.model.Person;
import com.errigal.util.Constant;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>Class used for sorting the users</p>
 */
public class SortPersonController extends BasePersonController {


    public SortPersonController(){}

    //sort by first name
    public Map<Integer,Person> sortPersonByFirstName(Map<Integer,Person> personMap){
        List<Person> personList = personService.sortUsersByFirstNameAsc(personMap);

        Map<Integer,Person> sortedMap = new LinkedHashMap<>();
        for(Person person:personList){
            sortedMap.put(person.getId(),person);
        }

        System.out.println(Constant.SORT_ON_FIRST_NAME_ASC);
        return sortedMap;
    }

    // sort by last name
    public Map<Integer,Person> sortPersonByLastName(Map<Integer,Person> personMap){
        List<Person> personList = personService.sortUsersByLastNameAsc(personMap);

        Map<Integer,Person> sortedMap = new LinkedHashMap<>();
        for(Person person:personList){
            sortedMap.put(person.getId(),person);
        }
        System.out.println(Constant.SORT_ON_LAST_NAME_ASC);
        return sortedMap;
    }

}
