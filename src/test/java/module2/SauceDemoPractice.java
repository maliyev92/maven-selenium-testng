package module2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

/*
Given the user is on the login page of "https://www.saucedemo.com/"
When the user logs in with valid credentials (username: "standard_user", password: "secret_sauce")
And navigates to the product listing page
And selects "Sauce Labs Backpack" from the product list
And adds the selected product to the shopping cart
And selects "Sauce Labs Bolt T-Shirt" from the product list
And adds the selected product to the shopping cart
And then navigates to the shopping cart page
Then the user should see exactly 2 items in the cart
And the console output should validate the success by outputting "TEST: PASSED"
*/

public class SauceDemoPractice {

    public static void main(String[] args) throws InterruptedException {

        // create a driver
        WebDriver driver = new ChromeDriver();
        String url = "https://www.saucedemo.com/";
        driver.get(url);

        // maximize window
        driver.manage().window().maximize(); // full screen

        // locate web elements for login
        WebElement usernameInput = driver.findElement(By.xpath("//input[@data-test = 'username']"));
        WebElement passwordInput = driver.findElement(By.xpath("//input[@placeholder = 'Password']"));
        WebElement loginButton = driver.findElement(By.xpath("//input[@value = 'Login']"));

        // interact with elements
        String username = "standard_user", password = "secret_sauce";
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();

        Thread.sleep(3000);

        // print in the console the current url
        String currentUrl = driver.getCurrentUrl();
        System.out.println("URL after log in: " + currentUrl);

        WebElement sauceLabsBackpackAddToCartButton = driver.findElement(By.xpath("//button[@id = 'add-to-cart-sauce-labs-backpack']"));
        sauceLabsBackpackAddToCartButton.click();

        Thread.sleep(3000);

        WebElement sauceLabsTShirtAddToCartButton = driver.findElement(By.xpath("//button[@name = 'add-to-cart-sauce-labs-bolt-t-shirt']"));
        sauceLabsTShirtAddToCartButton.click();

        Thread.sleep(3000);

        // locate the cart button
        WebElement cartButton = driver.findElement(By.xpath("//a[@class = 'shopping_cart_link']"));
        cartButton.click();

        Thread.sleep(3000);

        // verify that cart contains 2 items only
        List<WebElement> productsInCart = driver.findElements(By.xpath("//div[@class = 'cart_item']")); // 1

        // how do we verify
        int expectedItemsInCart = 2;
        int actualItemsInCart = productsInCart.size();

        if(expectedItemsInCart == actualItemsInCart){
            System.out.println("TEST: PASSED");
            System.out.println("Expected items in the cart: " + expectedItemsInCart);
            System.out.println("Actual items in the cart: " + actualItemsInCart);
        } else {
            System.err.println("TEST: FAILED");
            System.err.println("Expected items in the cart: " + expectedItemsInCart);
            System.err.println("Actual items in the cart: " + actualItemsInCart);
        }


        driver.quit();

    }

}
