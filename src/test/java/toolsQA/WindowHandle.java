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
            }
        }
    }
}
