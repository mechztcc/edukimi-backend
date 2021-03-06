package com.edukimi.api.services;

import java.util.Optional;

import com.edukimi.api.domain.Database;
import com.edukimi.api.domain.User;
import com.edukimi.api.dto.DatabaseDTO;
import com.edukimi.api.repositories.DatabaseRepository;
import com.edukimi.api.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DatabaseService {
    
    @Autowired
    private DatabaseRepository databaseRepository;

    @Autowired
    private UserRepository userRepository;

    public Database create(DatabaseDTO objDto) {
        Optional<User> obj = userRepository.findById(objDto.getUserId());
        Database data = new Database(null, objDto.getName(), objDto.getStatus(), obj.get());
        data = databaseRepository.save(data);
        return data;
    }
}
