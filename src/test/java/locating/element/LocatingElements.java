package locating.element;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LocatingElements {

    WebDriver driver;
    @Before
    public void setUp(){
        //Telling the system where to find chromedriver
        System.setProperty("webdriver.chrome.driver", "resource/mac/chromedriver");
        //1. Instantiate the driver
        driver = new ChromeDriver();
    }

    @Test
    public void locatorExam(){
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://www.saucedemo.com");

        //Css selector
        driver.findElement(By.cssSelector("input#user-name")).sendKeys("standard_user");
        driver.findElement(By.cssSelector("input#password")).sendKeys("secret_sauce");
        driver.findElement(By.cssSelector("input#login-button")).click();

        //x path
        driver.findElement(By.xpath("//button[@class = 'btn_primary btn_inventory']")).click();
        driver.findElement(By.cssSelector("path[fill=\"currentColor\"]")).click();
        driver.findElement(By.xpath("//a[@class='btn_action checkout_button']")).click();

        //Best locator
        driver.findElement(By.id("first-name")).sendKeys("first name");
        driver.findElement(By.id("last-name")).sendKeys("last-name");
        driver.findElement(By.id("postal-code")).sendKeys("zip");
        driver.findElement(By.xpath("//*[@class='btn_primary cart_button']")).click();

        driver.findElement(By.xpath("//*[contains(text(),'FINISH')]")).click();

        Assert.assertTrue(driver.findElement(By.cssSelector("#checkout_complete_container")).isDisplayed());

    }

    @Test
    public void elementTest(){
        //Telling the system where to find chromedriver
        //System.setProperty("webdriver.chrome.driver", "resource/mac/chromedriver");
        //1. Instantiate the driver

       // driver = new ChromeDriver();
       // Navigate the url
        driver.get("https://www.saucedemo.com");
//       //find the element and check the state
//        WebDriverWait wait = new WebDriverWait(driver, 10);
//        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("user-name")));
//
//        element.isDisplayed();

        //element.click();

        //locator
        //id
        WebElement element = null;
        element = driver.findElement(By.id("user-name"));
        //css
        driver.findElement(By.cssSelector("#user-name"));

        //className
        driver.findElement(By.className("form_input"));

        //tagName
        driver.findElement(By.tagName("input"));

        //xPath
        driver.findElement(By.xpath("//*[@id=\"user-name\"]"));
        //driver.quit();
        // "user-name" (id)
        //*[@id="user-name"] (xpath)
        ///html/body/div[2]/div[1]/img
        //#user-name (css)
        //
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
