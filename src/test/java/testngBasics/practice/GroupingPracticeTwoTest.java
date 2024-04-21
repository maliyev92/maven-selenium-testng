package testngBasics.practice;

import org.testng.annotations.Test;

public class GroupingPracticeTwoTest {

    @Test(groups = {"regression"})
    public void test_case_seven(){
        System.out.println("Test case Seven running..");
    }

    @Test(groups = {"regression"})
    public void test_case_eight(){
        System.out.println("Test case Eight running..");
    }

}