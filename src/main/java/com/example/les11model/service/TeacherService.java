package com.example.les11model.service;

import com.example.les11model.dto.TeacherDto;
import com.example.les11model.exception.ResourceAlreadyExistsException;
import com.example.les11model.model.Teacher;
import com.example.les11model.repository.TeacherRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeacherService {

    private final TeacherRepository repos;

    public TeacherService(TeacherRepository repos) {
        this.repos = repos;
    }

    public TeacherDto createTeacher(TeacherDto teacherDto) {
        if (repos.existsByFirstNameIgnoreCaseAndLastNameIgnoreCase(teacherDto.firstName, teacherDto.lastName)) {
            throw new ResourceAlreadyExistsException("Teacher already exists!");
        }
        else {
            Teacher teacher = new Teacher();
            teacher.setFirstName(teacherDto.firstName);
            teacher.setLastName(teacherDto.lastName);
            teacher.setDob(teacherDto.dob);
            repos.save(teacher);
            teacherDto.id = teacher.getId();
            return teacherDto;
        }
    }

    public List<TeacherDto> getTeachers() {
        List<Teacher> teachers = repos.findAll();
        List<TeacherDto> teacherDtos = new ArrayList<>();
        for (Teacher t : teachers) {
            TeacherDto tdto = new TeacherDto();
            tdto.id = t.getId();
            tdto.dob = t.getDob();
            tdto.firstName = t.getFirstName();
            tdto.lastName = t.getLastName();
            teacherDtos.add(tdto);
        }
        return teacherDtos;
    }
}
