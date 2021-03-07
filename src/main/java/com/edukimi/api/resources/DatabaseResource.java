package com.edukimi.api.resources;

import java.util.Arrays;
import java.util.List;

import com.edukimi.api.domain.Database;
import com.edukimi.api.domain.User;
import com.edukimi.api.dto.DatabaseDTO;
import com.edukimi.api.services.DatabaseService;
import com.edukimi.api.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/database")
public class DatabaseResource {
    
    @Autowired
    private DatabaseService databaseService;

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> create(@RequestBody DatabaseDTO objDto) {
        Database obj = databaseService.create(objDto);
        return ResponseEntity.noContent().build();
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<Database>> findAllByUserId(@PathVariable Integer id) {
        List<Database> databases = databaseService.findAll(id);

        return ResponseEntity.ok(databases);
    }


}
