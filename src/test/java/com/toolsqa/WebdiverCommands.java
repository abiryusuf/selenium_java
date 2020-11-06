package com.toolsqa;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebdiverCommands {

        WebDriver driver;
        @Before
        public void setUp(){
            System.setProperty("webdriver.chrome.driver", "resource/mac/chromedriver");
            driver = new ChromeDriver();
        }

        @Test
        public void test1(){
//maven Repo driver manager
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
            String url = "https://the-internet.herokuapp.com";

            //get() or navigate(): This method Load a new web page in the current browser window
            driver.navigate().to(url);
            //Title: This method fetches the Title of the current page
            String title = driver.getTitle();
            System.out.println("title of the page " + title);
            Assert.assertEquals("The Internet", title);

            int titleLength = driver.getTitle().length();
            System.out.println("Length of the titel is " + titleLength);
            //getCurrentUrl(): String – This method fetches the string representing the Current URL which is opened in the browser
            String actualUrl = driver.getCurrentUrl();
            if (actualUrl.equals(url)){
                System.out.println("Verification Successful - The correct URL is opened ");
            }
            else {
                System.out.println("Verification failed - An incorrect Url is opened");
                //Assert.assertEquals("https://the-internet.herokuapp.com/", actualUrl);

                System.out.println("Actual URL is : " + actualUrl);
                System.out.println("Expected URL is : " + url);
            }
            //getPageSource(): String – This method returns the Source Code of the page.
            String pageSources = driver.getPageSource();
            int pageSouceLength = pageSources.length();
            System.out.println("Total length of the page source is : " + pageSouceLength);
        }

        @After
        public void tearDown(){
            driver.quit();
        }
    }

