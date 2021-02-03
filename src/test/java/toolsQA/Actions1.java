package toolsQA;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class Actions1 {

    WebDriver driver = null;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "resource/mac/chromedriver");
        //WebDriverManager.chromedriver().setup();
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
        String title = driver.getTitle();
        System.out.println("page title " + title);
        String sourcePage = driver.getPageSource();
        System.out.println("Source Page" + sourcePage);
    }
    @Test
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
    @Test
    public void dragAndDrop(){
        driver.get("https://demoqa.com/droppable/");
        driver.manage().window().maximize();
        Actions action = new Actions(driver);
        WebElement from = driver.findElement(By.id("draggable"));
        WebElement to = driver.findElement(By.id("droppable"));
        action.dragAndDrop(from, to).perform();
        String getText = to.getText();
        if (getText.equals("droppable")) {
            System.out.println("Pass");

        }else {
            System.out.println("FIAL");
        }
    }
    @Test
    public void mouseOver() throws InterruptedException {
        driver.get("https://demoqa.com/menu/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Actions actions = new Actions(driver);
        WebElement parentMenu = driver.findElement(By.xpath("//*[contains(text(), 'Main Item 2')]"));

        actions.moveToElement(parentMenu).perform();
        Thread.sleep(2000);
        System.out.println("Done Mouse over on main menu");

        WebElement child = driver.findElement(By.xpath("//*[contains(text(), 'SUB SUB LIST')]"));
        actions.moveToElement(child).perform();
        Thread.sleep(2000);
        System.out.println("sub list");

        WebElement child1 = driver.findElement(By.xpath("//*[contains(text(), 'Sub Sub Item 1')]"));
        actions.moveToElement(child1).perform();
        System.out.println("last child");

    }



    @After
    public void tearDown() throws Exception {
        driver.quit();
    }
}
