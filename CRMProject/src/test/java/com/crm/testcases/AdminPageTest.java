package com.crm.testcases;

import com.crm.base.TestBase;
import com.crm.page.AdminPage;
import com.crm.page.HomePage;
import com.crm.page.LoginPage;
import org.checkerframework.checker.units.qual.A;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Objects;

public class AdminPageTest extends TestBase {
    HomePage homePage;
    LoginPage loginPage;
    AdminPage adminPage;

    public AdminPageTest() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        initialization();
        loginPage = new LoginPage();
        homePage = new HomePage();
        adminPage = new AdminPage();
        homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
        adminPage = homePage.clickOnAdmin();
    }

    @Test
    public void verifyAdminLabelTest() {
        boolean label = adminPage.verifyAdminLabel();
        Assert.assertTrue(label);
    }
    @Test
    public void adminUserNameTest() throws InterruptedException {
     String user= adminPage.verifyAdminPageUserName(prop.getProperty("adminUserName"));
     Assert.assertEquals(user,"Raju","Admin user not matched");
    }

    @AfterClass
    public void tearDown() {
        driver.close();
    }
}
