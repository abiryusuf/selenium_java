package webdrivermethods;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class Actions {

    WebDriver driver = null;
    WebElement element;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }
    @Test
    public void dropDown(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://the-internet.herokuapp.com/dropdown");

//        element = driver.findElement(By.id("dropdown"));
//        element.click();
//
//        WebElement option1 = driver.findElement(By.xpath("//*[contains(text(), 'Option 1')]"));
//        WebElement option2 = driver.findElement(By.xpath("//*[contains(text(), 'Option 2')]"));
//        option1.click();
//
//        Assert.assertTrue(option1.isSelected());
//        Assert.assertFalse(option2.isSelected());


        Select select = new Select(driver.findElement(By.id("dropdown")));
        select.selectByIndex(0);




       // Assert.assertTrue(driver.findElement(By.xpath("//*[contains(text(), 'Option 1')]")).isSelected());
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }
}
