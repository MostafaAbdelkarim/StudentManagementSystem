package com.mostafaeldahshan.studentmanagementsystem;

import com.mostafaeldahshan.studentmanagementsystem.model.Student;
import com.mostafaeldahshan.studentmanagementsystem.repo.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@SpringBootApplication
public class StudentManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementSystemApplication.class, args);
	}

	//Using this class to test HTTP requests from and to PostgreSQL db
	@Bean
	CommandLineRunner commandLineRunner(StudentRepository repository) {
		return args -> {
			Student Mostafa = new Student(
					"Mostafa",
					"Mostafa@hotmail.com",
					LocalDate.of(1997, Month.MAY, 17)
			);
			Student Haya = new Student(
					"Hayoya",
					"Hayoya@hotmail.com",
					LocalDate.of(2000, Month.JANUARY, 17)
			);
			repository.saveAll(List.of(Mostafa, Haya));
		};
	}
}
