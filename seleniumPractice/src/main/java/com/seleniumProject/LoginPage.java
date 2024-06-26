package com.seleniumProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//without using page factory
public class LoginPage {
    WebDriver driver;

    //constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    //locators
    By text_user = By.xpath("//input[@name='username']");
    By text_password = By.xpath("//input[@name='password']");
    By btn_login = By.xpath("//button[text()=' Login ']");

    //action
    public void setUserName(String user) {
        driver.findElement(text_user).sendKeys(user);
    }

    public void set_password(String password) {
        driver.findElement(text_password).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(btn_login).click();
    }
}
