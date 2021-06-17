package com.concretepage;

import com.concretepage.config.MongoDBCongfig;
import com.concretepage.entity.Student;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.BulkOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.Arrays;
import java.util.List;
import java.util.Queue;

public class MongoTemplateTest {
//    public static void main(String[] args) {
//        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
//        ctx.register(MongoDBCongfig.class);
//        ctx.refresh();
//        MongoTemplate mongoTemplate = ctx.getBean(MongoTemplate.class);
//
//        mongoTemplate.dropCollection(Student.class);
//
////        Student ram = new Student(11, "Ram", 19);
//        Student shyam = new Student(102, "Shyam", 19);
//        Student mohan = new Student(103, "Mohan", 20);
////        Student ram2 = new Student(1000001, "Ra", 19);
////        mongoTemplate.insert(Arrays.asList(ram,shyam,mohan),Student.class);
//
//
//        BulkOperations bulkOperations = mongoTemplate.bulkOps(BulkOperations.BulkMode.UNORDERED,Student.class);
////        bulkOperations.insert(Arrays.asList(ram,shyam,mohan));
//        Query query = new Query();
//        query.addCriteria(Criteria.where("age").is(19));
//        List<Student> list = mongoTemplate.find(query,Student.class,"student");
//        list.forEach(std-> System.out.println(std.getName() + " - " + std.getAge()));
//
//        ctx.registerShutdownHook();
//        ctx.close();
//    }
}
