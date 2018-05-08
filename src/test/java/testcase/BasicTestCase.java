package testcase;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import util.SeleniumUtil;

/**
 * Created by lhh on 2018/3/14.
 */
public class BasicTestCase {
    public WebDriver driver;
    public SeleniumUtil seleniumUtil;
    private static Logger logger = Logger.getLogger(BasicTestCase.class);

    @BeforeMethod
    public void initTests(){
        System.setProperty("webdriver.chrome.driver", ".\\Tools\\chromedriver.exe");
        PropertyConfigurator.configure("./log4j.properties");
        seleniumUtil = new SeleniumUtil();
        driver=seleniumUtil.getDriver("chrome");
        driver.manage().window().maximize();
        seleniumUtil.url("https://www.jd.com/");

    }

    @AfterMethod
    public void clearTests(){
        driver.quit();
    }

}
