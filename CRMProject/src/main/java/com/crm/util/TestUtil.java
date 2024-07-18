package com.crm.util;

import com.crm.base.TestBase;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;

public class TestUtil extends TestBase {
    public static long PAGE_LOAD_TIMEOUT = 30;
    public static long IMPLICIT_WAIT = 30;

    public void  failTest(String FTname) throws IOException {
        TakesScreenshot ts=(TakesScreenshot) driver;
        File scrFile = ts.getScreenshotAs(OutputType.FILE);
        File desFile=new File(".\\ScreenShots\\"+FTname+".png");
        FileHandler.copy(scrFile,desFile);
    }

//    public void takeScreenshotAtEndOfTest() throws IOException {
//        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//        String currentDir = System.getProperty("user.dir");
//        FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
//    }

}
