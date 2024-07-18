package com.crm.base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.crm.util.TestUtil;
//import com.crm.util.WebEventListener;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {
    public static WebDriver driver;
    public static Properties prop;
    //    public static EventFiringWebDriver ev_driver;
//    public static WebEventListener eventListener;
    public static Logger log = Logger.getLogger(TestBase.class);
    public ExtentReports extent = new ExtentReports();
    public ExtentSparkReporter spark = new ExtentSparkReporter("D:\\SelenumGit\\CRMProject\\src\\test\\reports\\orangeReport.html");
    ExtentTest test;

    public TestBase() {
        try {
            prop = new Properties();
            FileInputStream ip = new FileInputStream("D:\\SelenumGit\\CRMProject\\src\\main\\java\\com\\crm\\config\\config.properties");
            prop.load(ip);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void initialization() {
        String browserName = prop.getProperty("browser");
        log.info("Browser launch" + prop.getProperty("browser"));
        if (browserName.equals("chrome")) {
            driver = new ChromeDriver();
        }

//        ev_driver = new EventFiringWebDriver(driver);
//        // Now create object of EventListerHandler to register it with EventFiringWebDriver
//        eventListener = new WebEventListener();
//        ev_driver.register(eventListener);
//        driver = ev_driver;

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

        driver.get(prop.getProperty("url"));
        log.info("entering application url :" + prop.getProperty("url"));
    }

    public void close() {
        driver.close();
    }

}
