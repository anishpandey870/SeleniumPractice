package com.seleniumProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Calci {
    WebDriver driver;

    //constructor
    public Calci(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //locator
    @FindBy(xpath = "//input[@name='principal']")
    WebElement principle;
    @FindBy(xpath = "//input[@name='interest']")
    WebElement rate;
    @FindBy(xpath = "//input[@name='tenure']")
    WebElement period1;
    @FindBy(xpath = "//select[@name='tenurePeriod']")
    WebElement period2;
    @FindBy(xpath = "//select[@name='frequency']")
    WebElement feq;

    //clicked on calculate  return
    @FindBy(xpath = "//a[@onclick='return getfdMatVal(this);']")
    WebElement cal;
    @FindBy(xpath = "//span[@id='resp_matval']//strong")
    WebElement act_mval;

    // clicked on clear button
    @FindBy(xpath = "//img[@class='PL5']")
    WebElement clear;

    //action
    public void getPrinciple(String amt) {
        principle.sendKeys(amt);
    }

    public void getRate(String rat) {
        rate.sendKeys(rat);
    }

    public void getPeriod1(String peri1) {
        period1.sendKeys(peri1);
    }

    public void getPeriod2(String per2) {
        Select p2sel = new Select(period2);
    }

    public void getFeq(String fe) {
        Select feqsel = new Select(feq);
    }

    public void getCal() {
        cal.click();
    }

    public void getAct_mval() {
        act_mval.getText();
    }

    public void getClear() {
        clear.click();
    }


}
