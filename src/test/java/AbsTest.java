import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by lhh on 2018/5/2.
 */
public class AbsTest {

    Abs ab = null;

    @BeforeMethod
    public void setUp() throws Exception {
        ab=new Abs();
    }

    @Test
    public void testAbs() throws Exception {
        Assert.assertEquals(ab.abs(-1),1,"-1的绝对是1");
    }

    @Test
    public void testAbs1() throws Exception {
        Assert.assertEquals(ab.abs(1),1,"1的绝对是1");
    }

    @Test
    public void testAbs2() throws Exception {
        Assert.assertEquals(ab.abs(0),1,"-1的绝对是1");
    }
}