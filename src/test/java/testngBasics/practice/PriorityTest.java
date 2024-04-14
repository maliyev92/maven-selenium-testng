package testngBasics.practice;

import org.testng.annotations.Test;

/*
* TestNG by default will run the test in a class in alphabetical order
* If we need to control the order of execution we can add the priority property to test annotation
* It can start from any number and go up
* */

public class PriorityTest {

    @Test(priority = 0)
    public void addUser(){
        System.out.println("Adding user to list.");
    }

    @Test(priority = 1)
    public void modifyUser(){
        System.out.println("Modify existing user test.");
    }

    @Test(priority = 2)
    public void deleteUser(){
        System.out.println("Delete existing user from the list.");
    }


}
