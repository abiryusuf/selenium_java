package com.test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class ActionTest {

    WebDriver driver;
    WebElement element;


    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","resource/mac/chromedriver");
        driver = new ChromeDriver();
    }

    @Test
    public void dropDown(){
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://the-internet.herokuapp.com/dropdown");
        element = driver.findElement(By.id("dropdown"));
        element.click();

        WebElement option1 = driver.findElement(By.cssSelector("option[value = '1']"));
        WebElement option2 = driver.findElement(By.cssSelector("option[value = '2']"));
        option1.click();

        Assert.assertTrue(option1.isSelected());
        Assert.assertFalse(option2.isSelected());

    }
    @Test
    public void hover(){
        driver.get("https://the-internet.herokuapp.com/hovers");
        //WebElement element = driver.findElement(By.cssSelector("img[src ='/img/avatar-blank.jpg']"));
        element = driver.findElement(By.className("figure"));
        Actions action = new Actions(driver);
        action.click(element).build().perform();

        element = driver.findElement(By.cssSelector("img[src ='/img/avatar-blank.jpg"));
        //element = driver.findElement(By.xpath("//*[contains(text(), 'name: user2')]"));
        Assert.assertTrue("user1 should appear because we hovered over that image", element.isDisplayed());


    }

    @After
    public void tearDown(){
       // driver.quit();
    }
}
