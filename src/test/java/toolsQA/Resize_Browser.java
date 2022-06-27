package toolsQA;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Resize_Browser {

    WebDriver driver = null;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "resource/mac/chromedriver");
        //WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }
    @Test
    public void launchBrowser() {
        driver.navigate().to("https://www.softwaretestingmaterial.com");
        System.out.println(driver.manage().window().getSize());
        //Create object of Dimensions class
        Dimension d = new Dimension(480,620);
        //Resize the current window to the given dimension
        driver.manage().window().setSize(d);
        System.out.println(driver.manage().window().getSize());
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }
}
