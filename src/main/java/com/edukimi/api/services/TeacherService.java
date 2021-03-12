package com.edukimi.api.services;

import java.util.List;

import com.edukimi.api.domain.Teacher;
import com.edukimi.api.repositories.TeacherRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class TeacherService {
    

    @Autowired
    TeacherRepository teacherRepository;

    public List<Teacher> findAll() {
        List<Teacher> teachers = teacherRepository.findAll();
        return teachers;
    }
}
