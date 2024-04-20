package testngBasics.practice;

import org.testng.Assert;
import org.testng.annotations.*;

public class CheckAnnotationAndOrderTest {

    @BeforeClass
    public void beforeClassMethod(){
        System.out.println("- Before class method executed.");
    }

    @AfterClass
    public void afterClassMethod(){
        System.out.println("- After class method executed.");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("--- Before method got executed");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("--- After method got executed");
    }

    @Test(priority = 0, enabled = true)
    public void testMethod1(){
        try{
            Assert.fail("Any reason");
        } catch (AssertionError e){
            System.out.println("Some assertion error");
        }

        System.out.println("----- Test method 1 executed");
    }

    @Test(priority = -1)
    public void testMethod2(){
        System.out.println("----- Test method 2 executed");
    }

    @Test(priority = 1)
    public void testMethod3(){
        System.out.println("----- Test method 3 executed");
    }

    @Test(priority = 2, enabled = true, dependsOnMethods = "testMethod1")
    public void testMethod4(){
        System.out.println("----- Test method 4 executed");
        simpleMethod();
    }

    public void simpleMethod(){
        System.out.println("Simple method got executed.");
    }


}
