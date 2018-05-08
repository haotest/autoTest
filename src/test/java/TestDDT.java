import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by lhh on 2018/5/3.
 */
public class TestDDT {

    @Test(dataProvider = "testdata")
    public void login(String name,String password){
        System.out.println("用户名是："+name);
        System.out.println("密码是："+password);
    }

    @DataProvider(name = "testdata")
    public Object[][] testDataFeed(){
        Object[][] baiduData = new Object[2][2];
        baiduData[0][0] ="test1";
        baiduData[0][1]="password1";
        baiduData[1][0]="test2";
        baiduData[1][1]="password2";

        return baiduData;

    }
}
