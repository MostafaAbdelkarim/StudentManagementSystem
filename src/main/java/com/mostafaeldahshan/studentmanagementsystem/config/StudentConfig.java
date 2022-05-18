package com.mostafaeldahshan.studentmanagementsystem.config;

import com.mostafaeldahshan.studentmanagementsystem.model.Student;
import com.mostafaeldahshan.studentmanagementsystem.repo.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    //declaring a bean and CLR for running this piece of code whenever in spring boot app
    // args -> lambda
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository)
    {
        return args -> {
            Student Mostafa = new Student(
                    "Mostafa",
                    "ElDahshan",
                    "Mostafa@gmail.com",
                    "Male",
                    "Java",
                    "password",
                    "01015",
                    25,
                    "17/05/1997"
            );
            Student Haya = new Student(
                    "Hayoya",
                    "Gamal",
                    "Hayoya@gmail.com",
                    "Femal",
                    "C++",
                    "password",
                    "01015",
                    22,
                    "17/01/2000"
            );
            repository.saveAll(List.of(Mostafa, Haya));
        };
    }
}