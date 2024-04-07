package testngBasics.practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// Assert class in TestNG is called - Hard Assert since it fails immediately.

public class AssertionTest {

    @Test
    public void verifyCondition(){

       /*
       * Assert.assertTrue(boolean condition, <Optional> String message)
       * We can pass an argument as boolean here only
       * The expression can be a boolean variable or the expression that evaluates to a boolean, isDisplayed(), 10>5
       * Additionally, we can provide a message what to show in case the assertion fails
       * It is recommended to place a meaningful message since it will help you understand what went wrong
       * */

        int itemOnPage = 10;
        boolean itemsPresent = itemOnPage == 10;
        Assert.assertTrue(itemsPresent, "Items on page verification failed!"); // fail here

        String title = "Google";
        Assert.assertTrue(title.equals("Google"), "The title verification failed! Expected: Google, Actual: " + title);

    }

    @Test
    public void verifyConditionFalse(){
        // imagine you need to make sure that an element is not enabled
        // isEnabled() - true or false
        boolean buttonIsEnabled = false;
        Assert.assertFalse(buttonIsEnabled, "Button verification failed, it appears enabled!");
    }

    @Test
    public void verifyDbConnection(){
        // use case 1
        boolean isDbConnected = true;
        if(!isDbConnected){
            Assert.fail("The data base connection not successful.");
        }
        // Maturate a sql query that retrieves some data
        // code
    }

    @Test
    public void testFileProcessing(){
        // you need to read a file
        File file = new File("text.txt");
        try {
            Scanner scanner = new Scanner(file);
        } catch (FileNotFoundException e){
            Assert.fail("The file was not found!");
        }
        // code that uses the file
    }



}
