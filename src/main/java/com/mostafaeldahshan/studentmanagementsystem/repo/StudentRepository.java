package com.mostafaeldahshan.studentmanagementsystem.repo;

import com.mostafaeldahshan.studentmanagementsystem.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    //explicitly saying that this is the query im trying to run but it can be commented
    // "Student" in the query refers to @Entity of Class Student
    @Query("SELECT s FROM  Student s WHERE s.email = ?1")
    Optional<Student> findStudentByEmail(String email);
}