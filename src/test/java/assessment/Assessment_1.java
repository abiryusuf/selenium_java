package assessment;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Assessment_1 {

    WebDriver driver = null;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        //System.setProperty("webdriver.chrome.driver", "resource/mac/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }
    @Test
    public void test_1() throws InterruptedException {
        driver.get("https://www.americantinceilings.com/pattern1/");
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/main/div[1]/section[1]/div[1]/div/div[2]/div[4]/amp-selector/ul/li[16]/div/amp-img/img")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"installation\"]/div[1]/div")).click();
        WebElement ele = driver.findElement(By.xpath("//select[@id = 'grid-width']"));
        Thread.sleep(2000);
        Select select = new Select(ele);
        select.selectByValue("323");
       driver.findElement(By.xpath("//input[@id='qty']")).sendKeys("15");
        Thread.sleep(2000);
//        WebElement element = driver.findElement(By.xpath("/html/body/main/div[1]/section[1]/div[1]/div/div[2]/div[11]/div[3]/button"));
//        JavascriptExecutor executor = (JavascriptExecutor)driver;
//        executor.executeScript("arguments[0].click();", element);
//        driver.findElement(By.xpath("/html/body/main/div[1]/section[1]/div[1]/div/div[2]/div[11]/div[3]/button")).click();
//


    }


    @AfterClass
    public void tearDown(){
       driver.quit();
    }
}
