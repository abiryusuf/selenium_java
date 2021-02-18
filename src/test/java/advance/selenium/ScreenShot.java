package advance.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class ScreenShot {

    WebDriver driver = null;

    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void screenShot() throws IOException {
        driver.get("https://demoqa.com");
        // convert webdrive to take screen shot
        File screesShoteFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(screesShoteFile, new File("/Users/abiryusuf/Desktop"));
        }
        catch (IOException E){
            System.out.println(E.getMessage());
        }

    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
