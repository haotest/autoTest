import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import util.LogConfiguration;
import util.SeleniumUtil;

/**
 * Created by lhh on 2018/5/4.
 */
public class TestMain {

    public static void main(String[] args){

        LogConfiguration.initLog();
        SeleniumUtil seleniumUtil = new SeleniumUtil();
        System.setProperty("webdriver.chrome.driver", "./Tools/chromedriver.exe");
        WebDriver driver = seleniumUtil.getDriver("chrome");

        seleniumUtil.url("https://www.jd.com/");
        driver.manage().window().maximize();
        WebElement ele= seleniumUtil.findElement(By.id("ttbar-login"));
        System.out.println(ele);
    }

}
