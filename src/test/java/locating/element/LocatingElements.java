package locating.element;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LocatingElements {

    @Test
    public void elementTest(){
        //Telling the system where to find chromedriver
        System.setProperty("webdriver.chrome.driver", "resource/mac/chromedriver");
        //1. Instantiate the driver
        WebDriver driver = new ChromeDriver();
       // Navigate the url
        driver.get("https://www.saucedemo.com");
       //find the element and check the state
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("user-name")));

        element.isDisplayed();

        //element.click();

        //locator

        //element.findElement(By.id("user-name")); id
        //element.findElement(By.cssSelector("#user-name")); css
        //driver.quit();
        // "user-name" (id)
        //*[@id="user-name"] (xpath)
        ///html/body/div[2]/div[1]/img
        //#user-name (css)
        //
    }
}
