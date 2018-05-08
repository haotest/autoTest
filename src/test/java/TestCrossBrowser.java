import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.annotations.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
/**
 * Created by lhh on 2018/5/2.
 */
public class TestCrossBrowser {
    // 这行@Test一定要写，如果不写，表示当前没有需要执行的脚本，你可以测试不写，然后run testng.xml试试看，会发生什么
    @Test(parameters="Browser")
    public void startBrowser(String browser){

        if(browser.equalsIgnoreCase("Firefox")){

            System.setProperty("webdriver.gecko.driver","./Tools/geckodriver.exe");
            WebDriver driver = new FirefoxDriver();
            driver.manage().window().maximize();
            driver.get("https://www.baidu.com");
            WebElement ele=driver.findElement(By.id("id"));

        } else if(browser.equalsIgnoreCase("Chrome")){

            System.setProperty("webdriver.chrome.driver", "./Tools/chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://www.baidu.com");

        }

    }
}
