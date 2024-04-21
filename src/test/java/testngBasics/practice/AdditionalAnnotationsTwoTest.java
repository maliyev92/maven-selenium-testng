package testngBasics.practice;

import org.testng.annotations.*;

public class AdditionalAnnotationsTwoTest extends TestBase {

    @Test
    public void test_case_three(){
        System.out.println("I am test case THREE");
    }

    @Test
    public void test_case_four(){
        System.out.println("I am test case FOUR");
    }

}