package toolsQA;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestNg {

    WebDriver driver = null;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

    }

    @Test (priority = 1)
    public void doubleClick() throws NoAlertPresentException {
        driver.get("https://demoqa.com/buttons");
        driver.manage().window().maximize();
        Actions ac = new Actions(driver);
        WebElement ele = driver.findElement(By.id("doubleClickBtn"));
        ac.doubleClick(ele).perform();
        System.out.println("Double click is display");

        String getText = ele.getText();
        System.out.println("get Text " + getText);

        String getTag = ele.getTagName();
        System.out.println("get tag " + getTag);

        //driver.switchTo().alert().accept();
        String getAttribute = ele.getAttribute("class");
        System.out.println("get attribute " + getAttribute);

        Dimension getSize = ele.getSize();
        System.out.println("get size height " + getSize.height + " Width " + getSize.width);

        Point location = ele.getLocation();
        System.out.println("get location " + location.x + " " + location.y);

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}