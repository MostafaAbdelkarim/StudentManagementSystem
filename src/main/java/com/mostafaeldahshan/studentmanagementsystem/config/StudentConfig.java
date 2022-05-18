package com.mostafaeldahshan.studentmanagementsystem.config;

import com.mostafaeldahshan.studentmanagementsystem.model.Student;
import com.mostafaeldahshan.studentmanagementsystem.repo.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    //declaring a bean and CLR for running this piece of code whenever in spring boot app
    // args -> lambda
    //@Bean
    CommandLineRunner commandLineRunner(StudentRepository repository)
    {
        return args -> {
            Student Mostafa = new Student(
                    "Mostafa",
                    "Mostafa@hotmail.com",
                    LocalDate.of(1997, Month.MAY,17)
            );
            Student Haya = new Student(
                    "Hayoya",
                    "Hayoya@hotmail.com",
                    LocalDate.of(2000, Month.JANUARY,17)
            );
            repository.saveAll(List.of(Mostafa, Haya));
        };
    }
}