package seleniumTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;

public class LoginPage {
    WebDriver driver;

    @BeforeTest
    public void driver() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/");
    }

    @Test
    public void login() {
        driver.findElement(By.name("email")).sendKeys("abc@gmail.com");
        driver.findElement(By.id("pass")).sendKeys("abc@123");
        driver.findElement(By.xpath("//button[text()='Log in']")).click();
    }

    @Test
    public void forgetPassword() {
        //linkText
        driver.findElement(By.linkText("Forgotten password?")).click();
        //partial linkText
        //driver.findElement(By.partialLinkText("Forgotten")).click();
    }

    @Test
    public void keyboardPress() throws AWTException {
        Robot r = new Robot();
        r.keyPress(KeyEvent.VK_E);
        r.keyRelease(KeyEvent.VK_E);
        r.keyPress(KeyEvent.VK_A);
        r.keyRelease(KeyEvent.VK_A);
    }

    @Test
    public void mouseMove() throws AWTException {
        Robot rb = new Robot();
        rb.mouseMove(200, 400);
        rb.mouseWheel(2);

    }
}
