package com.insin.listener;

import com.aventstack.extentreports.ExtentTest;
import com.insin.base.TestBase;
import com.insin.util.TestUtil;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class Listener extends TestBase implements ITestListener {
    TestUtil util;

    public void onTestStart(ITestResult result) {
        System.out.println(".....onTestStart...... " + result.getMethod().getMethodName());
        extent.attachReporter(spark);
    }

    public void onTestSuccess(ITestResult result) {
        System.out.println(".....onTestSuccess...... " + result.getMethod().getMethodName());
        ExtentTest test = extent.createTest(result.getMethod().getMethodName()).assignAuthor("Anish").assignDevice("chrome");

    }

    public void onTestFailure(ITestResult result) {
        log.info("test fail msg...");
        System.out.println(".....onTestFailure...... " + result.getMethod().getMethodName());
        ExtentTest test = extent.createTest(result.getMethod().getMethodName()).assignAuthor("anish").assignDevice("chrome");
        test.fail("test method fail");
        String failTestName = result.getMethod().getMethodName();
        util = new TestUtil();
        try {
            util.failTest(failTestName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        test.addScreenCaptureFromPath("D:\\SelenumGit\\insinkerator\\screenShots" + result.getMethod().getMethodName() + ".png");
        extent.flush();
    }

    public void onTestSkipped(ITestResult result) {
        System.out.println(".....onTestSkipped...... " + result.getMethod().getMethodName());
        ExtentTest test = extent.createTest(result.getMethod().getMethodName());
        test.skip("test method failed");
        extent.flush();
    }


    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println(".....onTestFailedButWithinSuccessPercentage...... " + result.getMethod().getMethodName());
    }


    public void onTestFailedWithTimeout(ITestResult result) {
        System.out.println(".....onTestFailedWithTimeout...... " + result.getName());
    }


    public void onStart(ITestContext context) {
        System.out.println(".....onStart...... " + context.getName());
    }


    public void onFinish(ITestContext context) {
        System.out.println(".....onFinish...... " + context.getName());
    }
}


