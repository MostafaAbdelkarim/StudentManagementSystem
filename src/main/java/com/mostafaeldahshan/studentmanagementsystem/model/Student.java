package com.mostafaeldahshan.studentmanagementsystem.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

//Entity and table annotations for later on queries
@Entity(name = "Student")
@Table(name = "Student", uniqueConstraints = {
        @UniqueConstraint(name = "student_mail_unique", columnNames = "email")
})
public class Student {
    //annotation of Id and SquenceGenerator for automated id generation and primary key of db
    @Id
    @SequenceGenerator(name = "student_id", sequenceName = "student_id", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_id")
    @Column(name = "id", updatable = false)
    private Long id;
    @Column(name = "name", nullable = false, columnDefinition = "TEXT")
    private String name;
    @Column(name = "email", nullable = false, columnDefinition = "TEXT")
    private String email;
    //having var age transient so it can be automatically calculated not hardcoded
    @Transient
    @Column(name = "age")
    private int age;
    private LocalDate dob;

    public Student() {
    }

    public Student(Long id, String name, String email, LocalDate dob) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.dob = dob;
    }

    public Student(String name, String email, LocalDate dob) {
        this.name = name;
        this.email = email;
        this.dob = dob;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    //automation of age
    public int getAge() {
        return Period.between(this.dob, LocalDate.now()).getYears();
    }

    public void setAge(int age) {
        this.age = age;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", dob=" + dob +
                '}';
    }
}