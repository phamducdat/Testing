package com.example.employeev2.controller;

import com.example.employeev2.service.EmployeeService;

import io.tej.SwaggerCodgen.api.EmployeesApi;
import io.tej.SwaggerCodgen.model.EmployeeList;
import io.tej.SwaggerCodgen.model.EmployeeReq;
import io.tej.SwaggerCodgen.model.EmployeeRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.Optional;

@RestController
@RequestMapping("/departments/backend/v1")
public class EmployeeController implements EmployeesApi {

    private final EmployeeService service;

    @Autowired
    public EmployeeController(EmployeeService service) {
        this.service = service;
    }


    @Override
    public ResponseEntity<EmployeeRes> addEmployee(EmployeeReq employeeRequest) {
        EmployeeRes employeeRes = service.addEmployee(employeeRequest);

        return new ResponseEntity<>(employeeRes, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> deleteEmployeeId(String employeeId) {
                service.deleteEmployee(employeeId);
        return  new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<EmployeeList> getAllEmployees() {
                        EmployeeList employeeList = service.getAllEmployees();
        System.out.println("In the API, we have: " + employeeList.size());
        return new ResponseEntity<>(employeeList, HttpStatus.OK);
    }


    @Override
    public ResponseEntity<EmployeeRes> getEmployeeById(String employeeId) {
        EmployeeRes employeeRes = service.getEmployById(employeeId);
        return new ResponseEntity<>(employeeRes, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<EmployeeRes> updateEmployee(String employeeId, EmployeeReq employeeRequest) {
        EmployeeRes employeeRes = service.updateEmployee(employeeId, employeeRequest);
        return new ResponseEntity<>(employeeRes, HttpStatus.OK);
    }
}
