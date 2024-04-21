package testngBasics.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class SauceDemoLoginTest {

    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        /*Setup*/
        driver = new ChromeDriver();
        // maximize
        driver.get("https://www.saucedemo.com/");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    /*
     * A method marked as a data provider will return a 2D array of Objects
     * This will contain the data sets for our test case
     * We can be flexible with count of rows and columns   *
     * Column represent how many data arguments we need to provide for execution
     * Rows represent how many times the test will be executed with different sets of data
     * */
    @DataProvider(name = "loginCredentials")
    public Object[][] dataSet(){
        Object[][] data = {
                {"standard_user", "secret_sauce"},
                {"problem_user", "secret_sauce"},
                {"performance_glitch_user", "secret_sauce"},
                {"error_user","secret_sauce"},
                {"visual_user","secret_sauce"}
        };
        return data;
    }

    @Test(dataProvider = "loginCredentials")
    public void testLoginWithValidCredentials(String username, String password) throws InterruptedException {
        /*Locate the elements*/
        WebElement usernameInputBox = driver.findElement(By.id("user-name"));
        WebElement passwordInputBox = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login-button"));
        /*Interact with elements*/
        usernameInputBox.sendKeys(username);
        passwordInputBox.sendKeys(password);
        Thread.sleep(2000);
        loginButton.click();
        Thread.sleep(2000);
        String actualUrl = driver.getCurrentUrl();
        String expectedEndpoint = "/inventory.html";
        Assert.assertTrue(actualUrl.endsWith(expectedEndpoint), "Login validation failed");
    }


}