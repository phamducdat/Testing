package stackoverflow;

import connect.repository.EShift;
import menthod.loosecoupling.IntegerNormalize;
import menthod.loosecoupling.Normalizer;
import menthod.loosecoupling.StringNormalizer;
import menthod.loosecoupling.abs.AbsIntegerNormalize;
import menthod.loosecoupling.abs.AbsNormalize;
import menthod.loosecoupling.abs.AbsStringNormalize;
import menthod.loosecoupling.abs.Father;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Iterator;
import java.util.List;

public class Schedule {

    public static Comparable normalize(Cell c, String status){
        String s = c.getStringCellValue();

        String input = StringUtils.deleteWhitespace(s);

        if(StringUtils.equalsIgnoreCase("NULL",input) || StringUtils.equalsIgnoreCase("",input))
            return null;
        else {
            //int: MÃ_LỚP, MÃ_LỚP_KÈM,SLĐK,SL_MAX
            //string: MÃ_HP, GHI_CHÚ, TUẦN, PHÒNG, TRẠNG_THÁI, LOẠI_LỚP, MÃ_QL, KÍP
            //boolean: CẦN_TN
            //EShift: KÍP
            //DayOfWeek: THỨ
            //split:KHỐI_LƯỢNG
            //special:THỜI_GIAN

            switch (status){
                case "MÃ_LỚP":
                case "MÃ_LỚP_KÈM":
                case "SLĐK":
                case "SL_MAX":
                    return NumberUtils.toInt(input);

                case "MÃ_HP":
                case "GHI_CHÚ":
                case "TUẦN":
                case "PHÒNG":
                case "TRẠNG_THÁI":
                case "LOẠI_LỚP":
                case "MÃ_QL":
                    return input;

                case "CẦN_TN":
                    return true;

                case "KHỐI_LƯỢNG":
                    return Integer.parseInt(StringUtils.substring(input,0,1));

//                case "BẮT_ĐẦU":
//
//                    return Integer.parseInt(StringUtils.substringBefore(input,"-"));
//
//                case "KẾT_THÚC":
//                    return Integer.parseInt(StringUtils.substringAfter(input,"-"));
                case "THỜI_GIAN":
                    if (StringUtils.contains(input,"-")) {
                        c.setCellValue(StringUtils.substringAfter(input,"-"));
                        return Integer.parseInt(StringUtils.substringBefore(input, "-"));
                    }
                    else {
                        return Integer.parseInt(input);
                    }

                case "KÍP":
                    return EShift.of(input);

                case "THỨ":
                    return DayOfWeek.of(Integer.parseInt(input));

            }
        }
        return null;
    }

    public static void main(String[] args) throws Exception {
        FileInputStream inputStream = new FileInputStream(new File("D://Project//Excel//OneCell.xlsx"));

        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);

        XSSFSheet sheet = workbook.getSheetAt(0);
        Iterator<Row> rowIterator = sheet.iterator();
        Row row = rowIterator.next();
//        DataFormatter formatter = new DataFormatter();
//        String s = formatter.formatCellValue(row.getCell(0));
//        System.out.println(s);
//
//
//        Row row1 = rowIterator.next();
//        Row row2 = rowIterator.next();
//        Row row2 = sheet.getRow(2);
//        for(Cell cell: row2){
//            CellType cellType = cell.getCellTypeEnum();
//
//            switch (cellType) {
//                case _NONE:
//                case BLANK:
//                    System.out.print("");
//                    System.out.print("\t");
//                    System.out.print("\t");
//                    break;
//                case BOOLEAN:
//                    System.out.print(cell.getBooleanCellValue());
//                    System.out.print("\t");
//                    System.out.print("\t");
//                    break;
//                case NUMERIC:
//                    System.out.print(cell.getNumericCellValue());
//                    System.out.print("no");
//                    System.out.print("\t");
//                    break;
//                case STRING:
//                    System.out.print(cell.getStringCellValue());
//                    System.out.print("ok");
//                    System.out.print("\t");
//                    break;
//                case ERROR:
//                    System.out.print("|");
//                    System.out.print("\t");
//                    System.out.print("\t");
//                    break;
//            }
//        }

//        while (rowIterator.hasNext()) {
//            Row row = rowIterator.next();
//            Iterator<Cell> cellIterator = row.cellIterator();
//
//            while (cellIterator.hasNext()) {
//                Cell cell = cellIterator.next();
//                CellType cellType = cell.getCellTypeEnum();
//
//
//                switch (cellType) {
//                    case _NONE:
//                    case BLANK:
//                        System.out.print("");
//                        System.out.print("\t");
//                        System.out.print("\t");
//                        break;
//                    case BOOLEAN:
//                        System.out.print(cell.getBooleanCellValue());
//                        System.out.print("\t");
//                        System.out.print("\t");
//                        break;
//                    case NUMERIC:
//                        System.out.print(cell.getNumericCellValue());
//                        System.out.print("no");
//                        System.out.print("\t");
//                        break;
//                    case STRING:
//                        System.out.print(cell.getStringCellValue());
//                        System.out.print("ok");
//                        System.out.print("\t");
//                        break;
//                    case ERROR:
//                        System.out.print("|");
//                        System.out.print("\t");
//                        System.out.print("\t");
//                        break;
//                }
//            }
//            System.out.println("");
//        }
//        Iterator<Cell> cellIterator = rowIterator.next();
//        for(Cell cell : row) {
//
//            System.out.println(Schedule.normalize(rơ,"THỨ"));
//        }
//
//        System.out.println(Schedule.normalize(row.getCell(0),"THỜI_GIAN"));
//        System.out.println(Schedule.normalize(row.getCell(0),"THỜI_GIAN"));

//        String s = new StringNormalizer(row.getCell(0));
//        Normalizer StringNormalizer = new StringNormalizer();
//        Normalizer normalizer1 = new IntegerNormalize();
//        String s =(String) StringNormalizer.normalize(row.getCell(0));
//        System.out.println(s);

        AbsNormalize absNormalize1 = new AbsStringNormalize();
        AbsNormalize absNormalize2 = new AbsIntegerNormalize();
//        System.out.println(absNormalize.formatString(row.getCell(0)));

        Integer s =(Integer) Father.normalize(absNormalize2,row.getCell(0));

        System.out.println(s);

//        List
    }
}
