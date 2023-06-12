package com.example.globalexception.service;

import com.example.globalexception.myownexception.CoreException;
import org.springframework.stereotype.Controller;


public class CoreService
{
    public void exceptionThrow()
    {
      throw new CoreException("problem with ur core");
    }
}
