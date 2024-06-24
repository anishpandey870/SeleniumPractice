package seleniumTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class WebTableTest {
    WebDriver driver;

    @Test
    public void tables() {
        driver = new ChromeDriver();
        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();
        //total number of row
        int row = driver.findElements(By.xpath("//table[@name='BookTable']//tr")).size();
        System.out.println("row in table :" + row);

        //total number of column
        int col = driver.findElements(By.xpath("//table[@name='BookTable']//th")).size();
        System.out.println("col in table :" + col);

        List<WebElement> cell = driver.findElements(By.xpath("//table[@name='BookTable']//tr//td"));
        System.out.println("cell in table :" + cell.size());

        //read the data from all row and column
        for (int r = 2; r <= row; r++) {
            for (int c = 1; c <= col; c++) {
                String value = driver.findElement(By.xpath("//table[@name='BookTable']//tr[" + r + "]//td[" + c + "]")).getText();
                System.out.print(value + " ");
            }
            System.out.println();
        }

        for (int r = 2; r <= row; r++) {
            String value = driver.findElement(By.xpath("//table[@name='BookTable']//tr[" + r + "]//td[4]")).getText();
            System.out.println("numeric data :" + value);
        }
    }
}
