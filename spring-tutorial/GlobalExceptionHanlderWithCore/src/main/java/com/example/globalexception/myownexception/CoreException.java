package com.example.globalexception.myownexception;

public class CoreException extends RuntimeException
{
    public CoreException(){
        super();
    }
    public CoreException(String msg){
        super(msg);
    }
}
