package com.mostafaeldahshan.studentmanagementsystem.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

//Entity and table annotations for later on queries
@Entity(name = "student")
@Table(name = "student", uniqueConstraints = {
        @UniqueConstraint(name = "student_mail_unique", columnNames = "email")
})
@Setter
@Getter
@NoArgsConstructor
@ToString
public class Student {
    //annotation of Id and SquenceGenerator for automated id generation and primary key of db
    @Id
    @SequenceGenerator(name = "student_id", sequenceName = "student_id", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_id")
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "firstName", nullable = false, columnDefinition = "TEXT")
    private String firstName;

    @Column(name = "lastName", nullable = false, columnDefinition = "TEXT")
    private String lastName;

    @Column(name = "email", nullable = false, columnDefinition = "TEXT")
    private String email;

    @Column(name = "gender", nullable = false, columnDefinition = "TEXT")
    private String gender;

    @Column(name = "course")
    private String course;

    @Column(name = "password", nullable = false, columnDefinition = "TEXT")
    private String password;

    @Column(name = "mobileNumber", nullable = false, columnDefinition = "TEXT")
    private String mobileNumber;

    //having var age transient so it can be automatically calculated not hardcoded
    //@Transient
    @Column(name = "age")
    private int age;

    @Column(name = "DOB", nullable = false, columnDefinition = "TEXT")
    private String dob;

    public Student(String firstName, String lastName, String email, String gender, String course, String password, String mobileNumber, int age, String dob) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.course = course;
        this.password = password;
        this.mobileNumber = mobileNumber;
        this.age = age;
        this.dob = dob;
    }
}