package com.edukimi.api.resources;

import java.net.URI;

import com.edukimi.api.domain.School;
import com.edukimi.api.dto.SchoolDTO;
import com.edukimi.api.services.SchoolService;
import com.edukimi.api.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(value = "/school")
public class SchoolResource {

    @Autowired
    private SchoolService schoolService;

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> create(@RequestBody SchoolDTO objDto, @RequestHeader Integer userId) {
        School obj = schoolService.create(objDto, userId);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@RequestBody SchoolDTO objDto, @PathVariable Integer id) {
        School school = schoolService.update(objDto, id);
        return ResponseEntity.status(201).build();
    }

    // @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    // public ResponseEntity<List<School>> findAllByUserId(@PathVariable Integer id) {
    //     List<School> schools = schoolService.findAll(id);

    //     return ResponseEntity.ok(schools);
    // }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<School> findById(@PathVariable Integer id) {
        School schools = schoolService.findById(id);
        return ResponseEntity.ok(schools);
    }



}
