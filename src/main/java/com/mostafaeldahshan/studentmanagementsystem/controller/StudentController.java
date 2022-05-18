package com.mostafaeldahshan.studentmanagementsystem.controller;

import com.mostafaeldahshan.studentmanagementsystem.model.Student;
import com.mostafaeldahshan.studentmanagementsystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//defines that this class is a rest api and has a reachable path of "newAPI/Students"
@RestController
@RequestMapping(path = "api/v1/students")
public class StudentController {

    private final StudentService studentService;

    //separating the API from the service that actually has logic
    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    //retrieving list of students from StudentService
    @GetMapping
    public List<Student> getStudents()
    {
        return studentService.getStudents();
    }

    //posting new students to service which will post to repo(aka database)
    @PostMapping
    public void registerNewStudent(@RequestBody Student student)
    {
        studentService.addNewStudent(student);
    }

    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long studentId)
    {
        studentService.deleteStudent(studentId);
    }
    @PutMapping(path = "{studentId}")
    public void updateStudent(@PathVariable("studentId") Long studentId, @RequestParam(required = false) String name, @RequestParam(required = false) String email)
    {
        studentService.updateStudentInfo(studentId, name, email);
    }
}
