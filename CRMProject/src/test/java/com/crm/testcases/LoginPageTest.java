package com.crm.testcases;

import com.crm.base.TestBase;
import com.crm.page.HomePage;
import com.crm.page.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTest extends TestBase {
    LoginPage loginPage;
    HomePage homePage;

    public LoginPageTest() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        initialization();
        loginPage = new LoginPage();
    }

    @Test
    public void loginPageTest() {
        String title = loginPage.validateTitle();
        Assert.assertEquals(title, "OrangeHRM");
    }

    @Test
    public void logoTest(){
      boolean logo=  loginPage.validateLogo();
      Assert.assertTrue(logo);
    }

    @Test
    public void loginTest() {
      homePage=  loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
    }

    @AfterClass
    public void tearDown() {
        driver.close();
    }
}
