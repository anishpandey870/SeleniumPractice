package com.insin.util;

import com.insin.base.TestBase;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;

public class TestUtil extends TestBase {
    public static long PAGE_LOAD_TIMEOUT = 30;
    public static long IMPLICIT_WAIT = 20;

    public void switchToFrame() {
        driver.switchTo().frame(0);
    }

    public void failTest(String FTname) throws IOException {
        log.info("this is fail test method from util class");
        TakesScreenshot ts = (TakesScreenshot) driver;
        File srcFile = ts.getScreenshotAs(OutputType.FILE);
        File desFile = new File("D:\\SelenumGit\\insinkerator\\screenShots\\" + FTname + ".png");
        FileHandler.copy(srcFile, desFile);
    }

}
