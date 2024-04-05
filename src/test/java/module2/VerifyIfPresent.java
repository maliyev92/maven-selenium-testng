package module2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class VerifyIfPresent {

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
        //loginButton.click();

        Thread.sleep(1000);

        // Verify if a logo is present on the page after we log in
        // Locate the logo
        // xpath -> //img[contains(@src, 'yoll-logo')]
        // cssSelector -> img[src *= yoll-logo]
        // When an exception is thrown the execution of code stops there
        // FIXME - Bad approach to verify if an element is present
        // Option 1
        // WebElement logo = driver.findElement(By.cssSelector("img[src *= yoll-logo]")); // at this like findElement() throws an exception
        // System.out.println("Logo is present on the screen");

        // The better approach is to make the code not fail when the element is not present.
        // findElement - if not found any it will throw an exception
        // findElements - if not found the list will be empty but no exception will be thrown
        // Option 2
        // When we provide a proper element locator of the logoo there should be one element located
        // Otherwise it will be 0
        //List<WebElement> logoList = driver.findElements(By.cssSelector("img[src *= yoll-logo]"));
        //System.out.println("Elements found: " + logoList.size());

        //if(logoList.size() == 1){
        //    System.out.println("Logo verification PASSED");
        //} else {
        //    System.out.println("Logo verification FAILED");
        //}

        // Refactor - Option 3
        boolean isLogoPresent = driver.findElements(By.cssSelector("img[src *= yoll-logo]")).size() == 1;
        System.out.println("Logo verification test passed: " + isLogoPresent);

        driver.quit();

    }
}
