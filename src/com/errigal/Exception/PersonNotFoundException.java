package com.errigal.Exception;

import com.errigal.util.Constant;

public class PersonNotFoundException extends Exception{
    public PersonNotFoundException(String message){
        System.out.println(message);
    }
}
