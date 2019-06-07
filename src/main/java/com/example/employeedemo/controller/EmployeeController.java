package com.example.employeedemo.controller;

import com.example.employeedemo.model.EmployeeModel;
import com.example.employeedemo.service.EmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/v1/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    @GetMapping("/")
    public List<EmployeeModel> getEmployeeDetails() {
        return employeeService.findAll();
    }

    @PostMapping("/")
    public EmployeeModel create(@RequestBody EmployeeModel employeeModel) {
        return employeeService.save(employeeModel);
    }

    @GetMapping("/{employeeId}")
    public EmployeeModel get(@PathVariable String employeeId) {
        Optional<EmployeeModel> employeeModel = employeeService.findById(employeeId);
        if (employeeModel.isPresent()) {
            return employeeModel.get();
        }
        return null;
    }

    @PutMapping("/{employeeId")
    public EmployeeModel update(@PathVariable String employeeId, @RequestBody EmployeeModel employeeModel) {
        Optional<EmployeeModel> existingEmployeeModel = employeeService.findById(employeeId);
        if(existingEmployeeModel.isPresent()) {
            BeanUtils.copyProperties(employeeModel, existingEmployeeModel);
            return employeeService.save(existingEmployeeModel.get());
        }
        return null;
    }

    @DeleteMapping("/{employeeId}")
    public void delete(@PathVariable String employeeId) {
        Optional<EmployeeModel> existingEmployeeModel = employeeService.findById(employeeId);
        if(existingEmployeeModel.isPresent()) {
            employeeService.deleteById(employeeId);
        }
    }

    @Autowired
    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
}


