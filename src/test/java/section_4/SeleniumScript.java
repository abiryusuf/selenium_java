package section_4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumScript {

    WebDriver driver = null;

    @Test
    public void findElement() throws InterruptedException {

        //System.setProperty("webdriver.chrome.driver", "resource/mac/chromedriver");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com");
        Thread.sleep(3000);
        driver.quit();

    }
}
