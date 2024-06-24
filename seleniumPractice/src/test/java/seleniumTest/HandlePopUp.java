package seleniumTest;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HandlePopUp {
    WebDriver driver;

    @BeforeTest
    public void driver() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/alerts");
        Thread.sleep(2000);
        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,700)");
        Thread.sleep(2000);
    }

    @Test
    public void alterPopUp() throws InterruptedException {
        driver.findElement(By.id("alertButton")).click();
        Thread.sleep(2000);
      Alert al= driver.switchTo().alert();
        Thread.sleep(2000);
        al.accept();
    }
    @Test
    public void confirmationPopUp() throws InterruptedException {
        driver.findElement(By.id("confirmButton")).click();
        Thread.sleep(2000);
        Alert al= driver.switchTo().alert();
        Thread.sleep(2000);
        al.accept();
        //for dismiss
     //   al.dismiss();
    }
    @Test
    public void alert_PromptPopUp() throws InterruptedException {
        driver.findElement(By.id("promtButton")).click();
        Thread.sleep(2000);
        Alert al= driver.switchTo().alert();
        Thread.sleep(2000);
        al.sendKeys("anish");
        Thread.sleep(2000);
        al.accept();
        //for dismiss
        //   al.dismiss();
    }
    ////a[text()='Menu']


}
