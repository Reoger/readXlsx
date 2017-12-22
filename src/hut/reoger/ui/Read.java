package hut.reoger.ui;

import hut.reoger.utils.PrintToPng;
import hut.reoger.utils.ReadExcel;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.util.ArrayList;
import java.util.List;

public class Read {
    static List<String> mTitle;
    static List<String> mContent;
    static String fileName;


    public static void readData(String path, String sourthPath) {
        mTitle = new ArrayList<>();
        mContent = new ArrayList<>();

        Workbook wb = null;
        Sheet sheet = null;
        Row row = null;
        String filePath = path;

        wb = ReadExcel.readExcel(filePath);
        if (wb != null) {
            for (int w = 0; w < wb.getNumberOfSheets(); w++) {
                sheet = wb.getSheetAt(w);
                //获取最大行数
                int rownum = sheet.getPhysicalNumberOfRows();
                //获取第一行
                row = sheet.getRow(0);
                //获取最大列数
                int colnum = row.getPhysicalNumberOfCells();
                for (int i = 1; i < rownum; i++) {
                    if (i == 1) {
                        for (int j = 0; j < colnum; j++)
                            mTitle.add((String) ReadExcel.getCellFormatValue(sheet.getRow(i).getCell(j)));
                    } else {
                        mContent.clear();
                        for (int j = 0; j < colnum; j++) {
                            mContent.add((String) ReadExcel.getCellFormatValue(sheet.getRow(i).getCell(j)));
                            if (j == 1)
                                fileName = (String) ReadExcel.getCellFormatValue(sheet.getRow(i).getCell(j));
                        }
                    }
                    try {
                        PrintToPng.createImage(mTitle, mContent, null, sourthPath + fileName + ".png", 1300, 60);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }

    }
}
