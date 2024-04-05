package module3;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

/*
* [X] Navigate to http://demo.automationtesting.in/Register.html
* [X] Locate the element for ‘firstname’
* [X] Pass your first name using sendkeys method
* [X] Move to ‘lastname’ field using Keys.TAB and enter the last name
* [X] Note: You can use Thread.sleep()
*/


public class DemoQAPractice {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("http://demo.automationtesting.in/Register.html");
        Thread.sleep(1000);

        WebElement firstNameInputBox = driver.findElement(By.cssSelector("[ng-model = 'FirstName']"));
        firstNameInputBox.sendKeys("Omar");
        Thread.sleep(1000);

        firstNameInputBox.sendKeys(Keys.chord(Keys.TAB, "",
                Keys.TAB, "123 Main Street, Main City, 12345, ST, USA",
                Keys.TAB, "omarramo@email.com",
                Keys.TAB, "123-321-1221"));
        Thread.sleep(1000);

        /* Interact with radio buttons and checkboxes */

        // TODO - Refactor and make a reusable method that clicks on radio buttons by value
//        WebElement maleRadioButton = driver.findElement(By.cssSelector("input[value=Male]"));
//        maleRadioButton.click();
//        Thread.sleep(3000);
//
//        WebElement femaleRadioButton = driver.findElement(By.cssSelector("input[value=FeMale]"));
//        femaleRadioButton.click();
//        Thread.sleep(3000);

        // Refactored code
        selectRadioButtonByValue(driver, "Male");
        Thread.sleep(2000);

        // TODO - Refactor this to have a reusable method
        // FIXME - Improve the logic of this code
        /* Select a checkbox */

//        WebElement moviesCheckbox = driver.findElement(By.cssSelector("input[value=Movies]"));
//        moviesCheckbox.click();
//        Thread.sleep(3000);
//
//        /* To unselect a checkbox you just need to click on it again */
//        moviesCheckbox.click();
//        Thread.sleep(3000);

        clickCheckboxByValue(driver, "Hockey");
        Thread.sleep(3000);

        clickCheckboxByValue(driver, "Movies");
        Thread.sleep(3000);


        /* How do we check which ones are selected - with isSelected() method */
        // Here we will locate each element separately and use isSelected() method to identify if the element is selected or not
        // The return of the method will be a boolean value true/false
        // TODO - Refactor so it is not hardcoded
        System.out.println("Radio Buttons from Gender selection:");
        System.out.println("Radio button Male is selected: " + driver.findElement(By.cssSelector("input[value=Male]")).isSelected());
        System.out.println("Radio button FeMale is selected: " + driver.findElement(By.cssSelector("input[value=FeMale]")).isSelected());

        System.out.println("Checkboxes from Hobbies selection: ");
        System.out.println("Checkbox Cricket is selected: " + driver.findElement(By.cssSelector("input[value=Cricket]")).isSelected());
        System.out.println("Checkbox Movies is selected: " + driver.findElement(By.cssSelector("input[value=Movies]")).isSelected());
        System.out.println("Checkbox Hockey is selected: " + driver.findElement(By.cssSelector("input[value=Hockey]")).isSelected());

        Thread.sleep(3000);

        driver.quit();

    }

    // Option 1
//    public static void clickCheckboxByValue(WebDriver driver, String type){
//        List<WebElement> hobbiesOptions = driver.findElements(By.cssSelector("input[type=checkbox]"));
//        for (WebElement option: hobbiesOptions){
//            String actualValue = option.getAttribute("value");
//            if(actualValue.equalsIgnoreCase(type)){
//                option.click();
//                break;
//            }
//        }
//    }

    // Option 2
    public static void clickCheckboxByValue(WebDriver driver, String value){
        WebElement option = driver.findElement(By.cssSelector("input[value="+value+"]"));
        option.click();
    }


    public static void selectRadioButtonByValue(WebDriver driver, String type){
       List<WebElement> genderRadioButtons =  driver.findElements(By.cssSelector("input[type=radio]"));
       switch (type.toLowerCase()){
           case "male":
               genderRadioButtons.get(0).click();
               break;
           case "female":
               genderRadioButtons.get(1).click();
               break;
           default:
               throw new IllegalArgumentException("There is no radio button with such value: " + type);
       }
    }

}
