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
        driver.get("https://demoqa.com/webtables");
//        WebElement ele = driver.findElement(By.xpath("//*[contains(text(), \"First Name\")]"));
//        System.out.println("Name " + ele.getText());

        WebElement ele1 = driver.findElement(By.xpath("//div[contains(@class, 'ReactTable')]"));
        System.out.println("Total size " + ele1.getSize());
        //Rows
        List<WebElement> rows = driver.findElements(By.xpath("//div[contains(@class, 'rt-tr-group')]"));
        System.out.println("Total rows " + rows.size());

        //Columns

        List<WebElement> col = ele1.findElements(By.xpath("//div[contains(@class,'rt-td') and text()]/ancestor::div[contains(@class,'rt-tr-group')]"));
        System.out.println("Total columns " + col.get(1).getText());
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
//div[contains(@class,'rt-td') and text()]/ancestor::div[contains(@class,'rt-tr-group')]