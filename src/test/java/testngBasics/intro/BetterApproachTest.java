package testngBasics.intro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BetterApproachTest {

    // With TestNg first we have to do is get rid of main method
    // TestNG provides us ability to turn any method in runnable test
    // When we create methods use either: camelCase or snake_case
    // To make a test case runnable we need to provide annotation "@Test"
    // Assert - is a check point where it will make sure that what we have as expected is aligning with reality
    @Test
    public void verifyLogoIsDisplayed() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
        Thread.sleep(5000);
        // Verify that logo is displayed
        WebElement logo = driver.findElement(By.cssSelector("img[alt=Google]"));
        boolean isLogoDisplayed = logo.isDisplayed();

//        if(isLogoDisplayed){
//            System.out.println("LOGO Verification: PASSED");
//        } else {
//            System.out.println("LOGO Verification: FAILED");
//        }

        // if statements for verification points are not the best approach
        // TestNG provides Assert class
        // An assertion is an approach to verify a condition that it meets the expectations.
        // Assertions are all about verifying that actual matches the expected.
        // Assertions will either pass or fail a test case.

        Assert.assertTrue(isLogoDisplayed);


        driver.quit();
    }

    @Test
    public void verifyPageTitle(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
        String actualPageTitle = driver.getTitle();
        String expectedPageTitle = "Google"; // The expected value is usually in your - ticket/user story/requirements

//        if(actualPageTitle.equals(expectedPageTitle)){
//            System.out.println("TITLE verification: PASSED");
//        } else {
//            System.out.println("TITLE verification: FAILED");
//        }

        Assert.assertEquals(actualPageTitle, expectedPageTitle);

        driver.quit();
    }


}
