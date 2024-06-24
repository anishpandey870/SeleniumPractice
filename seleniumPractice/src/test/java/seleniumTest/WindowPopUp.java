package seleniumTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class WindowPopUp {
    WebDriver driver;

    @Test
    public void childBrowserPopUp() {
        driver = new ChromeDriver();
        driver.get("https://www.naukri.com/");
        //using getWindowHandles(), get a set of window handle IDs
        Set<String> allWindowHandles = driver.getWindowHandles();
        int count = allWindowHandles.size();
        System.out.println("Number of browser windows opened on the system is : " + count);

        for (String windowHandle : allWindowHandles) {
            //switch to each browser window
            driver.switchTo().window(windowHandle);
            String title = driver.getTitle();
            //print the window handle id of each browser window
            System.out.println("Window handle id of page -->" + title + " --> is : " + windowHandle);
            driver.close();
        }
    }

    @Test
    public void closeMainBrowserOnly() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("https://www.flipkart.com/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement Tab = driver.findElement(By.xpath("//span[text()='Mobiles']"));
        Tab.click();
        WebElement child = driver.findElement(By.xpath("//a[text()='Motorola g04s (Sea Green, 64 GB)']"));
        child.click();

        String parentWindowhandleID = driver.getWindowHandle();
        Set<String> allWindowHandles = driver.getWindowHandles();
        int count = allWindowHandles.size();

        System.out.println("Number of browser windows opened on the system is : " + count);
        System.out.println("id of tab: "+allWindowHandles);

        for (String windowHandle : allWindowHandles) {
            //switch to each browser window
            driver.switchTo().window(windowHandle);
            String title = driver.getTitle();
         /* compare the window id with the Parent browser window id, if both are equal, then
          only close the main browser window.*/
            if (windowHandle.equals(parentWindowhandleID)) {
                driver.close();
                System.out.println("Main Browser window with title -->" + title + " --> is closed");
            }else {
                System.out.println("not equal");
            }
        }


    }

}
