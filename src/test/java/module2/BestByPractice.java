package module2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BestByPractice {

    public static void main(String[] args) throws InterruptedException {

        // create a driver object
        WebDriver driver = new ChromeDriver();

        // navigate to best by
        driver.get("https://www.bestbuy.com/");

        // --------------- Locate the element we want to interact with -------------//
        WebElement searchInputBox = driver.findElement(By.className("search-input"));
        //WebElement searchButton = driver.findElement(By.className("header-search-button"));
        WebElement searchButton = driver.findElement(By.xpath("//*[@aria-label='Search']"));
        // --------------- Do the actions with these elements -------------//
        searchInputBox.clear();
        searchInputBox.sendKeys("iPhone 15");
        Thread.sleep(5000);

        searchButton.click();
        Thread.sleep(4000);

        String currentUrl = driver.getCurrentUrl();
        System.out.println("Current URL: " + currentUrl);

        if(currentUrl.contains("searchpage")){
            System.out.println("TEST: PASS");
        } else {
            System.out.println("TEST: FAIL");
        }

        driver.quit();




    }

}
