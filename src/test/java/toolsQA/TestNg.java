package toolsQA;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;

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


        String getAttribute = ele.getAttribute("class");
        System.out.println("get attribute " + getAttribute);

        Dimension getSize = ele.getSize();
        System.out.println("get size height " + getSize.height + " Width " + getSize.width);

        Point location = ele.getLocation();
        System.out.println("get location " + location.x + " " + location.y);

    }
    @Test (priority = 2)
    public void windowHandle() throws InterruptedException {
        driver.get("https://demoqa.com/browser-windows");
       // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

         driver.findElement(By.id("windowButton")).click();
        //element.click();
        String parentWindow = driver.getWindowHandle();
        Set<String> childWindows = driver.getWindowHandles();
        Iterator<String> iterator = childWindows.iterator();

        while (iterator.hasNext()){
            String ChildWindow = iterator.next();
            if (!parentWindow.equalsIgnoreCase(ChildWindow)){
                driver.switchTo().window(ChildWindow);
                WebElement text = driver.findElement(By.id("sampleHeading"));
                System.out.println("Display Heading " + text.getText());
            }
        }
//        Thread.sleep(5000);
//        WebElement text = driver.findElement(By.xpath("//*[@id='sampleHeading']"));
//        Thread.sleep(5000);
//        System.out.println("Display the text " + text.getText());
    }
    @Test
    public void RecoveryScenario(){
        try {
            driver.get("https://demoqa.com/buttons");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void uploadFile(){
        driver.get("http://softwaretestingplace.blogspot.com/2015/10/sample-web-page-to-test.html");
        WebElement browser = driver.findElement(By.id("uploadfile"));
        browser.sendKeys("/Users/abiryusuf/IdeaProjects/selenium_java/file");
    }

    @Test
    public void getText(){
        driver.get("https://www.google.com/");
        String ele = driver.findElement(By.xpath("//*[@id='gbw']/div/div/div[1]/div[1]/a")).getText();
        System.out.println("Text" + ele);


    }
    @Test
    public void selectTest(){
        WebElement ele;
        driver.get("https://www.americantinceilings.com/pattern1/");
        ele = driver.findElement(By.xpath("/html/body/main/div[1]/section[1]/div[1]/div/div[2]/div[4]/amp-selector/ul/li[16]/div/amp-img/img"));
        ele.click();
        ele = driver.findElement(By.xpath("//*[@id=\"installation\"]/div[1]/div/amp-img/img"));
        ele.click();
        SelectClass select = new SelectClass();

    }
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}