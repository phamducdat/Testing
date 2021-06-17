package connect;

import connect.entities.Class;
import connect.repository.play.ClassRepository;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@SpringBootApplication
public class FakeInsert {
    public static void main(String[] args) throws Exception {
        ApplicationContext context = SpringApplication.run(FakeInsert.class, args);
        ClassRepository classRepository = context.getBean(ClassRepository.class);
        System.out.println("--------------- Insert -----------------");
        FileInputStream inputStream = new FileInputStream(new File("D://Project//Excel//schedule.xlsx"));
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
        XSSFSheet sheet = workbook.getSheetAt(0);
//        SheetUtility.deleteColumn(sheet,0);
//        SheetUtility.deleteColumn(sheet,0);
//        SheetUtility.deleteColumn(sheet,3);
//        SheetUtility.deleteColumn(sheet,3);
//        SheetUtility.deleteColumn(sheet,5);
//        SheetUtility.deleteColumn(sheet,7);
//        SheetUtility.deleteColumn(sheet,7);
//        SheetUtility.deleteColumn(sheet,15);

        Iterator<Row> rowIterator = sheet.iterator();

        while (rowIterator.hasNext()){
            Row row = rowIterator.next();
            List<Cell> cellList = new ArrayList<>();
            Iterator<Cell> cellIterator = row.cellIterator();
            while (cellIterator.hasNext()){
                Cell cell = cellIterator.next();

                cellList.add(cell);
            }
            Class class1 = new Class();

            class1.setClassId((int) cellList.get(0).getNumericCellValue());
            class1.setAttachedClassId((int) cellList.get(1).getNumericCellValue());
            class1.setCourseId(cellList.get(2).getStringCellValue());
            class1.setCredit( cellList.get(3).getStringCellValue());
            class1.setNote(cellList.get(4).getStringCellValue());
            class1.setDayOfWeek((int)cellList.get(5).getNumericCellValue());
            class1.setStartTime(cellList.get(6).getStringCellValue());
            class1.setEndTime(cellList.get(6).getStringCellValue());
            class1.setShift(cellList.get(7).getStringCellValue());
            class1.setWeeks(cellList.get(8).getStringCellValue());
            class1.setRoom(cellList.get(9).getStringCellValue());
            class1.setNeedExperiment(cellList.get(10).getStringCellValue());
            class1.setNumRegistration(cellList.get(11).getStringCellValue());
            class1.setMaxQuantity((int) cellList.get(12).getNumericCellValue());
            class1.setStatus(cellList.get(13).getStringCellValue());
            class1.setClassType(cellList.get(14).getStringCellValue());
            class1.setManagementId(cellList.get(15).getStringCellValue());

            classRepository.save(class1);
            System.out.println("--------------- FindAll -----------------");







        }

        List<Class> allClasses = classRepository.findAll();
        for(Class classes: allClasses){
            System.out.println(classes);
        }
    }

}
