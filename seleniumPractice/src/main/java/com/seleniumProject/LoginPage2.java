package com.seleniumProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// using page factory
public class LoginPage2 {
    WebDriver driver;

    //constructor
    public LoginPage2(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //locator
    @FindBy(xpath = "//input[@name='username']")
    WebElement text_user;
    @FindBy(xpath = "//input[@name='password']")
    WebElement text_password;
    @FindBy(xpath = "//button[text()=' Login ']")
    WebElement btn_login;

    //action
    public void setText_user(String user) {
        text_user.sendKeys(user);
    }

    public void setText_password(String pwd) {

        text_password.sendKeys(pwd);
    }

    public void loginClick() {
        btn_login.click();
    }


}
