package com.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class WebdriverMethods {

    WebDriver driver;
    WebElement element;
    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "resource/mac/chromedriver");
        driver = new ChromeDriver();
    }

    @Test
    public void windowsFrams(){
        driver.navigate().to("https://the-internet.herokuapp.com/windows");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.open('https://the-internet.herokuapp.com/windows/new');");

        String orginalWindow = driver.getWindowHandle();
        Set handles = driver.getWindowHandles();
        handles.remove(orginalWindow);

        String nextWindow = String.valueOf(handles.iterator().next());
        driver.switchTo().window(nextWindow);
        Assert.assertEquals("New Window", driver.getTitle());

        driver.close();
        driver.switchTo().window(orginalWindow);



    }
    //iFrame
    @Test
    public void iFrame(){
        driver.navigate().to("https://the-internet.herokuapp.com/nested_frames");
        //parent
        element = driver.findElement(By.name("frame-top"));
        //we can switch frame by index
        driver.switchTo().frame(1);
        //assert that we switched to the bottom frames
        //if I did not, NoSuchElementException would be thrown
        Assert.assertEquals("BOTTOM", driver.findElement(By.tagName("body")).getText());

        //stitch to parent
        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame-top");
//        driver.switchTo().frame("frame-left");
//        Assert.assertEquals("LEFT", driver.findElement(By.tagName("body")).getText());
        driver.switchTo().frame("frame-middle");
        Assert.assertEquals("MIDDLE",driver.findElement(By.tagName("body")).getText());

        // move to parent by default
        driver.switchTo().defaultContent();

    }

    @Test
    public void alerts(){
        driver.navigate().to("");
    }

    public void tearDown(){
        driver.quit();
    }
}
