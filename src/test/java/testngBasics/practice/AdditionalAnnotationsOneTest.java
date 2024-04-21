package testngBasics.practice;

import org.testng.annotations.*;

public class AdditionalAnnotationsOneTest extends TestBase{

    @Test
    public void test_case_one(){
        System.out.println("I am test case ONE.");
    }

    @Test
    public void test_case_two(){
        System.out.println("I am test case TWO.");
    }

}