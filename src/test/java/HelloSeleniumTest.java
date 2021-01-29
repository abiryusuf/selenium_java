import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HelloSeleniumTest {

 WebDriver driver = null;
    @Test
    public void firstTest(){
        //Telling the system where to find chromedriver.on windows need to add .exe
        System.setProperty("webdriver.chrome.driver", "resource/mac/chromedriver");

//        windows
       // System.setProperty("webdriver.chrome.driver", "resource.windows/chromedriver.exe");

        driver = new ChromeDriver();
        driver.get("http://www.saucedemo.com");
        driver.quit();

    }

    @Test
    public void test1(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://example.cypress.io/");
        driver.quit();
    }
}
