package testngBasics.intro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*
* First of all problem with the old approach we have used was that we would place the scripts all in main method
* - This is not efficient from many standpoints
*
* Also, the if statements printing if a test passed or failed is fairly useless
* - We need a better approach that will let us know if tests failed or passed
*
* */


public class BadApproach {

    public static void main(String[] args) throws InterruptedException {

        /*
        * Navigate to google search page
        * Verify that logo is displayed
        * Verify the PageTitle is - Google
        * */

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");

        Thread.sleep(5000);


        // Verify that logo is displayed

        WebElement logo = driver.findElement(By.cssSelector("img[alt=Googleqww]"));
        boolean isLogoDisplayed = logo.isDisplayed();

        if(isLogoDisplayed){
            System.out.println("LOGO Verification: PASSED");
        } else {
            System.out.println("LOGO Verification: FAILED");
        }


        // Verify the PageTitle is - Google

        String actualPageTitle = driver.getTitle();
        String expectedPageTitle = "Google"; // The expected value is usually in your - ticket/user story/requirements

        if(actualPageTitle.equals(expectedPageTitle)){
            System.out.println("TITLE verification: PASSED");
        } else {
            System.out.println("TITLE verification: FAILED");
        }

        driver.quit();

    }

}


























