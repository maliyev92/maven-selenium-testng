package testngBasics.practice;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

//Scenario: User should be able to add Job Title
//Given User is on homepage
//When User clicks on Admin→ Job → Job Titles
//Then User can see Add and Delete buttons are displayed
//When User can add a new Job Title
//Then newly Added Job Information is displayed in Table


public class OrangeHrmJobTitleTest {

    private WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        // maximize
        driver.get("http://dev-hrm.yoll.io/index.php/auth/login");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }


    @Test
    public void testUserCanAddJobTitle() throws InterruptedException {

        /* Login */
        login("yoll-student", "Bootcamp5#");

        // User clicks on Admin → Job → Job Titles
        WebElement adminTab = driver.findElement(By.id("menu_admin_viewAdminModule"));
        adminTab.click();

        WebElement jobTab = driver.findElement(By.id("menu_admin_Job"));
        jobTab.click();

        WebElement jobTitlesTab = driver.findElement(By.id("menu_admin_viewJobTitleList"));
        jobTitlesTab.click();
        // after this click we will be navigated to a different page
        Thread.sleep(2000);

        // Then User can see Add and Delete buttons are displayed
        WebElement addButton = driver.findElement(By.id("btnAdd"));
        WebElement deleteButton = driver.findElement(By.id("btnDelete"));

        Assert.assertTrue(addButton.isDisplayed(), "Add button verification failed!");
        Assert.assertTrue(deleteButton.isDisplayed(), "Delete button verification failed!");

        // User can add a new Job Title
        addButton.click();
        Thread.sleep(1000);

        WebElement jobTitleInputField = driver.findElement(By.id("jobTitle_jobTitle"));
        WebElement titleDescriptionInputField = driver.findElement(By.id("jobTitle_jobDescription"));

        // We need data that will be passed as test data
        // Preferably we can generate some data automatically

        // With Java Faker dependency we can generate mock data
        // We just create an object from Faker and we can get random, names, cities, countries, etc..
        Faker mockData = new Faker();
        String jobTitle = mockData.job().title();;
        String jobDescription = mockData.chuckNorris().fact();

        jobTitleInputField.sendKeys(jobTitle);
        titleDescriptionInputField.sendKeys(jobDescription);

        // click save button
        WebElement saveButton = driver.findElement(By.id("btnSave"));
        saveButton.click();

        // verify it is present in the table
        Thread.sleep(5000);

        List<WebElement> jobTitles = driver.findElements(By.xpath("//table[@id = 'resultTable']/tbody//td[2]"));

        boolean jobTitlePresent = false;

        for(WebElement currentJobTitle : jobTitles){
            if(currentJobTitle.getText().equals(jobTitle)){
                jobTitlePresent = true;
                break;
            }
        }

        Assert.assertTrue(jobTitlePresent, "Add job title verification failed!");

        // TODO - make a clean up, after you added the user now remove it.

    }


    public void login(String username, String password){
        WebElement userNameInput = driver.findElement(By.name("txtUsername"));
        WebElement passwordInput = driver.findElement(By.id("txtPassword"));
        WebElement loginButton = driver.findElement(By.id("btnLogin"));
        userNameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();
    }


}
