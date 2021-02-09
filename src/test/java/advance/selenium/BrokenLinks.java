package advance.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class BrokenLinks {
    WebDriver driver = null;

    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void brokenLinks(){
        driver.get("https://demoqa.com/links");

        String url = "";

        List<WebElement> allURLS = driver.findElements(By.tagName("a"));
        System.out.println("Total link on the page " + allURLS.size());

//        Iterator<WebElement> iterator = allURLS.iterator();
//        while (iterator.hasNext()){
//            url = iterator.next().getText();
//            System.out.println(url);
//        }
        for (int i =0; i<allURLS.size(); i++){
            WebElement ele = allURLS.get(i);
            url = ele.getAttribute("href");
            verifyLinks(url);

        }



    }
    public static void verifyLinks(String linkUrl){
        try {
            URL url = new URL(linkUrl);

            HttpURLConnection http = (HttpURLConnection)url.openConnection();
            http.setConnectTimeout(5000);
            http.connect();
            if (http.getResponseCode()>=400){
                System.out.println(linkUrl + " " +http.getResponseMessage()+ "is a broken Links");
            } else {
                System.out.println(linkUrl + " " + http.getResponseMessage());
            }
        } catch (Exception e) {

        }
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
