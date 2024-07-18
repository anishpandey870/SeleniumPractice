package com.insin.pages;

import com.insin.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WasteDisposer extends TestBase {
    public WasteDisposer() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[text()='Solution']")
    WebElement solution;

    public String validateDisposerPage() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return driver.getTitle();
    }

    public void clickSolution() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        solution.click();
    }

}
