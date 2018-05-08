package testcase;

import org.testng.annotations.Test;
import pageHelper.HelperLoginPage;

/**
 * Created by lhh on 2018/3/13.
 */
public class LoginPage_Login extends BasicTestCase{

    @Test
    public void testLogin(){
        HelperLoginPage.login(seleniumUtil,"user1","123456");
    }

}
