package seleniumTest;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;

public class JqueryTest {
    WebDriver driver;

    @BeforeTest
    public void driver() {
        driver = new ChromeDriver();
        driver.get("https://jqueryui.com/");
        driver.manage().window().maximize();
    }

    @Test
    public void linkTextTest() throws InterruptedException {
        driver.findElement(By.linkText("Draggable")).click();
        Thread.sleep(3000);
        driver.navigate().back();
        // driver.findElement(By.partialLinkText("API document")).click();
    }

    @Test
    public void multiAttributeXpath() {
        WebElement search = driver.findElement(By.xpath("//input[@name='s'][@placeholder='Search']"));
        search.sendKeys("widgets");
        //action class
    }

    @Test
    public void groupIndexXpath() {
        driver.findElement(By.xpath("//a[text()='Selectable']")).click();
        driver.switchTo().frame(0);
        WebElement item = driver.findElement(By.xpath("//ol[@id='selectable']/li[2]"));
        item.click();
        System.out.println(item);
    }

    @Test
    public void startsWith() throws InterruptedException {
        driver.findElement(By.xpath("//a[starts-with(text(),'Source Code')]")).click();
        Thread.sleep(3000);
        driver.navigate().back();
    }

    @Test
    public void axesXpath() throws InterruptedException {
        driver.findElement(By.xpath("//a[contains(text(),'Selectable')]")).click();
        Thread.sleep(3000);
        driver.switchTo().frame(0);
        List<WebElement> pr = driver.findElements(By.xpath("//li[text()='Item 3']/preceding-sibling::li"));
        for (WebElement p : pr) {
            String i = p.getText();
            System.out.println("this is all preceding sibling :" + i);
        }

        List<WebElement> fs = driver.findElements(By.xpath("//li[text()='Item 4']/following-sibling::li"));
        for (WebElement f : fs) {
            String fi = f.getText();
            System.out.println("this is all following sibling :" + fi);
        }

        //postion sibling
        WebElement specific = driver.findElement(By.xpath("//li[text()='Item 4']/preceding-sibling::li[2]"));
        specific.click();
        System.out.println("this is specific sibling :" + specific.getText());

        //last preceding -sibling using last()
        WebElement las = driver.findElement(By.xpath("//li[text()='Item 4']/preceding-sibling::li[last()]"));
        las.click();
        Thread.sleep(3000);
        System.out.println("this is specific sibling :" + las.getText());

        //child with position()
        WebElement ch = driver.findElement(By.xpath("//ol[@id='selectable']/child::li[position()=3]"));
        ch.click();
        System.out.println("this is specific child :" + ch.getText());

        //parents
        WebElement parent = driver.findElement(By.xpath("//li[text()='Item 4']/parent::ol"));
        System.out.println("this is parent :" + parent.getText());

    }

    @Test
    public void activeElement() {
        driver.get("https://www.facebook.com/");
        driver.switchTo().activeElement().sendKeys("anjj");
    }

    @Test
    public void enterText_intoDisableTextBox() throws InterruptedException {
        driver.get("file:///C:/Users/anish/OneDrive/Desktop/disable_text.html");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Thread.sleep(3000);
        js.executeScript("document.getElementById('t1').value='admin'");
        Thread.sleep(3000);
        js.executeScript("document.getElementById('t2').value=''");
        Thread.sleep(3000);
        js.executeScript("document.getElementById('t2').value='HR'");
        Thread.sleep(3000);
        js.executeScript("document.getElementById('t2').type='Button'");
    }

    @Test
    public void scrollUpNDown() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,800)");
        Thread.sleep(4000);
        js.executeScript("window.scrollBy(0,-700)");
        Thread.sleep(4000);
        for (int i = 0; i < 10; i++) {
            js.executeScript("window.scrollBy(0,800)");
        }
    }

    @Test
    public void scrollDownSpecific() throws InterruptedException {
        WebElement we = driver.findElement(By.xpath("//a[text()='Chat'][@class='icon-comments']"));
        int x = we.getLocation().getX();
        int y = we.getLocation().getY();
        System.out.println(x + " " + y);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(" + x + "," + y + ")");
        Thread.sleep(3000);
        we.click();
    }

    @Test
    public void handleFrame() throws InterruptedException {
        driver.findElement(By.xpath("//a[contains(text(),'Selectable')]")).click();
        driver.switchTo().frame(0);
        Thread.sleep(3000);
        driver.findElement(By.xpath("//li[contains(text(),'Item 2')]")).click();
        Thread.sleep(3000);
        driver.switchTo().defaultContent();
        driver.findElement(By.xpath("//a[contains(text(),'Sortable')]")).click();
        Thread.sleep(3000);
        driver.close();
    }

    @Test
    public void contextClick() throws InterruptedException, AWTException {
        WebElement web = driver.findElement(By.xpath("//a[contains(text(),'Selectable')]"));
        Actions action = new Actions(driver);
        action.contextClick(web).perform();
        Thread.sleep(3000);
        Robot rb = new Robot();
        rb.keyPress(KeyEvent.VK_W);
        rb.keyRelease(KeyEvent.VK_W);
    }

    @Test
    public void moveToElement() {
        WebElement web = driver.findElement(By.xpath("//a[contains(text(),'Selectable')]"));
        Actions action = new Actions(driver);
        action.moveToElement(web).perform();
    }

    @Test
    public void dragNdrop() {
        driver.findElement(By.xpath("//a[text()='Droppable']")).click();
        driver.switchTo().frame(0);
        WebElement src = driver.findElement(By.id("draggable"));
        WebElement des = driver.findElement(By.id("droppable"));
        Actions as = new Actions(driver);
        //   as.dragAndDrop(src, des).perform();
        as.moveToElement(src).clickAndHold().perform();
        as.moveToElement(des).release().perform();

    }

    @Test
    public void hiddenDivisionPopup() throws InterruptedException {
        WebElement hidden = driver.findElement(By.xpath("//a[text()='Menu']"));
        hidden.click();
        Thread.sleep(2000);
        driver.switchTo().frame(0);
        driver.findElement(By.xpath("//span[@class='ui-menu-icon ui-icon ui-icon-caret-1-e']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[text()='Car Hifi']")).click();
    }


}
