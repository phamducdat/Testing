package openplanning;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

public class ReadExcelDemo {
    public static void main(String[] args) throws Exception {
        FileInputStream inputStream = new FileInputStream(new File("D://Project//Excel//Real.xlsx"));
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);

        XSSFSheet sheet = workbook.getSheetAt(0);

        Iterator<Row> rowIterator = sheet.iterator();

        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();

            Iterator<Cell> cellIterator = row.cellIterator();

//            while(cellIterator.hasNext()){
//                Cell cell = cellIterator.next();
//
//                CellType cellType = cell.getCellTypeEnum();
//
//                switch (cellType) {
//                    case _NONE:
//                    case BLANK:
//                        System.out.print("");
//                        System.out.print("\t");
//                        break;
//                    case BOOLEAN:
//                        System.out.print(cell.getBooleanCellValue());
//                        System.out.print("\t");
//                        break;
//                    case NUMERIC:
//                        System.out.print(cell.getNumericCellValue());
//                        System.out.print("\t");
//                        break;
//                    case STRING:
//                        System.out.print(cell.getStringCellValue());
//                        System.out.print("\t");
//                        break;
//                    case ERROR:
//                        System.out.print("!");
//                        System.out.print("\t");
//                        break;
//                }
            }
            System.out.println("");
        }
    }


