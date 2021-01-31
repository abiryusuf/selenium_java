package locating.element;

import org.junit.After;
import org.junit.Assert;
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
        System.setProperty("webdriver.chrome.driver", "resource/mac/chromedriver");
        //WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void locatorTest() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://www.saucedemo.com");
        Thread.sleep(2000);
        // Use cssSelector
        driver.findElement(By.cssSelector("input#user-name")).sendKeys("standard_user");
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("input#password")).sendKeys("secret_sauce");
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("input#login-button")).click();
        Thread.sleep(2000);

        //Xpath
        driver.findElement(By.xpath("//*[contains(text(),'Sauce Labs Bike Light')]")).click();
        driver.findElement(By.xpath("//*[contains(text(),'ADD TO CART')]")).click();
        driver.findElement(By.cssSelector("#shopping_cart_container > a > svg > path")).click();
        driver.findElement(By.xpath("//*[contains(text(),'CHECKOUT')]")).click();

        //Best Locator
        driver.findElement(By.id("first-name")).sendKeys("abir");
        Thread.sleep(1000);
        driver.findElement(By.id("last-name")).sendKeys("yusuf");
        Thread.sleep(1000);
        driver.findElement(By.id("postal-code")).sendKeys("11435");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@class='btn_primary cart_button'][@type='submit']")).click();
        driver.findElement(By.xpath("//*[contains(text(),'FINISH')]")).click();
        Thread.sleep(2000);

        //Assert.assertArrayEquals(driver.findElement(By.cssSelector("#checkout-complete_container"))).;
        //Assert.assertTrue(driver.findElement(By.cssSelector("#checkout_complete_container")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("#checkout_complete_container")).isDisplayed());
        //Assert.assertArrayEquals(driver.findElement(By.cssSelector("#checkout-complete_container")));
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}