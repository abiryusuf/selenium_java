package locating.element;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class locatorTestDemo {

    WebDriver driver = null;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void locatorTest() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://www.saucedemo.com");
        Thread.sleep(3000);
        // Use cssSelector
        driver.findElement(By.cssSelector("input#user-name")).sendKeys("standard_user");
        driver.findElement(By.cssSelector("input#password")).sendKeys("secret_sauce");
        driver.findElement(By.cssSelector("input#login-button")).click();

    }

    @After
    public void tearDown() {
        driver.quit();
    }
}