package page;

import org.openqa.selenium.By;

/**
 * Created by lhh on 2018/3/13.
 */
public class PageLogin {

    /**顶部title-登录*/
    public static final By LOGIN_LINK_TITLE = By.id("ttbar-login");
    /**切换账户登录*/
    public static final By LOGIN_LINK_LOGIN = By.xpath("//*[@id='content']/div[2]/div[1]/div/div[3]/a");
    /**输入用户名*/
    public static final By LOGIN_EDITVIEW_ACCOUNT = By.id("loginname");
    /**输入密码*/
    public static final By LOGIN_EDITVIEW_PWD = By.id("nloginpwd");
    /**忘记密码*/
    public static final By LOGIN_LINK_FORGET = By.xpath("//*[@id='formlogin']/div[4]/div/span[2]/a");
    /**登录Button*/
    public static final By LOGIN_BUTTON_LOGIN = By.id("loginsubmit");
    /**注册Button*/
    public static final By LOGIN_BUTTON_REGISTER = By.xpath("//*[@id='kbCoagent']/ul/li[3]/div/div/a");

}
