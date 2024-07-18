package com.crm.testcases;

import com.crm.base.TestBase;
import com.crm.page.AdminPage;
import com.crm.page.HomePage;
import com.crm.page.LoginPage;
import com.crm.page.PimPage;
import org.testng.Assert;
import org.testng.annotations.*;

@Listeners(iListener.IListenerTest.class)
public class HomePageTest extends TestBase {
    LoginPage loginPage;
    HomePage homePage;
    AdminPage adminPage;
    PimPage pimPage;

    public HomePageTest() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        initialization();
        log.info("invoke the setup method");
        loginPage = new LoginPage();
        adminPage = new AdminPage();
        pimPage = new PimPage();
        homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
    }

    @Test(priority = 1)
    public void verifyHomePageTitle() {
        log.info("inside verifyHomePageTitle method  ");
        String homePageTitle = homePage.verifyTitle();
        Assert.assertEquals(homePageTitle, "OrangeHRM", "homePage title not match");
    }

    @Test(priority = 2)
    public void verifyUser() {
        boolean ul = homePage.verifyUserLabel();
        Assert.assertTrue(ul);
    }

    @Test(priority = 3)
    public void verifyAdminLinkTest() {
        adminPage = homePage.clickOnAdmin();
    }

    @Test(priority = 4)
    public void verifyPimLink() {
        pimPage = homePage.clickOnPim();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
