package com.mostafaeldahshan.studentmanagementsystem.controller;

import com.mostafaeldahshan.studentmanagementsystem.model.Student;
import com.mostafaeldahshan.studentmanagementsystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private StudentController service;

    List<String> courses;

    @ModelAttribute
    public void preLoad() {
        courses = new ArrayList<String>();
        courses.add("C");
        courses.add("CPP");
        courses.add("Java");
    }

    @RequestMapping(value = "/" , method = RequestMethod.GET)
    public String home(Model model, Student student) {
        model.addAttribute("courses", courses);
        return "register";
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public String register(@ModelAttribute("student") Student student, Model model) {
        System.out.println("get coursess:::"+student.getCourse());
        service.registerNewStudent(student);
        return "welcome";
    }
}
