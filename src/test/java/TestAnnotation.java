import org.testng.annotations.Test;
import org.testng.annotations.*;
/**
 * Created by lhh on 2018/5/2.
 */
public class TestAnnotation {
    @Test
    public void testcase1() {
        System.out.println("执行case1");
    }
    @Test
    public void testcase2() {
        System.out.println("执行case2");
    }
    @BeforeMethod
    public void beforeMethod() {
        System.out.println("我是beforeMethod");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("我是afterMethod");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("我是BeforeClass");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("我是AfterClass");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("我是BeforeTest");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("我是AfterTest");
    }

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("我是BeforeSuite");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("我是AfterSuite");
    }
}
