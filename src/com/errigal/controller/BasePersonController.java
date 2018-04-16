package com.errigal.controller;

import com.errigal.service.PersonService;

/**
 * <p>Base class controller, intialises PersonService for accessing the object across Controllers</p>
 */
public class BasePersonController {

    public PersonService personService;

    public BasePersonController(){
        personService = new PersonService();
    }
}
