package com.example.employeedemo.reporsitory;

import com.example.employeedemo.model.EmployeeModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<EmployeeModel, String> {

}
