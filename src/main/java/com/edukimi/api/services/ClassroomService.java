package com.edukimi.api.services;

import java.util.Optional;

import com.edukimi.api.domain.Classroom;
import com.edukimi.api.domain.Database;
import com.edukimi.api.dto.ClassroomDTO;
import com.edukimi.api.repositories.ClassroomRepository;
import com.edukimi.api.repositories.DatabaseRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClassroomService {
    
    @Autowired
    private ClassroomRepository classroomRepository;

    @Autowired
    private DatabaseRepository databaseRepository;

    public Classroom create(ClassroomDTO classDto) {

        Optional<Database> database = databaseRepository.findById(classDto.getDatabaseId());

        Classroom classroom = new Classroom(null, classDto.getName(), classDto.isStatus(), database.get());
        classroomRepository.save(classroom);
        return classroom;
        
    }
}
