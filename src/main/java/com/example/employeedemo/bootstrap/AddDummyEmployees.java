package com.example.employeedemo.bootstrap;

import com.example.employeedemo.model.EmployeeModel;
import com.example.employeedemo.reporsitory.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j

public class AddDummyEmployees {
    @Bean
    CommandLineRunner initSalonDataBase(EmployeeRepository employeeRepository) {
        return args -> { employeeRepository.save(new EmployeeModel("001", "Sana", 23,
                    "https://i.pinimg.com/originals/1a/79/e1/1a79e169e38d19a39aa52853922be8be.jpg",
                    "sayini@gmail.com",  0771234567));

        };
    }


}