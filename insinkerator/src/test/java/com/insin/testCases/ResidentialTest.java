package com.insin.testCases;

import com.insin.base.TestBase;
import com.insin.pages.HomePage;
import com.insin.pages.Residential;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(com.insin.listener.Listener.class)
public class ResidentialTest extends TestBase {

    HomePage homePage;
    Residential residential;

    public ResidentialTest() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        initialization();
        homePage=new HomePage();
        residential = new Residential();
        residential=homePage.productBar();
    }

    @Test(priority = 5)
    public void validateResidentialPageTest() {
        log.info(" get title from homepageTest class....");
        String title = residential.validateResidentialPage();
         Assert.assertEquals(title, "Modular Kitchen with Food Waste Disposer | InSinkErator IN", "title not matched");
    }

    @Test(priority = 6)
    public void verifyRangeBrochure() {
        log.info("this verifyRangeBrochure  method ....");
        residential.rangeBrochure();
    }
    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}
