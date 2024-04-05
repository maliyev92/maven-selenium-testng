package module3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SelectDropdownPractice {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        // driver.manage().window().maximize();

        driver.get("https://demo.automationtesting.in/Register.html");

        /*
        * Working with Select Dropdown
        * -- A select dropdown is one that has <select> tag in html
        * How dop we approach automating these dropdowns:
        * 1. Locate the dropdown itself
        * 2. Create a select type object
        * 3. ...
        * */

        // locate the dropdown
        WebElement dropdownWebElement = driver.findElement(By.id("Skills"));
        // Create a select type object
        Select dropdown = new Select(dropdownWebElement);
        Thread.sleep(3000);

        // by creating this object we get access to multiple useful methods that we can utilize

        // select an option by its index
        // remember, here options will start from index 0
        dropdown.selectByIndex(5);
        Thread.sleep(3000);

        // select by attribute value
        dropdown.selectByValue("C++");
        Thread.sleep(3000);

        // select by visible text - content - free text
        dropdown.selectByVisibleText("Java");
        Thread.sleep(3000);

        // How do we get access to all the options in my code
        // select class provides getOptions() method that returns a List<WebElements>

        List<WebElement> allOptions = dropdown.getOptions();

        System.out.println(allOptions.toString()); // toString()


        System.out.println("All Skills: ");
        // print all option's visible text to the console
        for(WebElement option: allOptions){
            System.out.println(option.getText());
        }

        driver.quit();


    }


}
