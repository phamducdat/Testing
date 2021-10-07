package com.example.employeev2.mapper;


import com.example.employeev2.entity.EmployeeEntity;
import com.example.employeev2.repository.EmployeeRepository;
import io.tej.SwaggerCodgen.model.EmployeeList;
import io.tej.SwaggerCodgen.model.EmployeeReq;
import io.tej.SwaggerCodgen.model.EmployeeRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeMapper {

    private final EmployeeRepository repository;

    @Autowired
    public EmployeeMapper(EmployeeRepository repository) {
        this.repository = repository;
    }


    public EmployeeRes mapEmployeeResFromEmployeeEntity(EmployeeEntity from) {
        EmployeeRes to = new EmployeeRes();
        to.setEmployeeId(from.getEmployeeId());
        to.setEmail(from.getEmail());
        to.setFirstName(from.getFirstName());
        to.setLastName(from.getLastName());
        return  to;
    }
    public EmployeeList mapEmployeeListFromEmployeeEntities(List<EmployeeEntity> from) {
        EmployeeList employeeList = new EmployeeList();
        from.forEach(employeeEntity -> {
            employeeList.add(mapEmployeeResFromEmployeeEntity(employeeEntity));
        });
        return employeeList;
    }

    public EmployeeEntity mapEmployeeEntityFromEmployeeReq(EmployeeReq from) {
        EmployeeEntity to = new EmployeeEntity();
        to.setEmployeeId(UUID.randomUUID().toString());
        to.setEmail(from.getEmail());
        to.setLastName(from.getLastName());
        to.setFirstName(from.getFirstName());

        return to;
    }

    public EmployeeEntity mapEmployeeEntityToEmployeeReq (String id, EmployeeReq from) {
        EmployeeEntity to = repository.getById(id);

        to.setFirstName(from.getFirstName());
        to.setLastName(from.getLastName());
        to.setEmail(from.getEmail());

        return to;
    }

}
