package testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageHelper.HelperLoginPage;
import util.SeleniumUtil;
import util.LogConfiguration;

/**
 * Created by lhh on 2018/5/7.
 */
public class JD_login {

    public WebDriver  driver =null;
    SeleniumUtil seleniumUtil =null;
    long sec = 1000;
    @BeforeMethod
    public void initTests(){
        LogConfiguration.initLog();
        seleniumUtil = new SeleniumUtil();
        System.setProperty("webdriver.chrome.driver", "./Tools/chromedriver.exe");
        driver = seleniumUtil.getDriver("chrome");
        seleniumUtil.url("https://www.jd.com/");
    }

    @Test
    public void login() {
        HelperLoginPage.login(seleniumUtil,"user1","123456");
    }

    @AfterMethod
    public void clearTests(){
        driver.quit();
    }

}
