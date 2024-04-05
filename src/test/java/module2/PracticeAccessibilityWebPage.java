package module2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*
* [X] Navigate to https://haltersweb.github.io/Accessibility/submit-disabling.html
* [X] Locate 'Submit' button and print on console that button is disabled (use getAttribute() method)
* [X] Print the text color of the Submit Button - "color"
* [X] Enter some text on first name free text field
* [X] Enter some text on last name free text field
* [X] Click anywhere on the page through automation to make submit button enabled
* [X] Locate 'Submit' button and print on console that button is enabled (use getAttribute() method)
* [X] Print the text color of the Submit Button again and compare the color values
*/

public class PracticeAccessibilityWebPage {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        // driver.manage().window().maximize();
        driver.get("https://haltersweb.github.io/Accessibility/submit-disabling.html");
        Thread.sleep(1000);

        /* Navigate to https://haltersweb.github.io/Accessibility/submit-disabling.html */
        WebElement submitButton = driver.findElement(By.xpath("//*[text()= 'Submit']"));
        // System.out.println("Submit Button Disabled: " + submitButton.isDisplayed());
        // After inspecting the html we noticed that the button that is not intractable doesn't have a disabled attribute
        // That's why the isEnabled() method will not give you a proper result
        // System.out.println(submitButton.isEnabled());
        // isEnabled() -

        /* Locate 'Submit' button and print on console that button is disabled (use getAttribute() method) */
        System.out.println("Submit Button Disabled: " + submitButton.getAttribute("aria-disabled"));

        /* Print the text color of the Submit Button - "color" */
        System.out.println("Submit Text Color: " + submitButton.getCssValue("color")); // rgba()

        /* Locate the elements */
        WebElement heading = driver.findElement(By.xpath("//h2[text() = 'Example Form']"));
        WebElement firstNameInputBox = driver.findElement(By.id("firstName"));
        WebElement lastNameInputBox = driver.findElement(By.id("lastName"));

        /* Interact with elements */
        /* Enter some text on first name free text field */
        firstNameInputBox.sendKeys("Test");
        Thread.sleep(1000);

        /* Enter some text on last name free text field */
        lastNameInputBox.sendKeys("Automan");
        Thread.sleep(1000);

        /* Click anywhere on the page through automation to make submit button enabled */
        heading.click();
        Thread.sleep(1000);

        /* Locate 'Submit' button and print on console that button is disabled (use getAttribute() method) */
        System.out.println("Submit Button Disabled: " + submitButton.getAttribute("aria-disabled"));

        /* Print the text color of the Submit Button - "color" */
        System.out.println("Submit Text Color: " + submitButton.getCssValue("color")); // rgba()


        driver.quit();

    }

}
