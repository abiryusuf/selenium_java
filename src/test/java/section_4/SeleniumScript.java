package section_4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumScript {

    WebDriver driver = null;

    @Test
    public void findElement() throws InterruptedException {
        //set the location by file
        //System.setProperty("webdriver.chrome.driver", "resource/mac/chromedriver");
       // set the location by webdriver manager by maven project
        WebDriverManager.chromedriver().setup();
        //start session, open browser
        driver = new ChromeDriver();
        //Navigate the url
        driver.get("http://www.saucedemo.com");

        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("login-button")));

        element.click();


        Thread.sleep(3000);
        //close the browser
        driver.quit();

        /* userName xpath //[@id="user-name"]
        * //*[@id="password"]
       //*[@id="login-button"] */


    }
}
