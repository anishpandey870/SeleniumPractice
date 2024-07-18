package com.insin.testCases;

import com.insin.base.TestBase;
import com.insin.pages.Commercial;
import com.insin.pages.HomePage;
import com.insin.pages.Residential;
import com.insin.util.TestUtil;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.awt.*;

@Listeners(com.insin.listener.Listener.class)
public class HomePageTest extends TestBase {
    HomePage homePage;
    Residential residential;
    Commercial commercial;

    public HomePageTest() {
        super();
    }

    @BeforeMethod
    public void setup() {
        initialization();
        homePage = new HomePage();
        residential = new Residential();
        commercial = new Commercial();
    }

    @Test(priority = 1)
    public void validateTitle() {
        log.info(" get title from homepageTest class....");
        String title = homePage.verifyTitle();
        Assert.assertEquals(title, "World's Best Food Waste Disposers | InSinkErator IN", "title not matched");
    }


    @Test(priority = 3)
    public void verifyProductIcon() throws InterruptedException {
        log.info("this verifyProductIcon method ");
        Thread.sleep(300);
        homePage.iconProduct();

    }

    @Test(priority = 4)
    public void verifyProductBar() {
        log.info("this verifyProductBar method ");
        residential = homePage.productBar();
    }

    @Test(priority =7 )
    public void commercialPageTest() {
        log.info("commercial page  method call");
        commercial = homePage.commercialPage();
    }

    @Test(priority =8 )
    public void verifydisposerBar() {
        log.info("this verifydisposerBar method ");
        homePage.disposerBar();
    }

    @Test(priority = 2)
    public void clickFeedbackBox() {
        log.info("this for feed back method ");
        homePage.getFeedbackBox();
    }

    //  @Test
//    public void verifyContactUs() throws AWTException, InterruptedException {
//        log.info("homepage test method invoking");
//        homePage.states_list("acb@gmail.com", "raju", "kumar", "acb@gmail.com", "8996895868", "Goa", "this first msg", "68");
//    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
