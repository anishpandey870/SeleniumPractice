package com.insin.pages;

import com.insin.base.TestBase;
import com.insin.util.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.beans.Transient;

public class HomePage extends TestBase {
    TestUtil testUtil;

    public HomePage() {
        log.info("invoking homepage the page factory");
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//img[@title='InSinkErator']")
    WebElement product_icon;
    @FindBy(xpath = "(//span[text()='Products'])[2]")
    WebElement productBar;
    @FindBy(xpath = "//a[text()='Residential']")
    WebElement residential;
    @FindBy(linkText = "Commercial")
    WebElement commercial;

    @FindBy(xpath = "(//span[text()='Support'])[2]")
    WebElement supportBar;

    @FindBy(xpath = "(//span[text()='Why Food Waste Disposers'])[2]")
    WebElement disposerBar;
    @FindBy(xpath = "(//div/a)[34]")
    WebElement leadChange;

@FindBy(xpath = "//div[text()='Feedback']")
WebElement feedback;
    //------------------------------------------------------------------------------------------
    @FindBy(xpath = "//input[@class='whsOnd zHQkBf' and @aria-label='Your email address']")
    WebElement email1;
    @FindBy(xpath = "//input[@class='whsOnd zHQkBf' and @aria-labelledby='i5']")
    WebElement first_name;
    @FindBy(xpath = "//input[@class='whsOnd zHQkBf' and @aria-labelledby='i9']")
    WebElement last_name;
    @FindBy(xpath = "//input[@class='whsOnd zHQkBf' and @aria-labelledby='i13']")
    WebElement email2;
    @FindBy(xpath = "//input[@class='whsOnd zHQkBf' and @aria-labelledby='i17']")
    WebElement mobile;
    @FindBy(xpath = "//div[@class='ry3kXd']/child::div[1]")
    WebElement states;

    @FindBy(xpath = "//textarea[@class='KHxj8b tL9Q4c' and @aria-label='Your answer']")
    WebElement message;
    @FindBy(xpath = "//input[@class='whsOnd zHQkBf' and @aria-labelledby='i29' ]")
    WebElement captcha;
    @FindBy(xpath = "//span[text()='Submit']")
    WebElement submit;

    public String verifyTitle() {
        log.info("returning get title....");
        return driver.getTitle();
    }

    public void iconProduct() throws InterruptedException {
        log.info(" get product icon....");
        boolean isVisible = product_icon.isDisplayed();
        System.out.println("Element is visible: " + isVisible);
        if (isVisible) {
            product_icon.click();
        } else {
            System.out.println("not found");
        }
        Actions as = new Actions(driver);
        as.moveToElement(product_icon).perform();
    }

    public Residential productBar() {
        Actions as = new Actions(driver);
        as.moveToElement(productBar).perform();
        as.moveToElement(residential).perform();
        residential.click();
        return new Residential();
    }
    public Commercial commercialPage(){
        Actions as = new Actions(driver);
        as.moveToElement(productBar).perform();
        as.moveToElement(commercial).perform();
        commercial.click();
        return new Commercial();
    }

    public void supportBar() {
        Actions as = new Actions(driver);
        as.moveToElement(supportBar).perform();
    }

    public void disposerBar() {
        Actions as = new Actions(driver);
        as.moveToElement(disposerBar).perform();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        leadChange.click();
    }
    public void getFeedbackBox(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        feedback.click();
    }


    public void states_list(String fEmail, String fName, String lName, String sEmail, String mob, String state, String msg, String cap) throws AWTException, InterruptedException {
        log.info("here states list method invoking");
        Robot rs = new Robot();
        rs.mouseWheel(35);
        Thread.sleep(5000);
        driver.switchTo().frame(0);
        Thread.sleep(5000);
        email1.sendKeys(fEmail);
        first_name.sendKeys(fName);
        last_name.sendKeys(lName);
        email2.sendKeys(sEmail);
        mobile.sendKeys(mob);

        Select sel = new Select(states);
        sel.selectByVisibleText(state);
        message.sendKeys(msg);
        captcha.sendKeys(cap);
        submit.click();
    }
}
