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
    public void alertWindow() throws Exception {

    }


        @AfterClass
        public void tearDown(){
            driver.quit();
        }
    }

