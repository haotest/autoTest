import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;


/**
 * Created by lhh on 2018/5/3.
 */
public class Log4jTest {

    public static void main(String[] args){
        Logger logger = Logger.getLogger(Log4jTest.class);
        PropertyConfigurator.configure("./log4j.properties");
        logger.info("这是info日志级别");
        logger.error("这是error日志级别");
    }



}
