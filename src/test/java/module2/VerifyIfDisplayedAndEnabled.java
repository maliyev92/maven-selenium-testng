package module2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class VerifyIfDisplayedAndEnabled {

    public static void main(String[] args) throws InterruptedException {

        // Simple login - for dev-hrm
        WebDriver driver = new ChromeDriver();
        // driver.manage().window().maximize();
        driver.get("http://dev-hrm.yoll.io/index.php/auth/login");
        Thread.sleep(1000);

        // Credentials
        String username = "yoll-student";
        String password = "Bootcamp5#";

        // Locating elements with cssSelector
        WebElement usernameInput = driver.findElement(By.cssSelector("#txtUsername"));
        WebElement passwordInput = driver.findElement(By.cssSelector("[name=txtPassword]"));
        WebElement loginButton = driver.findElement(By.cssSelector("#btnLogin"));

        Thread.sleep(1000);

        // Interact with elements
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();

        Thread.sleep(1000);

        // Locate the welcome message web element
        WebElement welcomeMessage = driver.findElement(By.cssSelector("#welcome"));

        // check if the element if displayed
        boolean isMessageDisplayed = welcomeMessage.isDisplayed(); // returns a true or false
        System.out.println("The welcome message is displayed: " + isMessageDisplayed);

        boolean isWelcomeElementEnabled = welcomeMessage.isEnabled(); // true or false
        System.out.println("The welcome element is enabled: " + isWelcomeElementEnabled);

        // Navigate to my info page and check if first name input is NOT enabled
        WebElement myInfoTab = driver.findElement(By.cssSelector("#menu_pim_viewMyDetails"));
        myInfoTab.click();

        Thread.sleep(4000);

        // check if first name input box is enabled


        WebElement firstNameInput = driver.findElement(By.cssSelector("#personal_txtEmpFirstName"));
        System.out.println("First Name Input Box Is Enabled: " + firstNameInput.isEnabled());

        // click on edit button
        WebElement editButton = driver.findElement(By.cssSelector("#btnSave"));
        editButton.click();
        Thread.sleep(4000);

        // check if first name input box is enabled
        System.out.println("First Name Input Box Is Enabled: " + firstNameInput.isEnabled());
        Thread.sleep(4000);

        driver.quit();

    }

}
