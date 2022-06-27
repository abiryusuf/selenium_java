package toolsQA;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;

public class WindowHandle {

    WebDriver driver = null;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

    }

    @Test(priority = 2)
    public void windowHandle() throws InterruptedException {
        driver.get("https://demoqa.com/browser-windows");
        // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.findElement(By.id("windowButton")).click();
        //element.click();
        String parentWindow = driver.getWindowHandle();
        Set<String> childWindows = driver.getWindowHandles();
        Iterator<String> iterator = childWindows.iterator();

        while (iterator.hasNext()) {
            String ChildWindow = iterator.next();
            if (!parentWindow.equalsIgnoreCase(ChildWindow)) {
                driver.switchTo().window(ChildWindow);
                WebElement text = driver.findElement(By.id("sampleHeading"));
                System.out.println("Display Heading " + text.getText());
                // Back to the parent window
                driver.switchTo().defaultContent();
                // Or
                driver.switchTo().window(parentWindow);
            }
        }
    }

    @ Test
    public void secondWindow(){
        System.setProperty("webdriver.chrome.driver","Path to the driver");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

// Load the website
        driver.get("http://www.naukri.com/");

// It will return the parent window name as a String
        String parent=driver.getWindowHandle();

        Set<String>s=driver.getWindowHandles();

// Now iterate using Iterator
        Iterator<String> I1= s.iterator();

        while(I1.hasNext())
        {

            String child_window=I1.next();


            if(!parent.equals(child_window))
            {
                driver.switchTo().window(child_window);

                System.out.println(driver.switchTo().window(child_window).getTitle());

                driver.close();
            }

        }
//switch to the parent window
        driver.switchTo().window(parent);
        // or
        driver.switchTo().defaultContent();

    }
}

