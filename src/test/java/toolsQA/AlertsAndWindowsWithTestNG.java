package toolsQA;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

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
        driver.findElement(By.name("Timing Alert")).click();
        System.out.println("Timer JavaScript Alert is triggered but it is not yet opened");
        //create a webdriver wait
        WebDriverWait wait = new WebDriverWait(driver, 10);
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        System.out.println("pop Up or it is time to out");
        alert.accept();
        System.out.println("accepted");

    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
