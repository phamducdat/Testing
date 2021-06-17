package com.concretepage.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@AllArgsConstructor
public class Student {
    @Id
    private Integer id;
    private String name;
    private Integer age;


}
