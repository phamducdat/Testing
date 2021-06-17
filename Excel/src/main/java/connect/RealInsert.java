package connect;

import com.concretepage.config.MongoDBCongfig;
import connect.entities.EduClass;
import connect.entities.EduCourse;
import connect.repository.IClassMongoRepo;
import connect.repository.ICourseMongoRepo;
import connect.repository.enums.CustomException;
import connect.repository.enums.Error;
import menthod.loosecoupling.abs.*;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.BulkOperations;
import org.springframework.data.mongodb.core.MongoTemplate;

import org.springframework.stereotype.Service;
import java.util.List;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.time.DayOfWeek;
import java.util.*;


@SpringBootApplication
@Service
public class RealInsert {

    public static LinkedHashMap<CustomException, Integer> errorLists = new LinkedHashMap<>();





    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(MongoDBCongfig.class);
        ctx.refresh();
        MongoTemplate mongoTemplate = ctx.getBean(MongoTemplate.class);
        BulkOperations bulkOperations = mongoTemplate.bulkOps(BulkOperations.BulkMode.UNORDERED,"class");


        ApplicationContext context = SpringApplication.run(RealInsert.class, args);
        IClassMongoRepo iClassMongoRepo = context.getBean(IClassMongoRepo.class);
        ICourseMongoRepo iCourseMongoRepo = context.getBean(ICourseMongoRepo.class);


        //TKB-20201-K65-1610
        FileInputStream inputStream = new FileInputStream(new File("D://Project//Test//Excel//TC.xlsx"));


        HashMap<String, Integer> listInputClass = new HashMap<>();
        HashMap<String, Integer> listInputCourse = new HashMap<>();

        HashSet<EduClass> listClassMongo = new HashSet<>();
        Set<EduCourse> listCourseMongo = new HashSet<>();

        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
        XSSFSheet sheet = workbook.getSheetAt(0);
        sheet.removeRow(sheet.getRow(0));
        Iterator<Row> rowIterator = sheet.iterator();
        Row row1 = rowIterator.next();
        Iterator<Cell> cellIterator = row1.cellIterator();

        if (cellIterator.next().getCellType() == CellType.BLANK || cellIterator.next().getCellType() == CellType._NONE){
            row1 = rowIterator.next();
            cellIterator = row1.cellIterator();
        }
        int i = 0;
        while (cellIterator.hasNext()) {
            Cell cell = cellIterator.next();
            String s = cell.getStringCellValue();
            s = StringUtils.deleteWhitespace(s);
            s = StringUtils.upperCase(s);
            switch (s) {
                case "MÃ_HP":
                    listInputClass.put(s, i);
                    listInputCourse.put(s, i);
                case "TÊN_HP":
                case "TÊN_HP_TIẾNG_ANH":
                case "KHOA_VIỆN":
                    listInputCourse.put(s, i);
                default:
                    listInputClass.put(s, i);
            }
            i = i + 1;
        }


        int j = 3;
        while (rowIterator.hasNext()) {
            j = j + 1;
            Row row = rowIterator.next();
            try {
                EduClass eduClass = new EduClass(
                        EduClass.normalizeInteger(row.getCell(listInputClass.get("MÃ_LỚP"))),
                        EduClass.normalizeInteger(row.getCell(listInputClass.get("MÃ_LỚP_KÈM"))),
                        EduClass.normalizeString(row.getCell(listInputClass.get("MÃ_HP"))),
                        EduClass.normalizeFisrt(row.getCell(listInputClass.get("KHỐI_LƯỢNG"))),
                        EduClass.normalizeString(row.getCell(listInputClass.get("GHI_CHÚ"))),
                        EduClass.normalizeDayOfWeek(row.getCell(listInputClass.get("THỨ"))),
                        EduClass.normalizeBeforeTime(row.getCell(listInputClass.get("THỜI_GIAN"))),
                        EduClass.normalizeAfterTime(row.getCell(listInputClass.get("THỜI_GIAN"))),
                        EduClass.normalizeShift(row.getCell(listInputClass.get("KÍP"))),
                        EduClass.normalizeString(row.getCell(listInputClass.get("TUẦN"))),
                        EduClass.normalizeString(row.getCell(listInputClass.get("PHÒNG"))),
                        EduClass.normalizeBoolean(row.getCell(listInputClass.get("CẦN_TN"))),
                        EduClass.normalizeInteger(row.getCell(listInputClass.get("SLĐK"))),
                        EduClass.normalizeInteger(row.getCell(listInputClass.get("SL_MAX"))),
                        EduClass.normalizeString(row.getCell(listInputClass.get("TRẠNG_THÁI"))),
                        EduClass.normalizeString(row.getCell(listInputClass.get("LOẠI_LỚP"))),
                        EduClass.normalizeString(row.getCell(listInputClass.get("MÃ_QL")))
                );


                listClassMongo.add(eduClass);
            } catch (CustomException e) {
                errorLists.put(e,j);
            }

        }
        if (errorLists.size() > 0) {
            System.out.println(Error.handleError(errorLists));
        }
        else {
            List<EduClass> eduClasses = new ArrayList<>(listClassMongo);
            iClassMongoRepo.saveAll(eduClasses);
        }

        System.out.println("--------------- FindAll -----------------");
    }
}
