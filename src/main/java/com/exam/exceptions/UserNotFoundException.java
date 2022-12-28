package com.exam.exceptions;

public class UserNotFoundException extends Exception {

    public UserNotFoundException(String str){
        super(str);
    }

    public UserNotFoundException(){
        super("user not found");
    }
}
