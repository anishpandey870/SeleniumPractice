package com.insin.base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.insin.util.TestUtil;
import org.apache.log4j.Logger;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {
    public static WebDriver driver;
    public static Properties pro;
    public Logger log = Logger.getLogger(TestBase.class);
    public ExtentReports extent = new ExtentReports();
    public ExtentSparkReporter spark = new ExtentSparkReporter("D:\\SelenumGit\\insinkerator\\testReport\\insin.html");

    public TestBase() {
        try {
            pro = new Properties();
            FileInputStream file = new FileInputStream("D:\\SelenumGit\\insinkerator\\src\\main\\java\\com\\insin\\config\\config.properties");
            pro.load(file);
        } catch (Exception e) {
            System.out.println("base config file not found");
        }
    }

    public void initialization() {
        String browserName = pro.getProperty("browser");
        if (browserName.equals("chrome")) {
            driver = new ChromeDriver();
        }
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

        driver.get(pro.getProperty("url"));
    }

}
