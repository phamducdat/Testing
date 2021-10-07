package com.example.testdemo;

import java.util.List;

public interface TodoRepository {

    List<Todo> findAll();

    Todo findById(int id);
}
