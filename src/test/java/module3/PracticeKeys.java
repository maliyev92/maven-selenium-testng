package module3;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

/*
* [X] 1. Navigate to best-buy web application
* [X] 2. Locate the search bar
* [X] 3. In the search bar type IPhone 16
* [X] 4. Then Remove the digit 6 and type 5 Pro Max
* [X] 5. After inserting the 5 Pro Max, highlight all the text you have in the search bar
* [X] 6. Move to the beginning of the text with LEFT_ARROW keyboard action
* [X] 7. Delete the very first character and insert an small 'i'
* [X] 8. Then move down with ARROW_DOWN 4 times
* [X] 9. Then move up one time
* [X] 10. Click Enter key
* */

/*
* In automation, we will commonly get to some situations that we need to click on some keys on our keyboard
* E.g: ENTER, DELETE, BACK_SPACE, TAB
* This can be simply done with sendKeys() method to send the command and Keys.class to select a specific Keyboard action
* */

public class PracticeKeys {

    public static void main(String[] args) throws InterruptedException {

        // Upcasting - the process of assigning a subtype to a supertype
        // If you declare your driver as a specific driver class you limit your framework to one and only driver type (Chrome)
        // driver = new ChromeDriver();
        WebDriver driver = getDriver("Chrome");
        // maximize window
        /* Navigate to best buy app */
        driver.get("https://www.bestbuy.com/");
        /* Locate search bar */
        WebElement searchInputBox = driver.findElement(By.id("gh-search-input"));
        Thread.sleep(2000);

        /* In the search bar type IPhone 16 */
        searchInputBox.sendKeys("IPhone 16");
        Thread.sleep(2000);

        /* Then Remove the digit 6 and type 5 Pro Max */
        searchInputBox.sendKeys(Keys.BACK_SPACE);
        Thread.sleep(1000);
        searchInputBox.sendKeys("5 Pro Max");
        Thread.sleep(3000);

        /* After inserting the 5 Pro Max, highlight all the text you have in the search bar */
        /* To highlight everything we use a key binding - MAC: Command + a WIN: | Ctrl + a */
        // We have two options to do that:
        // Option 1: we can use concatenation to bind few strokes
        // The limitation here is that you can bind only one Keys.class + some string
        // You cannot connect 2 Keys.classes
        // searchInputBox.sendKeys(Keys.COMMAND + "a");
        // this will not work
        // searchInputBox.sendKeys(Keys.COMMAND + Keys.SHIFT);

        // Option 2: Use Keys.chrod() it will allow to provide comma separated multiple Keys and actions
        // searchInputBox.sendKeys(Keys.chord(Keys.COMMAND, Keys.CONTROL, Keys.BACK_SPACE));
        searchInputBox.sendKeys(Keys.chord(Keys.COMMAND, "a"));
        Thread.sleep(2000);

        /* Move to the beginning of the text with LEFT_ARROW keyboard action */
        searchInputBox.sendKeys(Keys.ARROW_LEFT);
        Thread.sleep(2000);

        /* Delete the very first character and insert an small 'i' */
        searchInputBox.sendKeys(Keys.DELETE);
        Thread.sleep(2000);

        searchInputBox.sendKeys("i");
        Thread.sleep(2000);

        /* Then move down with ARROW_DOWN 4 times */
        for (int i = 1; i <= 4 ; i++) {
            searchInputBox.sendKeys(Keys.ARROW_DOWN);
            Thread.sleep(1000);
        }

        /* Then move up one time */
        searchInputBox.sendKeys(Keys.ARROW_UP);
        Thread.sleep(1000);

        /* Click Enter */
        searchInputBox.sendKeys(Keys.ENTER);
        Thread.sleep(3000);

        driver.quit();

    }

    public static WebDriver getDriver(String browserType){
        switch (browserType){
            case "Firefox":
                return new FirefoxDriver();
            case "Safari":
                return new SafariDriver();
            default:
                return new ChromeDriver();
        }
    }

}
