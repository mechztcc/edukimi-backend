package com.edukimi.api.services;

import java.util.List;
import java.util.Optional;

import com.edukimi.api.domain.School;
import com.edukimi.api.domain.Teacher;
import com.edukimi.api.dto.TeacherDTO;
import com.edukimi.api.repositories.TeacherRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherService {
    

    @Autowired
    TeacherRepository teacherRepository;

    @Autowired
    SchoolService schoolService;

    public List<Teacher> findAll() {
        List<Teacher> teachers = teacherRepository.findAll();
        return teachers;
    }

    public Teacher findById(Integer id) {
        Optional<Teacher> teacher = teacherRepository.findById(id);
        return teacher.orElseThrow(() -> new RuntimeException("Professor não encontrado!"));
    }

    public Teacher create(Teacher teacher) {
        teacher = teacherRepository.save(teacher);
        return teacher;
    }

    public Teacher fromDto(TeacherDTO teacherDto) {
        School school = schoolService.findById(teacherDto.getSchoolId());
        Teacher teacher = new Teacher(null, teacherDto.getName(), teacherDto.getStatus(), school);
        return teacher;
    }
}
