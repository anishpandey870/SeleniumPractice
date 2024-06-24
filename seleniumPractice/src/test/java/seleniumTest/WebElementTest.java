package seleniumTest;

import org.openqa.selenium.*;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;

public class WebElementTest {
    WebDriver driver;

    @BeforeTest
    public void driver() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/");
    }

    @Test
    public void getLocationTest() throws AWTException {
        WebElement ema = driver.findElement(By.name("email"));
        Point loc = ema.getLocation();
        System.out.println("location :" + loc);
        int x = loc.getX();
        int y = loc.getY();
        System.out.println("location of x coordinate and y coordinate :" + x + " " + y);
        Robot rb = new Robot();
        rb.mouseMove(x, y);

    }

    @Test
    public void getSizeTest() {
        WebElement ema = driver.findElement(By.name("email"));
        Dimension si = ema.getSize();
        int h = si.getHeight();
        int w = si.getWidth();
        System.out.println("dimension of email :" + h + " " + w);
    }

    @Test
    public void isTest() {
        WebElement ema = driver.findElement(By.name("email"));
        //isEnabled()
        boolean en = ema.isEnabled();
        System.out.println("check is enable :" + en);
        //isDisplayed()
        boolean dis = ema.isDisplayed();
        System.out.println("check is display :" + dis);
        //is selected
        boolean sele = ema.isSelected();
        System.out.println("check is selected :" + sele);
        //getAttribute()
        String at = ema.getAttribute("name");
        System.out.println("get attribute :" + at);
        //getTagname()
        String tag = ema.getTagName();
        System.out.println("get tag name :" + tag);
        //getCssValue()
        String css = ema.getCssValue("font");
        System.out.println("get css value :" + css);
    }

    @Test
    public void sendkeysRemoveText() throws InterruptedException {
        WebElement em = driver.findElement(By.name("email"));
        em.sendKeys("abc@12");
        Thread.sleep(3000);
        //doubt
        em.sendKeys(Keys.CONTROL + "a" + Keys.DELETE);
    }

    @Test
    public void findElements() {
        List<WebElement> links = driver.findElements(By.tagName("a"));
        int totalLink = links.size();
        System.out.println("toatal links presents on webpage :" + totalLink);
        int visibleLinkCount = 0;
        int invisibleLinkCount = 0;
        for (WebElement link : links) {
            if (link.isDisplayed()) {
                visibleLinkCount++;
            } else {
                invisibleLinkCount++;
            }
        }
        System.out.println("visible links :" + visibleLinkCount);
        System.out.println("invisble links :" + invisibleLinkCount);
        driver.close();
    }
}