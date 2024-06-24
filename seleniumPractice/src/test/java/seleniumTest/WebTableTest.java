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
//doubt
        List<WebElement> cell=driver.findElements(By.xpath("//table[@name='BookTable']//tr|//td"));
        System.out.println("cell in table :" + cell.size());

    }
}
