package com.edukimi.api.services;

import java.util.List;
import java.util.Optional;

import com.edukimi.api.domain.School;
import com.edukimi.api.domain.User;
import com.edukimi.api.dto.SchoolDTO;
import com.edukimi.api.repositories.SchoolRepository;
import com.edukimi.api.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SchoolService {
    
    @Autowired
    private SchoolRepository schoolRepository;

    @Autowired
    private UserRepository userRepository;

    public School create(SchoolDTO objDto, Integer userId) {
        Optional<User> obj = userRepository.findById(userId);
        School school = new School(null, objDto.getName(), objDto.getStatus(), obj.get());
        school = schoolRepository.save(school);
        return school;
    }

    public List<School> findAll(Integer userId) {
        List<School> school = schoolRepository.findAllByUserId(userId);
        return school;
    }

    public School findById(Integer id) {
        Optional<School> obj = schoolRepository.findById(id);
        return obj.orElseThrow(() -> new RuntimeException("Escola não encontrada!"));
    }

    public School update(SchoolDTO schoolDto, Integer id) {
        School obj = schoolRepository.findById(id).get();
        obj.setName(schoolDto.getName());
        obj.setStatus(schoolDto.getStatus());
        schoolRepository.save(obj);
        return obj;
    }



}
