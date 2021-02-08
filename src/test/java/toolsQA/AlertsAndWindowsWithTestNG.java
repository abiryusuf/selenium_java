package toolsQA;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class AlertsAndWindowsWithTestNG {
    WebDriver driver = null;

    @BeforeClass
     public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }
    @Test
    public void waitCommands(){
        driver.get("https://toolsqa.com/automation-practice-switch-windows/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.id("alertButton")).click();
        System.out.println("Timer JavaScript Alert is triggered but it is not yet opened");
        //create a webdriver wait
        WebDriverWait wait = new WebDriverWait(driver, 10);
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        System.out.println("pop Up or it is time to out");
        alert.accept();
        System.out.println("accepted");

    }
    @Test
    public void alertTest() throws InterruptedException {
        driver.get("https://demoqa.com/alerts");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

//        WebElement ele = driver.findElement(By.id("alertButton"));
//        ele.click();
//        Alert alert = driver.switchTo().alert();
//        Thread.sleep(5000);
//        alert.accept();
//        System.out.println("get text " + ele.getText() );

        //get text
        WebElement ele = driver.findElement(By.id("promtButton"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", ele);
         Alert alert = driver.switchTo().alert();
         String alt = alert.getText();
            System.out.println("Alert text is " + alt);
            Thread.sleep(5000);
            alert.sendKeys("Test user");
            alert.accept();
    }

    //iFrame
    @Test
    public void iFrameTest(){
        driver.get("https://toolsqa.com");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        List<WebElement> iframe = driver.findElements(By.tagName("iframe"));
//        WebElement ele = driver.findElement(By.tagName("iframe"));
//        String iframe = ele.getText();
        driver.switchTo().frame(0);
        System.out.println("Index " + iframe);
        System.out.println(iframe.size());

        //Back to parent or main windows
        driver.switchTo().defaultContent();


    }


    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
