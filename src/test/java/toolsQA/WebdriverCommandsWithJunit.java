package toolsQA;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class WebdriverCommandsWithJunit {

    WebDriver driver = null;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

    }
    @Test
    public void findElementTest(){
        driver.get("https://demoqa.com/text-box/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        List <WebElement> inputAll = driver.findElements(By.tagName("input"));
        if(inputAll.size() == 0){
            System.out.println(inputAll.size() + " Elements not found by TagName as input \\n ");
        }else {
            System.out.println("ELements found by TagName");
        }
        for (WebElement ele: inputAll){
            System.out.println(ele.getAttribute("placeholder"));
            System.out.println(ele.getText());
        }

    }
    @Test
    public void checkBoxTest(){
        driver.get("https://www.demoqa.com/automation-practice-form");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement ele = driver.findElement(By.cssSelector("label[for='hobbies-checkbox-1']"));
        boolean isSelected = ele.isSelected();
        if(isSelected == true){
           ele.click();
        }

        WebElement ele1 = driver.findElement(By.xpath("//*[@for = 'hobbies-checkbox-2']"));
        boolean isDisplay = ele1.isDisplayed();
        if (isDisplay == true){
            ele1.click();
        }


    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }
}
