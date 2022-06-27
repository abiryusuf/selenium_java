package toolsQA;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.testproject.sdk.drivers.web.ChromeDriver;
import io.testproject.sdk.internal.exceptions.AgentConnectException;
import io.testproject.sdk.internal.exceptions.InvalidTokenException;
import io.testproject.sdk.internal.exceptions.ObsoleteVersionException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class Alert_Demo {

    WebDriver driver = null;

    @BeforeClass
    public void setUp() throws InvalidTokenException, AgentConnectException, ObsoleteVersionException, IOException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }
    @Test
//    public void alertTest() throws InterruptedException {
//        driver.get("https://demoqa.com/alerts");
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    //ALERT
////        WebElement ele = driver.findElement(By.id("alertButton"));
////        ele.click();
////        Alert alert = driver.switchTo().alert();
////        Thread.sleep(5000);
////        alert.accept();
////        System.out.println("get text " + ele.getText() );
//
//        //get text
//        WebElement ele = driver.findElement(By.id("promtButton"));
//        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", ele);
//         Alert_Demo alertDemo = driver.switchTo().alert();
//         String alt = alertDemo.getText();
//            System.out.println("Alert text is " + alt);
//            Thread.sleep(5000);
//            alertDemo.sendKeys("Test user");
//            alertDemo.accept();
//    }
//
//    //iFrame
//    @Test
//    public void iFrameTest(){
//        driver.get("https://toolsqa.com");
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        List<WebElement> iframe = driver.findElements(By.tagName("iframe"));
////        WebElement ele = driver.findElement(By.tagName("iframe"));
////        String iframe = ele.getText();
//        driver.switchTo().frame(0);
//        System.out.println("Index " + iframe);
//        System.out.println(iframe.size());
//
//        //Back to parent or main windows
//        driver.switchTo().defaultContent();


        @AfterClass
        public void tearDown(){
            driver.quit();
        }
    }

