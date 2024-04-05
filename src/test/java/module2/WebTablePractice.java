package module2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class WebTablePractice {

    public static void main(String[] args) throws InterruptedException {

        // Create a web driver instance
        WebDriver driver = new ChromeDriver();
        // driver.manage().window().maximize();

        // navigate to the targeted web page
        driver.get("https://testautomationpractice.blogspot.com/");
        Thread.sleep(3000);

        // Instead of redoing the logic of identifying a specific cell data
        // We can create a reusable method that takes indices as parameters and print the data
        // This way we make our code more readable and concise while not duplicating the logic
        System.out.println("Cell data:");
        // Get the data from product table
        // 2 row 2 cell
        getDataByRowAndColumn(driver, 2,2);
        // Get the data from product table
        // 2 row 3 cell
        getDataByRowAndColumn(driver, 2,3);
        // Get the data from product table
        // 3 row 1 cell
        getDataByRowAndColumn(driver, 3,1);


        System.out.println("Whole column data:");
        getDataByColumnNumber(driver, "1");
        System.out.println("--------------------------");
        // get the data from the second column
        getDataByColumnNumber(driver, "2");
        System.out.println("--------------------------");
        // get the data from the third column
        getDataByColumnNumber(driver, "3");
        System.out.println("--------------------------");

        // Identify the author name by bookname
        WebElement authorNameElement = driver.findElement(By.xpath("//*[@name = 'BookTable']/tbody//td[text() = 'Master In Java']/../td[3]"));
        String authorName = authorNameElement.getText();
        System.out.println("The Author for Master In Java is: " + authorName);

        driver.quit();

    }

    // Create a reusable method that will return the data from the specified column
    public static void getDataByColumnNumber(WebDriver driver, String columnNumber){
        String dynamicXpath = "//*[@id = 'productTable']/tbody/tr/td["+columnNumber+"]";
        List<WebElement> columnData = driver.findElements(By.xpath(dynamicXpath));
        for(WebElement eachElement : columnData){
            String eachCellData = eachElement.getText();
            System.out.println(eachCellData);
        }
    }

    // Reusable method that will take two parameters row and column
    // Those params data will be used to build a dynamic xpath
    // The rule of static method: we cannot call directly any non static members
    public static void getDataByRowAndColumn(WebDriver driver, int row, int column){
        String dynamicXpath = "//*[@id = 'productTable']/tbody/tr[" + row + "]/td["+column+"]";
        WebElement cellData = driver.findElement(By.xpath(dynamicXpath));
        // Extract the content text from the element - getText() - returns a string
        String cellText = cellData.getText();
        System.out.println("The data in the row "+row+" and "+ column +" cell is: " + cellText);
    }

}
