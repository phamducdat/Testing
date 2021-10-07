package com.example.employeev2.service;


import com.example.employeev2.entity.EmployeeEntity;
import com.example.employeev2.mapper.EmployeeMapper;
import com.example.employeev2.repository.EmployeeRepository;
import io.tej.SwaggerCodgen.model.EmployeeList;
import io.tej.SwaggerCodgen.model.EmployeeReq;
import io.tej.SwaggerCodgen.model.EmployeeRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.chrono.IsoEra;
import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepository repository;
    private final EmployeeMapper mapper;

    @Autowired
    public EmployeeService(EmployeeRepository repository, EmployeeMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public EmployeeList getAllEmployees() {
        System.out.println(repository.findAll().size());
        return mapper.mapEmployeeListFromEmployeeEntities(repository.findAll());
    }

    public EmployeeRes addEmployee(EmployeeReq from) {
        EmployeeEntity employeeEntity  = repository.save(mapper.mapEmployeeEntityFromEmployeeReq(from));

        return mapper.mapEmployeeResFromEmployeeEntity(employeeEntity);
    }

    public EmployeeRes updateEmployee(String id, EmployeeReq from) {
        EmployeeEntity to = mapper.mapEmployeeEntityToEmployeeReq(id, from);
        EmployeeEntity saved = repository.save(to);

        return mapper.mapEmployeeResFromEmployeeEntity(saved);
    }

    public void deleteEmployee(String id) {
        repository.deleteById(id);
    }

    public EmployeeRes getEmployById(String id) {
        EmployeeEntity to = repository.getById(id);

        return mapper.mapEmployeeResFromEmployeeEntity(to);

    }
}
