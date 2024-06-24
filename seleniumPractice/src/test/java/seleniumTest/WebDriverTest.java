package seleniumTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WebDriverTest {
    WebDriver driver;

    @BeforeTest
    public void driver() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.flipkart.com/");
    }

    @Test(priority = 1)
    public void getPage() throws InterruptedException {
        //get title
        String title = driver.getTitle();
        System.out.println("get title of url: " + title);
        //get source page
        String sourcePage = driver.getPageSource();
        System.out.println("this source page :" + sourcePage);
        //get current url
        String url = driver.getCurrentUrl();
        System.out.println("current url :" + url);
        //get window handle
        String window = driver.getWindowHandle();
        System.out.println("this get window id :" + window);

       // driver.close();

    }

    @Test(priority = 2)
    public void doNavigate() throws InterruptedException {
        driver.navigate().to("https://www.flipkart.com/reebok-stride-runner-m-running-shoes-men/p/itm15aeeb7a4bbd2?pid=SHOGEUFG6AZZ8XT3&lid=LSTSHOGEUFG6AZZ8XT34ROWHT&marketplace=FLIPKART&store=osp%2Fcil&srno=b_1_1&otracker=browse&fm=organic&iid=en_nkuZUCDKwwir8tqWQG6Odzq-65jjxjE-kMLTreCJjouFEC8XMS_WxxJ4OSYEXbfmjisMkBbqtjRyV0Q7y86BSQ%3D%3D&ppt=browse&ppn=browse&ssid=efki1e4cz40000001718780665245");
        Thread.sleep(6000);
        driver.navigate().back();
        Thread.sleep(6000);
        driver.navigate().forward();
        Thread.sleep(6000);
        driver.navigate().refresh();
        driver.quit();
    }
}
