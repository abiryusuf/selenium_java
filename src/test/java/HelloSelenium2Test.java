import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;

public class HelloSelenium2Test {

//    @BeforeClass
//    public static void setUpClass(){
//        WebDriverManager.chromedriver().setup();
//
//    }
    @Test
    public void test1(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com");
        driver.quit();

    }

    @Test
    public void safariTest() throws InterruptedException{
        WebDriver driver = new SafariDriver();
        driver.get("https://the-internet.herokuapp.com");
        Thread.sleep(3000);
    }

    @Test
    public void cypressTest() throws InterruptedException {
        WebDriver driver = new SafariDriver();
        driver.get("https://example.cypress.io");
        Thread.sleep(3000);
        driver.quit();
    }
}
