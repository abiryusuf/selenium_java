import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HelloSeleniumTest {
    public void firstTest(){
        //Telling the system where to find chromedriver.on windows need to add .exe
        System.setProperty("webdriver.chromedriver", "resources/chromdriver");

        WebDriver driver = new ChromeDriver();
    }
}
