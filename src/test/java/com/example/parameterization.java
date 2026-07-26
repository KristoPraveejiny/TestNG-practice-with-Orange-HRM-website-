package com.example;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class parameterization {


    @Test
    @Parameters("Name")
    public void printname(String name){
        System.out.println("My name is " + name);
    }
    
}
