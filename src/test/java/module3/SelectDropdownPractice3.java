package module3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectDropdownPractice3 {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        // driver.manage().window().maximize();
        driver.get("https://demo.automationtesting.in/Register.html");

        // Select an option in skills dropdown
        WebElement skillsDropdownWebElement = driver.findElement(By.id("Skills"));
        Select skillsDropdown = new Select(skillsDropdownWebElement);
        skillsDropdown.selectByVisibleText("Mac");
        //Thread.sleep(5000);

        // How to programmatically understand what option has been selected
        // The first option is by utilizing the method from select object
        // getFirstSelectedOption will throw an exception if none options are selected
        // getFirstSelectedOption() will do return first one out of multiple if applied
        // Even though the getFirstSelectedOption suggests that will return 'first selected'
        // When working with Single select dropdowns it will actually return the option that is currently selected.
        // Option 1:
        WebElement selectedOption = skillsDropdown.getFirstSelectedOption(); // returns the option as a WebElement
        // what is the output:
        // 1. Exception
        // 2. Nothing
        // 3. First Option Adobe ...
        // 4. Select Skills
        System.out.println("Option 1 check if selected:");
        System.out.println("Selected Option Is: " + selectedOption.getText());

        Thread.sleep(1000);

        // Options 2:
        // We also can utilize the isSelected() method
        // The only challenge here is that you need to locate the element first and make sure it is present on the page
        System.out.println("Option 2 check if selected:");

        // TODO - Create reusable method that checks if an option is selected or not based on visibleText

        WebElement macOption = driver.findElement(By.xpath("//select[@id = 'Skills']/option[text() = 'Mac']"));
        System.out.println("Mac option is selected: " + macOption.isSelected());
        Thread.sleep(1000);

        boolean isJavaSelected = driver.findElement(By.xpath("//select[@id = 'Skills']/option[text() = 'Java']")).isSelected();
        System.out.println("Java option is selected: " + isJavaSelected);

        driver.quit();

    }
}
