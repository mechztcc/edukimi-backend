package com.edukimi.api.resources;

import com.edukimi.api.domain.Database;
import com.edukimi.api.services.DatabaseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/database")
public class DatabaseResource {
    
    @Autowired
    private DatabaseService service;

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public ResponseEntity<Void> create(@RequestBody Database database) {
        database = service.create(database);
        return ResponseEntity.noContent().build();
    }
}
