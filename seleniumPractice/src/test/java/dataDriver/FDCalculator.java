package dataDriver;

import Utility.ExcelUtil;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class FDCalculator {
    WebDriver driver;

    @BeforeClass
    public void setUp() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india-sbi/fixed-deposit-calculator-SBI-BSB001.html");
        driver.manage().window().maximize();
        //doubt
        driver.findElement(By.xpath("//button[text()='No thanks']")).click();
    }


    @Test
    public void dataDrivenTest() throws IOException, InterruptedException {
        String filePath = System.getProperty("user.dir") + "\\testData\\bankCalData.xlsx";
        int row = ExcelUtil.getRowCount(filePath, "sheet1");

        for (int i = 1; i <= row; i++) {
            //read data from excel
            String princ = ExcelUtil.getCellData(filePath, "sheet1", i, 0);
            String rate = ExcelUtil.getCellData(filePath, "sheet1", i, 1);
            String period1 = ExcelUtil.getCellData(filePath, "sheet1", i, 2);
            String period2 = ExcelUtil.getCellData(filePath, "sheet1", i, 3);
            String feq = ExcelUtil.getCellData(filePath, "sheet1", i, 4);
            String exp_mval = ExcelUtil.getCellData(filePath, "sheet1", i, 5);

            //pass above data into application
            driver.findElement(By.xpath("//input[@name='principal']")).sendKeys(princ);
            driver.findElement(By.xpath("//input[@name='interest']")).sendKeys(rate);
            driver.findElement(By.xpath("//input[@name='tenure']")).sendKeys(period1);
            Select perSel = new Select(driver.findElement(By.xpath("//select[@name='tenurePeriod']")));
            perSel.selectByVisibleText(period2);
            Select feqSel = new Select(driver.findElement(By.xpath("//select[@name='frequency']")));
            feqSel.selectByVisibleText(feq);

            //clicked on calculate  return
            driver.findElement(By.xpath("//a[@onclick='return getfdMatVal(this);']")).click();

            //validation
            String act_mval = driver.findElement(By.xpath("//span[@id='resp_matval']//strong")).getText();
            if (Double.parseDouble(exp_mval) == Double.parseDouble(act_mval)) {
                System.out.println("Test passed");
                ExcelUtil.setCellData(filePath, "Sheet1", i, 7, "Passed");
                ExcelUtil.fillGreenColor(filePath, "Sheet1", i, 7);

            } else {
                System.out.println("Test failed");
                ExcelUtil.setCellData(filePath, "Sheet1", i, 7, "Failed");
                ExcelUtil.fillRedColor(filePath, "Sheet1", i, 7);

            }
            Thread.sleep(2000);
            // clicked on clear button
            driver.findElement(By.xpath("//img[@class='PL5']")).click();
        }
         driver.close();
    }
}
