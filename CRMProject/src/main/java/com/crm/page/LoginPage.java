package com.crm.page;

import com.crm.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase {
    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    //page factory
    @FindBy(name = "username")
    WebElement name;
    @FindBy(name = "password")
    WebElement password;
    @FindBy(xpath = "//button[text()=' Login ']")
    WebElement loginbtn;

    @FindBy(xpath = "//img[@alt='orangehrm-logo']")
    WebElement logo;

    //action
    public String validateTitle() {
        return driver.getTitle();
    }
    public boolean validateLogo(){
      return  logo.isDisplayed();
    }

    public HomePage login(String un, String pwd) {
        name.sendKeys(un);
        password.sendKeys(pwd);
        loginbtn.click();
        return new HomePage();
    }
}
