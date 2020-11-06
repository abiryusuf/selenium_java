package project.test;

import io.testproject.sdk.drivers.web.ChromeDriver;
import io.testproject.sdk.internal.exceptions.AgentConnectException;
import io.testproject.sdk.internal.exceptions.InvalidTokenException;
import io.testproject.sdk.internal.exceptions.ObsoleteVersionException;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;

public class SimpleTest {

    WebDriver driver;

    @Test
    public void shouldOpen() throws InvalidTokenException, AgentConnectException, ObsoleteVersionException, IOException {
        driver = new ChromeDriver(new ChromeOptions());

        driver.navigate().to("https://ultimateqa.com/filling-out-forms/");
        Assert.assertEquals("Filling Out Forms - Ultimate QA", driver.getTitle());
    }

    @After
    public void teatDown(){
        driver.quit();
    }
}
