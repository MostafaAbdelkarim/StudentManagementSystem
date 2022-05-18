package com.mostafaeldahshan.studentmanagementsystem.service;

import com.mostafaeldahshan.studentmanagementsystem.model.Student;
import com.mostafaeldahshan.studentmanagementsystem.repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

//defining this as service to mark up
@Service
public class StudentService {

    private  final StudentRepository studentRepository;

    // wiring the constructor to repo(aka db)
    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    //retrieving students from repo(aka db)
    public List<Student> getStudents()
    {
        return studentRepository.findAll();
    }

    //adding new students to repo(aka db)
    public void addNewStudent(Student student)
    {
        Optional<Student> studentOptional = studentRepository.findStudentByEmail(student.getEmail());
        if(studentOptional.isPresent())
        {
            throw new IllegalStateException("already exists");
        }
        studentRepository.save(student);
    }

    public void deleteStudent(Long studentId)
    {
        boolean exists = studentRepository.existsById(studentId);
        if(!exists)
        {
            throw new IllegalStateException("Not found");
        }
        studentRepository.deleteById(studentId);
    }

    @Transactional
    public void updateStudentInfo(Long studentId, String name, String email)
    {
        Student student = studentRepository.findById(studentId).orElseThrow(() -> new IllegalStateException("not found"));
        if(name != null && name.length() > 0 && !Objects.equals(student.getName(), name))
        {
            student.setName(name);
        }
        if(email != null && email.length() > 0 && !Objects.equals(student.getEmail(), email))
        {
            student.setEmail(email);
        }
    }
}
