package com.insin.pages;

import com.insin.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Commercial extends TestBase {
    public Commercial() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[normalize-space()='Download Range Brochure']")
    WebElement commercialBrochure;


    public void verifyCommercialBrochure(){
     commercialBrochure.click();
    }

}
