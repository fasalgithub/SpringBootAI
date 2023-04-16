package com.example.exception.GlobalException.customexception;

public class InvalidDateException extends Exception
{
    public InvalidDateException(){
        super();
    }
    public InvalidDateException(String msg){
        super(msg);
    }
}
