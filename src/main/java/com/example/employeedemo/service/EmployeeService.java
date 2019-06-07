package com.example.employeedemo.service;

import com.example.employeedemo.model.EmployeeModel;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    List<EmployeeModel> findAll();
    Optional<EmployeeModel> findById(String employeeId);
    EmployeeModel save(EmployeeModel employeeModel);
    void deleteById(String employeeId);
}
