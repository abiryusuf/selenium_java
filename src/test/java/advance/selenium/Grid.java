package advance.selenium;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.URL;

/*
Selenium grid is tools, it provides running multiple test across different browsers and
operating systems in parallel

There are two main elements or part to selenium Hub and Nodes

Hub: Hub is central point where I can run the test. Hub pass the execution to nodes.
Selenium grid has only one hub and it is the master of the network.

Node: In Selenium Grid, a node is referred to a Test Machine which
opts to connect with the Hub. WHere execution happens

Why do we need selenium grid
1. Multiple tests across different browser
2. Parallel Testing
3. Speed and decrease Execution time

When to use Selenium Grid
1. Parallel Testing
2. Speed and decrease execution Time

Grid Architecture
https://toolsqa.com/wp-content/gallery/selenium-basics/Selenium-Grid-Architecture.png
*
java -jar selenium-server-standalone-3.141.59.jar -role hub
/Users/abiryusuf/Documents/JAR
* */
public class Grid {
    WebDriver driver;

    @Test
    public void gridTest(){
        driver = new FirefoxDriver();
        String url = "http://localhost:4444/wd/hub";
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setBrowserName("firefox");
        desiredCapabilities.setPlatform(Platform.MAC);
        driver = new RemoteWebDriver((new URL(url)), desiredCapabilities);
        driver.get("https://www.google.com");
        System.out.println(driver.getCurrentUrl());
        driver.close();

    }
}
