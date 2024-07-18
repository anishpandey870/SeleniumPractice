package com.insin.pages;

import com.insin.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Residential extends TestBase {


    public Residential() {
        log.info("invoking residential the page factory");
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[normalize-space()='Download Range Brochure']")
    WebElement rangeBrochure;

    public String validateResidentialPage() {
        return driver.getTitle();
    }

    public void rangeBrochure() {
        log.info("clicking on range brochure box...");
        rangeBrochure.click();
    }
}
