import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import org.apache.log4j.Logger;
import util.LogConfiguration;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

/**
 * Created by lhh on 2018/5/3
 */
public class ReadExcelDemo {

    private static WritableWorkbook wb = null;
    private static Logger logger = Logger.getLogger(ReadExcelDemo.class);

    public static String[][] readExcel(String filePath,String sheetName){
        InputStream in = null;
        String[][] data = null;
        try {
            in = new FileInputStream(filePath);
            logger.info("成功获取了输入流");
            Workbook workbook=Workbook.getWorkbook(in);
            Sheet sheet=workbook.getSheet(sheetName);
            logger.info("成功获取了表单");
            int rows = sheet.getRows();
            int columns = sheet.getColumns();
            data = new String[rows][columns];

            for(int i=0;i<rows;i++){
                for(int j=0;j<columns;j++){
                    Cell cell = sheet.getCell(j,i);
                    data[i][j]=cell.getContents();
                    logger.info("第"+i+"行，第"+j+"列的数据是："+data[i][j]);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            logger.error("读取excel失败");
        }
        return data;
    }


    public static void writeExcel(List<String> list, String path){

        File file = new File(path);
        if (file.isFile() && file.exists()) {
            file.delete();
            logger.info("文件存在，执行删除操作");
        }
        try {
            wb = Workbook.createWorkbook(new File(path));
            WritableSheet sheet = wb.createSheet("account", 0);
            for(int i=0; i<list.size(); i++){
                sheet.addCell(new Label(0, i, list.get(i)));
            }
            wb.write();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            logger.error("excel写入出现异常");
        }finally{
            if(wb != null){
                    try {
                        wb.close();
                        logger.info("成功关闭");
                    } catch (Exception e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
            }
        }
    }


    public static void main(String[] args){
        LogConfiguration.initLog();
        String[][] myData = readExcel("./datae.xls","login");
        System.out.println("############");
        //遍历二维数组，i控制行 j控制列
        for(int i=0; i<myData.length; i++){
            String[] item = myData[i];
            for(int j=0;j<item.length;j++){
                System.out.print(item[j]+"\t");
        }
        System.out.println();
        }
    }
}
