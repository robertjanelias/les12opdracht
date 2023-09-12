package com.example.les11model.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="teachers")
public class Teacher {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "first_name", length = 64)
    private String firstName;
    @Column(name = "last_name", length = 128)
    private String lastName;
    private LocalDate dob;

    private int salary;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
