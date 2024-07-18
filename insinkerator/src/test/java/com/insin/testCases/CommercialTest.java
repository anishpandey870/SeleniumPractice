package com.insin.testCases;

import com.insin.base.TestBase;
import com.insin.pages.Commercial;
import com.insin.pages.HomePage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CommercialTest extends TestBase {
    HomePage homePage;
    Commercial commercial;

    public CommercialTest() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        initialization();
        homePage = new HomePage();
        commercial = new Commercial();
        homePage.commercialPage();
    }

    @Test(priority = 11)
    public void commercialBrochureTest() {
        log.info("this commercial RangeBrochure  method ....");
        commercial.verifyCommercialBrochure();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
