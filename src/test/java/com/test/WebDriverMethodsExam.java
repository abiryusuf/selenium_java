package com.test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;

public class WebDriverMethodsExam {
    WebDriver driver = null;
    WebElement element;

    @Before
    public void setUp(){
        //System.setProperty("webdriver.chrome.driver", "resource/mac/chromedriver");
        driver = new SafariDriver();
        driver.manage().window().maximize();

    }
    @Test
    public void actions(){
        driver.navigate().to("https://example.cypress.io/commands/actions");
        element = driver.findElement(By.id("password1"));
        Actions action = new Actions(driver);
        action.click(element).build().perform();

        driver.findElement(By.cssSelector(".action-focus"));
        Assert.assertTrue("user should navaigate focus", element.isDisplayed());
    }
    @Test
    public void cookis(){
        driver.navigate().to("https://example.cypress.io/commands/cookies");
        element = driver.findElement(By.cssSelector(".set-a-cookie"));
        element.click();

        var cookie = driver.manage().getCookieNamed("token");
        Assert.assertEquals("123ABC", cookie.getValue());
    }
    @Test
    public void scrollToBottom() throws InterruptedException {
        driver.navigate().to("https://ultimateqa.com/complicated-page/");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, -document.body.scrollHeight)");
        Thread.sleep(5000);
    }

    @Test
    public void scrollToTop() throws InterruptedException {
        driver.navigate().to("https://ultimateqa.com/complicated-page/");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Thread.sleep(5000);
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
