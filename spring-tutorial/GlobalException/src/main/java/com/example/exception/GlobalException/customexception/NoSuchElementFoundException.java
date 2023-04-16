package com.example.exception.GlobalException.customexception;

public class NoSuchElementFoundException extends Exception
{
   public NoSuchElementFoundException(){
        super();
    }
    public NoSuchElementFoundException(String msg){
        super(msg);
    }
}
