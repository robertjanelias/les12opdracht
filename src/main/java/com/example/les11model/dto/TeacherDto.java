package com.example.les11model.dto;

import jakarta.validation.constraints.*;

import java.time.LocalDate;

public class TeacherDto {
    public Long id;
    @NotBlank(message = "leeg")
    public String firstName;
    @Size(min=3, max=128)
    public String lastName;
    @Past
    public LocalDate dob;

    @Min(0)
    @Max(100_000)
    public int salary;
}
