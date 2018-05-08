package pageHelper;

import org.openqa.selenium.WebDriver;
import page.PageLogin;
import org.apache.log4j.Logger;
import util.SeleniumUtil;

import java.util.concurrent.TimeUnit;

/**
 * Created by lhh on 2018/3/13.
 */
public class HelperLoginPage {

    public static Logger logger = Logger.getLogger(HelperLoginPage.class);
    SeleniumUtil seleniumUtil = new SeleniumUtil();
    /**点击登录链接*/

    public static void clickLoginLink(SeleniumUtil seleniumUtil){
        seleniumUtil.findElement(PageLogin.LOGIN_LINK_TITLE).click();
        // 点击账户登录，不点击的话默认是二维码扫描登录
        seleniumUtil.findElement(PageLogin.LOGIN_LINK_LOGIN).click();
    }
    // 登录步骤拆分-输入用户名
    public static void inputUsername(SeleniumUtil seleniumUtil,String username){
        seleniumUtil.findElement(PageLogin.LOGIN_EDITVIEW_ACCOUNT).sendKeys(username);
    }
    // 登录步骤拆分-输入密码
    public static void inputPassword(SeleniumUtil seleniumUtil,String password){
        seleniumUtil.findElement(PageLogin.LOGIN_EDITVIEW_PWD).sendKeys(password);
    }
    // 点击登录按钮
    public static void clickLoginBtn(SeleniumUtil seleniumUtil){
        seleniumUtil.findElement(PageLogin.LOGIN_BUTTON_LOGIN).click();
    }
    //重构一个登录方法
    public static void login(SeleniumUtil seleniumUtil,String name, String pass){
        clickLoginLink(seleniumUtil);
        inputUsername(seleniumUtil,name);
        inputPassword(seleniumUtil,pass);
        clickLoginBtn(seleniumUtil);
    }
}
