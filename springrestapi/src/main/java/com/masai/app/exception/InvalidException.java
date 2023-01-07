package com.masai.app.exception;

public class InvalidException extends RuntimeException{

    public InvalidException(){}
    public InvalidException(String msg){
        super(msg);
    }

}
