package stepsDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class Steps {
    WebDriver driver;

    @Given("the user is on the nopcommerce login page")
    public void navigateToLogin_page() {
        driver = new ChromeDriver();
        driver.get("https://demo.nopcommerce.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//a[text()='Log in']")).click();

    }

    @When("the user enter valid credentials\\(username:{string},password:{string})")
    public void the_user_enter_valid_credentials_username_password(String user, String pwd) {
        driver.findElement(By.xpath("//input[@id='Email']")).sendKeys(user);
        driver.findElement(By.xpath("//input[@id='Password']")).sendKeys(pwd);
    }

    @When("the user click on login button")
    public void the_user_click_on_login_button() {
        driver.findElement(By.xpath("//button[text()='Log in']")).click();
    }

    @Then("the user should be redirected to the My Account page")
    public void the_user_should_be_redirected_to_the_my_account_page() {
        boolean status = driver.findElement(By.xpath("//a[text()='My account']")).isDisplayed();
        Assert.assertEquals(status, true);
    }

    @Then("the user should see the welcome message")
    public void the_user_should_see_the_welcome_message() {
        boolean wel = driver.findElement(By.xpath("//h2[text()='Welcome to our store']")).isDisplayed();
        Assert.assertEquals(wel, true);
        driver.quit();
    }


}
