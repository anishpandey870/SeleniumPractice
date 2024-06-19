package seleniumTest;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class SignUPTest {
    WebDriver driver;

    @BeforeTest
    public void driver() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/");
    }

//    @Test
//    public void login() {
//        driver.findElement(By.name("email")).sendKeys("abc@gmail.com");
//        driver.findElement(By.id("pass")).sendKeys("abc@123");
//        driver.findElement(By.xpath("//button[text()='Log in']")).click();
//    }

    @Test
    public void signUp() {
        driver.findElement(By.xpath("//a[text()='Create new account']")).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Test(priority = 1)
    public void nameAndSurname() {
        WebElement uname = driver.findElement(By.name("firstname"));
        uname.clear();
        uname.sendKeys("Raju");
        //get attribute
        String attributeId = uname.getAttribute("id");
        System.out.println("this is username id attribute :" + attributeId);
        //get cssValue
        String css = uname.getCssValue("color");
        System.out.println("this is username Css value :" + css);
        driver.findElement(By.name("lastname")).sendKeys("Kumar");
    }


    @Test(priority = 2)
    public void dates() {
        //selecting day
        WebElement ele = driver.findElement(By.xpath("//select[@id='day']"));
        ele.click();
        List<WebElement> day = ele.findElements(By.xpath("./option"));
        for (WebElement days : day) {
            String d = days.getText();
            System.out.print(d + " ");
            if (d.equals("12")) {
                days.click();
            }
        }
        WebElement mon = driver.findElement(By.xpath("//select[@id='month']"));
        mon.click();

        List<WebElement> month = mon.findElements(By.xpath("./option"));
        for (WebElement months : month) {
            String m = months.getText();
            System.out.println(m + " ");
            if (m.equals("Jun")) {
                months.click();
            }
        }
        WebElement yr = driver.findElement(By.xpath("//select[@id='year']"));
        yr.click();
        List<WebElement> year = yr.findElements(By.xpath("./option"));
        for (WebElement years : year) {
            String y = years.getText();
            System.out.println(y + " ");
            if (y.equals("2024")) {
                years.click();
            }

        }

    }

    @Test(priority = 3)
    public void mobile() {
        WebElement mob = driver.findElement(By.xpath("//input[@name='reg_email__']"));
        mob.sendKeys("6788575978");
        //get location
        Point loc = mob.getLocation();
        System.out.println("location: " + loc);
        //get rectangle
        Rectangle rec= mob.getRect();
        System.out.println("rectangle: "+rec);
        //get tag name
        System.out.println("tag name: "+mob.getTagName());
        //isDisplayed
        System.out.println("displayed: "+mob.isDisplayed());
    }

    @Test(priority = 4)
    public void gender() throws InterruptedException {
        driver.findElement(By.xpath("//label[text()='Female']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//label[text()='Male']")).click();
    }

    @Test
    public void takeScreenSort() throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File SrcFile = ts.getScreenshotAs(OutputType.FILE);
        File DesFile = new File("C:\\Users\\anish\\IdeaProjects\\seleniumPractice\\loginSS\\loginSsort.png");
        FileHandler.copy(SrcFile, DesFile);
    }
}
