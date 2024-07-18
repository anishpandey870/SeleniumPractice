package com.insin.testCases;

import com.insin.base.TestBase;
import com.insin.pages.HomePage;
import com.insin.pages.WasteDisposer;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class WasteDisposerTest extends TestBase {
    HomePage homePage;
    WasteDisposer wasteDisposer;

    public WasteDisposerTest() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        initialization();
        homePage = new HomePage();
        wasteDisposer = new WasteDisposer();
        homePage.disposerBar();
    }

    @Test(priority = 9)
    public void validateDisposerPageTest() {
        log.info("this verify disposer title method ");
        String title = wasteDisposer.validateDisposerPage();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Assert.assertEquals(title, "Change Today's Food Waste Disposal System | InSinkErator IN");
    }
    @Test(priority = 10)
    public void clickSolutionTest(){
        log.info("this for solution method ");
        wasteDisposer.clickSolution();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
