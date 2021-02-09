package advance.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.List;

public class BrokenLinks {
    WebDriver driver = null;

    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void brokenLinks(){
        driver.get("https://demoqa.com/links");

        String url = "";

        List<WebElement> allURLS = driver.findElements(By.tagName("a"));
        System.out.println("Total link on the page " + allURLS.size());

        Iterator<WebElement> iterator = allURLS.iterator();
        while (iterator.hasNext()){
            url = iterator.next().getText();
            System.out.println(url);
        }



    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
