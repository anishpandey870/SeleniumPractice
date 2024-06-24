package seleniumTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PageAlignedVAlidation {
    WebDriver driver;

    @BeforeTest
    public void driver() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/");
    }

    @Test
    public void login() {
        WebElement em = driver.findElement(By.name("email"));
    //    int ux = em.getLocation().getX();
        int uy= em.getLocation().getY();
        System.out.println("this username y coordinate :"+uy);
//        int uh = em.getSize().getHeight();
//        int uw = em.getSize().getWidth();

        WebElement pwd = driver.findElement(By.id("pass"));
    //    int px = pwd.getLocation().getX();
        int py= pwd.getLocation().getY();
        System.out.println("this pwd y coordinate :"+py);
//        int ph = pwd.getSize().getHeight();
//        int pw = pwd.getSize().getWidth();

        if (uy==py) {
            System.out.println("Both username and password fields are displayed in the same row");
        } else {
            System.out.println("username and password fields are NOT aligned in the same row");
        }
    }
}
