package seleniumTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.awt.*;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SelectListBox {
    WebDriver driver;


    @BeforeTest
    public void driver() throws InterruptedException, AWTException {
        driver = new ChromeDriver();
        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();
        Thread.sleep(2000);
        Robot rs = new Robot();
        rs.mouseWheel(13);
    }

    @Test
    public void listBox() throws InterruptedException, AWTException {
        driver.switchTo().frame(0);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebElement list = driver.findElement(By.xpath("//select[@id='RESULT_RadioButton-3']"));
        list.click();
        //created select obj
        Select sel = new Select(list);
        //getOptions() method returns a list of all the elements of the list box
        List<WebElement> option = sel.getOptions();
        System.out.println("number of option :" + option.size());
        //printing all elements presents in list
        for (WebElement op : option) {
            String options = op.getText();
            System.out.println("all element in list :" + options);
        }
        //select by index
        sel.selectByIndex(1);
        System.out.println("select by index; " + sel.getFirstSelectedOption().getText());
        //select by value
        sel.selectByValue("Radio-1");
        //select by visible text
        sel.selectByVisibleText("Developer");

        List<WebElement> allSelectedOptions = sel.getAllSelectedOptions();
        int size2 = allSelectedOptions.size();
        System.out.println("Number of items that is selected in the list box is : " + size2);

        for (WebElement webElement : allSelectedOptions) {
            System.out.println(webElement.getText());
        }
     //check for multiple select
        boolean multiple = sel.isMultiple();
        System.out.println(multiple +" yes , it is multi select");
    }
}
