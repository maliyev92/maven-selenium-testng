package testngBasics.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OrangeHrmTest {

//    Write a test method:
//    Navigate to OrangeHRM
//    Verify logo is displayed with assertTrue() method
//    Run your code with @Test annotation

    @Test
    public void verifyLogoIsDisplayed(){
        WebDriver driver = new ChromeDriver();
        driver.get("http://dev-hrm.yoll.io/index.php/auth/login");
        // Locate logo on OrangeHRM
        WebElement logo = driver.findElement(By.xpath("//div[@id = 'divLogo']/img[contains(@src, 'login/logo.png')]"));
        //boolean logoIsDisplayed = logo.isDisplayed();
        Assert.assertTrue(logo.isDisplayed(), "Logo verification failed.");
        driver.quit();
    }


//    Write a test method
//    Navigate to OrangeHRM
//    Get the Form Header
//    Fail the test if it is not equal to: LOGIN Panel
    @Test
    public void verifyPageTitle(){
        WebDriver driver = new ChromeDriver();
        driver.get("http://dev-hrm.yoll.io/index.php/auth/login");
        String actualPageTitle = driver.getTitle();
        String expectedPageTitle = "OrangeHRM";
        Assert.assertTrue(actualPageTitle.equals(expectedPageTitle), "Title verification failed!");
        driver.quit();
    }

}
