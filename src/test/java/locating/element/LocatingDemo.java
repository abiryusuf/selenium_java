package locating.element;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LocatingDemo {

    WebDriver driver = null;
    WebElement element;

    @Before
    public void setUp(){
        //WebDriverManager.chromedriver().setup();
        System.setProperty("webdriver.chrome.driver", "resource/mac/chromedriver");
        driver = new ChromeDriver();
    }
    @Test
    public void locatorTest() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://www.saucedemo.com");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.xpath("//*[@id='password']")).sendKeys("secret_sauce");
        driver.findElement(By.className("btn_action")).click();
        Thread.sleep(3000);

    }


    @After
    public void tearDown(){
        driver.quit();
    }
}
