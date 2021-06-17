package com.concretepage.repository;

import com.concretepage.entity.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface StudenRepository extends MongoRepository<Student, Integer> {
    Student getStudentById(int id);
    List<Student> getStudentByAge(int age);
}
