package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by lhh on 2018/5/8.
 */
public class InitConfigData {

        public static String browserName;
        public static String serverURL;

        public static void ReadProperties() throws IOException {

            Properties p = new Properties();
            // 加载配置文件
            InputStream ips = new FileInputStream("./config.properties");
            p.load(ips);

            browserName=p.getProperty("browserName");
            serverURL = p.getProperty("URL");
        }

    static{
        try {
            InitConfigData.ReadProperties();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[]args) throws IOException {
            System.out.println(InitConfigData.browserName);
        }
    }
