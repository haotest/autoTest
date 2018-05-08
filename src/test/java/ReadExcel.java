import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lhh on 2018/5/3.
 */
public class ReadExcel {

    public static String[][] ReadExcel(String filePath, String sheetName) {
        FileInputStream in = null;
        String[][] str = null ;
        try {
            //创建输入流
            in = new FileInputStream(filePath);
            //获取Excel文件对象
            Workbook workbook = Workbook.getWorkbook(in);
            Sheet sheet = workbook.getSheet(sheetName);
            int rows = sheet.getRows();
            int columns = sheet.getColumns();
            str = new String[rows][columns];
            for (int i = 0; i < sheet.getRows(); i++) {
                //创建一个数组 用来存储每一列的值

                Cell cell = null;
                for (int j = 0; j < sheet.getColumns(); j++) {
                    //获取第i行，第j列的值
                    cell = sheet.getCell(j, i);
                    str[i][j] = cell.getContents();
                    System.out.println("第"+i+"行,第"+j+"列的数是"+str[i][j]+"\t");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }

    public static void main(String[] args){
        String[][] a= ReadExcel("./data.xls","login");
        System.out.println("------------------" + a.length);

        //遍历二维数组，i控制行 j控制列
        for(int i=0; i<a.length; i++){
            String[] item = a[i];
            for(int j=0;j<item.length;j++){
                System.out.print(item[j]+"\t");
            }
            System.out.println();
        }
    }

}
