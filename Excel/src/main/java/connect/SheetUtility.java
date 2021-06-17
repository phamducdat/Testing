package connect;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.util.*;

public class SheetUtility extends Object {





    public static void main(String[] args) throws Exception {
        int[] input = {1,2,3,4,7,8,9,10,11,14,15,16,17,18,19,20,21,23};
        FileInputStream inputStream = new FileInputStream(new File("D://Project//Excel//schedule.xlsx"));

        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);

        XSSFSheet sheet = workbook.getSheetAt(0);


//        int a = sheet.getLastRowNum();
//        System.out.println("a = " + a);
        Iterator<Row> rowIterator = sheet.iterator();

        int k = input.length;
//        Row row1 = rowIterator.next();
        while (rowIterator.hasNext()){
            Row row = rowIterator.next();
            for(int i = 0; i <= k-1; i++){
                Cell cell = row.getCell(input[i]);
                CellType cellType = cell.getCellTypeEnum();

                switch (cellType) {
                    case _NONE:
                    case BLANK:
                        System.out.print("");
                        System.out.print("\t");
                        break;
                    case BOOLEAN:
                        System.out.print(cell.getBooleanCellValue());
                        System.out.print("\t");
                        break;
                    case NUMERIC:
                        System.out.print(cell.getNumericCellValue());
                        System.out.print("\t");
                        break;
                    case STRING:
                        System.out.print(cell.getStringCellValue());
                        System.out.print("\t");
                        break;
                    case ERROR:
                        System.out.print("!");
                        System.out.print("\t");
                        break;
                }
            }


            System.out.println("");
        }

    }
}
