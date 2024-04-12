package testngBasics.practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// Assert class in TestNG is called - Hard Assert since it fails immediately.

public class AssertionsTest {

    /*
     * Assert.assertTrue(boolean condition, <Optional> String message)
     * We can pass an argument as boolean here only
     * The expression can be a boolean variable or the expression that evaluates to a boolean, isDisplayed(), 10>5
     * Additionally, we can provide a message what to show in case the assertion fails
     * It is recommended to place a meaningful message since it will help you understand what went wrong
     * */
    @Test
    public void verifyCondition(){
        int itemOnPage = 10;
        boolean itemsPresent = itemOnPage == 10;
        Assert.assertTrue(itemsPresent, "Items on page verification failed!"); // fail here
        String title = "Google";
        Assert.assertTrue(title.equals("Google"), "The title verification failed! Expected: Google, Actual: " + title);
    }

    /*
    * Imagine you need to make sure that an element is not enabled
    * isEnabled() - true or false
    * We can use assertFalse to make sure that a boolean expression is false in order to pass the test
    * */
    @Test
    public void verifyConditionFalse(){
        boolean buttonIsEnabled = false;
        Assert.assertFalse(buttonIsEnabled, "Button verification failed, it appears enabled!");
    }

    /*
    * Assert.fail() will be used in some specific scenarios where we need to fail the test case intentionally
    * This can be used for various cases in automation:
    * - having a test case that connects to the db, the test case should fail if connection unsuccessful
    * - having a test case where we need to read or write an external file, the test case should fail if
    *   file not found or any other issues related to the file itself
    * */

    /*
    * Example with db connection
    * */
    @Test
    public void verifyDbConnection(){
        boolean isDbConnected = true;
        if(!isDbConnected){
            Assert.fail("The data base connection not successful.");
        }
        // automation ...
    }

    /*
     * Example with external file
     * */
    @Test
    public void testFileProcessing(){
        // you need to read a file
        File file = new File("src/test/resources/testData.txt");
        try {
            Scanner scanner = new Scanner(file);
        } catch (FileNotFoundException e){
            Assert.fail("The file was not found!");
        }
        // code that uses the file
    }

    /*
    * Assert.assertEquals() - this method will have two required arguments and it will check if both are equal()
    * The data type can be either - primitives or non primitives
    * Note: both arguments have to be of the same type
    * */
    @Test
    public void verifyEquality(){
//       // Two non primitives - strings
//       Assert.assertEquals("Hello", "Hello", "The strings are not equal!");
//
//       String actualUrl = "https://www.google.com/search";
//       String expectedUrl = "https://www.google.com/search";
//       Assert.assertEquals(actualUrl, expectedUrl, "The url verification failed.");
//
//       // You can do it with primitive data types as well
//       int num = 10;
//       int num2 = 10;
//       Assert.assertEquals(num, num2, "Integers are not the same!");

        /*
        * Here is an example where we create two string objects
        * And assertEquals() method will check their values not addresses
        * */
        String name = "Omar";
        String anotherName = new String("Omar");
        Assert.assertEquals(name, anotherName, "They are not equal!");
    }

    @Test
    public void verifyInequality(){
        String str1 = "Hello";
        String str2 = "hello";
        Assert.assertNotEquals(str1, str2, "There is a problem! The strings are actually equal!");
    }

    /*
    * AssertSame() does compare two objects if they are the same in terms the same memory space
    * It does work exactly the same as == (relational equality operator)
    * */
    @Test
    public void verifyIfSameObjects(){

        String str1 = "Student";
        String str2 = "Student";
        String str3 = "student";
        String str4 = new String("Student");

         Assert.assertSame(str1, str2); // true
        // Assert.assertSame(str2, str3); // fail
        //Assert.assertSame(str1, str4, "The str1 and str4 are not the same object!"); // fail
//        int num1 = 10;
//        int num2 = 10;
//        // == -> num1 == num2
//        Assert.assertSame(num1, num2);
    }

    @Test
    public void verifyIfNotTheSame(){
        String str1 = "Student";
        String str2 = "Student";
        String str4 = new String("Student");
        // Assert.assertNotSame(str1, str2); // fail
        Assert.assertNotSame(str1, str4); // pass
    }

    /*
    * We also can assert if an object is null or the opposite
    * */

    @Test
    public void verifyIfNull(){
        Object obj = null;
        Assert.assertNull(obj, "The object is not null!");
    }

    @Test
    public void verifyIfNotNull(){
        Object obj = new Object();
        Assert.assertNotNull(obj, "The object is actually null!");
    }




}
