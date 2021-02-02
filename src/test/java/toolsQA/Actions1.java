package toolsQA;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Actions1 {

    WebDriver driver = null;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void rightClick(){
        driver.get("https://demoqa.com/buttons");
        driver.manage().window().maximize();
        Actions actions = new Actions(driver);
        WebElement element = driver.findElement(By.id("rightClickBtn"));
        actions.contextClick(element).perform();
        System.out.println("Right click context menu display");
    }
    @Test
    public void doubleClick() throws NoAlertPresentException {
        driver.get("https://demoqa.com/buttons");
        driver.manage().window().maximize();
        Actions ac = new Actions(driver);
        WebElement ele = driver.findElement(By.id("doubleClickBtn"));
        ac.doubleClick(ele).perform();
        System.out.println("Double click is display");
        //driver.switchTo().alert().accept();
    }
    @Test
    public void dragAndDrop(){
        driver.get("https://demoqa.com/droppable/");
        driver.manage().window().maximize();
        Actions action = new Actions(driver);
        WebElement from = driver.findElement(By.id("draggable"));
        WebElement to = driver.findElement(By.id("droppable"));
        action.dragAndDrop(from, to).perform();
        String getText = from.getText();
        if (getText.equals("Dropped")) {
            System.out.println("Pass");

        }else {
            System.out.println("FIAL");
        }
    }



    @After
    public void tearDown() throws Exception {
        driver.quit();
    }
}
