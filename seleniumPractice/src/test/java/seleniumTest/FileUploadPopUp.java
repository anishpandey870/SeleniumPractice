package seleniumTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Objects;

public class FileUploadPopUp {
    WebDriver driver;

    @Test
    public void fileUpload() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://nervgh.github.io/pages/angular-file-upload/examples/simple/");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@uploader='uploader'][2]")).sendKeys("C:\\Users\\anish\\OneDrive\\Desktop\\Anish_RESUME.pdf");
    }

    @Test
    public void fileDownload() throws InterruptedException {
        HashMap<String, Object> chromePrefs = new HashMap<>();
        chromePrefs.put("profile.default_content_settings.popups", 0);
        //Assign this chromePrefs object with ChromeOptions object
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", chromePrefs);

        WebDriver driver = new ChromeDriver(options);
        driver.get("https://jqueryui.com/");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[text()='Download']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@type='submit'][@value='Download']")).submit();
    }

    @Test
    public void fileUploadWithAutoIt() throws InterruptedException, IOException {
        driver=new ChromeDriver();
        driver.get("https://smallpdf.com/pdf-converter#r=convert");
        driver.findElement(By.xpath("//span[text()='Select files']")).click();
        Thread.sleep(2000);
        //doubt
        Runtime.getRuntime().exec("C:\\Users\\anish\\OneDrive\\Desktop\\popUp.exe");
    }

}
