package module3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CustomDropdowns {

    public static void main(String[] args) throws InterruptedException {

        // set up
        WebDriver driver = new ChromeDriver();
        // driver.manage().window().maximize();

        // We need to interact with a custom dropdown
        // These types of dropdowns do not have <select> tag
        // Means, we will need a custom strategy on how to interact with such dropdowns
        // - sometimes these are not exactly dropdowns but kind of side bars
        // - however, the logic remains the same, the options(menu) will be activated when we click on some buttons/links etc...

        // For, our case we will need to click on Apple products from Brands Option.
        // To do that we will need to follow this flow:
        // 1. Navigate to BestBuy homepage
        // 2. Click on Hamburger button
        // 3. Click on Brands Option from the menu
        // 4. Click on Apple option from the other menu

        // 1. Navigate to BestBuy homepage
        driver.get("https://www.bestbuy.com/");

        // 2. Click on Hamburger button
        WebElement hamburgerButton = driver.findElement(By.cssSelector(".hamburger-menu-button"));
        hamburgerButton.click();
        Thread.sleep(5000);

        // 3. Click on Brands Option from the menu
        WebElement brandsOption = driver.findElement(By.xpath("//button[text() = 'Brands']"));
        brandsOption.click();
        Thread.sleep(5000);

        // 4. Click on Apple option from the other menu
        WebElement appleBrand = driver.findElement(By.cssSelector("a[data-lid = 'ubr_shp_apl']")); // cssSelector is a bit faster
        appleBrand.click();
        Thread.sleep(5000);

        driver.quit();


    }

}
