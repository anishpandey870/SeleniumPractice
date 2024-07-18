package com.crm.page;

import com.crm.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends TestBase {


    public HomePage() {
        log.info("invoking the page factory");
        PageFactory.initElements(driver, this);
    }

    //page factory
    @FindBy(xpath = "//p[@class='oxd-userdropdown-name']")
    WebElement userLabel;
    @FindBy(xpath = "//span[text()='Admin']")
    WebElement adminLink;
    @FindBy(xpath = "//span[text()='PIM']")
    WebElement pimLink;

    //action
    public String verifyTitle() {
        log.info("returning get title....");
        return driver.getTitle();
    }

    public boolean verifyUserLabel() {
        return userLabel.isDisplayed();
    }

    public AdminPage clickOnAdmin() {
        adminLink.click();
        return new AdminPage();
    }

    public PimPage clickOnPim() {
        pimLink.click();
        return new PimPage();
    }

}
