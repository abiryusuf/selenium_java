package toolsQA;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Actions1 {

    WebDriver driver = null;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void rightClick(){
        driver.get("https://demoqa.com/buttons");
        driver.manage().window().maximize();
        Actions actions = new Actions(driver);
        WebElement element = driver.findElement(By.id("rightClickBtn"));
        actions.contextClick(element).perform();
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }
}
