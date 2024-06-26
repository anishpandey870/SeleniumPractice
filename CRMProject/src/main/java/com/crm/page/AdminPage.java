package com.crm.page;

import com.crm.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminPage extends TestBase {

    //constructor
    public AdminPage() {
        PageFactory.initElements(driver, this);
    }

    //page factory
    @FindBy(xpath = "//h6[text()='User Management']")
    WebElement adminLabel;
    @FindBy(xpath = "//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@class='oxd-input oxd-input--active']")
    WebElement adminPageUserName;

    //action
    public boolean verifyAdminLabel() {
        return adminLabel.isDisplayed();
    }
    public String  verifyAdminPageUserName(String adminUser){
        adminPageUserName.sendKeys(adminUser);
        return adminUser;
    }

}
