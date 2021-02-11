package advance.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class DynamicTable {

    WebDriver driver = null;


    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @Test
    public void test1(){
        driver.get("http://demo.guru99.com/test/web-table-element.php");

        List<WebElement> col = driver.findElements(By.className(".//*[@id=\\\"leftcontainer\\\"]/table/thead/tr/th"));
        System.out.println("Total column " + col.size());

        List<WebElement> row = driver.findElements(By.xpath(".//*[@id='leftcontainer']/table/tbody/tr/td[1]"));
        System.out.println("Total rows " + row.size());
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
