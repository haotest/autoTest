import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

/**
 * Created by lhh on 2018/5/3.
 */
public class Util {

    private static WritableWorkbook  wb = null;
    public  List list = new ArrayList();
    public int rows;
    public int columns;

    public static void writeExcel(List<String> list,String path){

        File file = new File(path);
        if (file.isFile() && file.exists()) {
            file.delete();
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
        }finally{
            if(wb != null){
                try {
                    wb.close();
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }




    public void ReadExcel(String filePath, String sheetName) {
        FileInputStream in = null;
        try {
            //创建输入流
            in = new FileInputStream(filePath);
            //获取Excel文件对象
            Workbook workbook = Workbook.getWorkbook(in);
            Sheet sheet = workbook.getSheet(sheetName);
            rows = sheet.getRows();
            columns =sheet.getColumns();

            for (int i = 0; i < sheet.getRows(); i++) {
                //创建一个数组 用来存储每一列的值
                String[] str = new String[sheet.getColumns()];
                Cell cell = null;
                for (int j = 0; j < sheet.getColumns(); j++) {
                    //获取第i行，第j列的值
                    cell = sheet.getCell(j, i);
                    str[j] = cell.getContents();
                }
                //把刚获取的列存入list
                list.add(str);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String[][] ExcelDataProvider (){
        String[][] data=new String[rows][columns];
        for(int i=0;i<list.size();i++){
            String[] str = (String[])list.get(i);
            for(int j=0;j<str.length;j++){
                data[i][j]=str[j];
            }
        }
        return data;
    }


    public static void main(String args[]) {
        Util util = new Util();
        util.ReadExcel("./files/data.xls","login");

        String[][] a= util.ExcelDataProvider();
        System.out.println(a[0][0]);
        System.out.println(a[0][1]);
        System.out.println(a[2][0]);
        System.out.println(a[2][1]);
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
