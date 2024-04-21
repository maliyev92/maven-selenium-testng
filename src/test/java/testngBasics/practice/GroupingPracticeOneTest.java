package testngBasics.practice;

import org.testng.annotations.Test;

public class GroupingPracticeOneTest {

    @Test(groups = {"brokenTest"})
    public void test_case_one(){
        System.out.println("Test case One running..");
    }

    @Test(groups = {"regression"})
    public void test_case_two(){
        System.out.println("Test case Two running..");
    }

    @Test(groups = {"regression"})
    public void test_case_three(){
        System.out.println("Test case Three running..");
    }

    @Test(groups = {"regression"})
    public void test_case_four(){
        System.out.println("Test case Four running..");
    }

    @Test(groups = {"regression"})
    public void test_case_five(){
        System.out.println("Test case Five running..");
    }

    @Test(groups = {"brokenTest"})
    public void test_case_six(){
        System.out.println("Test case Six running..");
    }

    @Test(groups = {"regression"})
    public void test_logout(){
        // code
    }

}