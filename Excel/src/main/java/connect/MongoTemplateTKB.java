package connect;

import com.concretepage.config.MongoDBCongfig;
import com.concretepage.entity.Student;
import connect.entities.EduClass;
import connect.entities.EduCourse;
import connect.repository.EShift;
import connect.repository.IClassMongoRepo;
import connect.repository.ICourseMongoRepo;
import menthod.loosecoupling.abs.*;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
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

import java.time.LocalDate;
import java.util.List;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.time.DayOfWeek;
import java.util.*;



public class MongoTemplateTKB {




    public static void main(String[] args) throws Exception {
        LocalDate date;
        DayOfWeek dayOfWeek = DayOfWeek.FRIDAY;
        EShift eShift = EShift.AFTERNOON;

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(MongoDBCongfig.class);
        ctx.refresh();
        MongoTemplate mongoTemplate = ctx.getBean(MongoTemplate.class);
        BulkOperations bulkOperations = mongoTemplate.bulkOps(BulkOperations.BulkMode.UNORDERED, "class");

        EduClass eduClass = new EduClass(
                123,
                23,
                "df",
                12,
                "dfdf",
                    dayOfWeek,
                    12,
                12,
                eShift,
                "dfd",
                "232",
                true,
                100,
                23,"dfd",
                "dfd",
                "ere");
//        bulkOperations.insert(eduClass);
        mongoTemplate.insert(eduClass, "class");
    }
}
