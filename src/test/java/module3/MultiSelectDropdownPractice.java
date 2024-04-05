package module3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class MultiSelectDropdownPractice {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://dmytro-ch21.github.io/");
        Thread.sleep(2000);
        // Locate the multi-select dropdown
        WebElement dropdownWebElement = driver.findElement(By.id("multiSelect"));

        // Even it is multiselect we still have the select tag in it
        // means we can use Select class for it
        Select dropdown = new Select(dropdownWebElement);

        dropdown.selectByIndex(0);
        Thread.sleep(2000);

        dropdown.selectByValue("audi");
        Thread.sleep(2000);

        dropdown.selectByVisibleText("Mercedes");
        Thread.sleep(2000);



        // When it comes to multi-select dropdowns we have additional methods that we can utilize
        // All of these methods can be used specifically with multi select dropdown
        // If we try to use them on any single select dropdown we will get an exceptions
        List<WebElement> selectedOptions = dropdown.getAllSelectedOptions();

        dropdown.deselectAll(); // deselect all selected options
        dropdown.deselectByIndex(0);
        Thread.sleep(2000);

        dropdown.deselectByValue("audi");
        Thread.sleep(2000);

        dropdown.deselectByVisibleText("Mercedes");
        Thread.sleep(2000);


        driver.quit();
    }
}
