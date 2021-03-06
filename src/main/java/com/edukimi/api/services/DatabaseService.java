package com.edukimi.api.services;

import com.edukimi.api.domain.Database;
import com.edukimi.api.repositories.DatabaseRepository;

import org.springframework.stereotype.Service;

@Service
public class DatabaseService {
    
    private DatabaseRepository repo;

    public Database create(Database database) {
        database = repo.save(database);
        return database;
    }
}
