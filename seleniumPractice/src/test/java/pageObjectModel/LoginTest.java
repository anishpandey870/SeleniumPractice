package pageObjectModel;

import com.seleniumProject.LoginPage;
import com.seleniumProject.LoginPage2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

//without using page factory
public class LoginTest {
    WebDriver driver;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
    }

    @Test
  public   void loginPage() {
        LoginPage lg = new LoginPage(driver);
        lg.setUserName("Admin");
        lg.set_password("admin123");
        lg.clickLogin();
        Assert.assertEquals(driver.getTitle(), "OrangeHRM");
    }

    @Test
    void loginPage2() {
        LoginPage2 ls = new LoginPage2(driver);
        ls.setText_user("Admin");
        ls.setText_password("admin");
        ls.loginClick();
        Assert.assertEquals(driver.getTitle(), "OrangeHRM");
    }

    @AfterClass
    void tearDown() {
        driver.close();
    }
}
