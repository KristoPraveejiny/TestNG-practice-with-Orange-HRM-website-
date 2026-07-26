package com.example;

import org.testng.annotations.Test;

public class driveacarpriority {
 
    @Test(priority=0)
    public void startcar() {
        System.out.println("Car started.");
    }

    @Test(priority=1)
    public void  firstgear(){
        System.out.println("Car is in first gear.");
    }

    @Test(priority=2)
    public void secondgear(){
        System.out.println("Car is in second gear.");
    }

    @Test(priority=3)
    public void thirdgear(){
        System.out.println("Car is in third gear.");
    }       

    @Test(priority=4)
    public void stopcar() {
        System.out.println("Car stopped.");
    }
    
}
