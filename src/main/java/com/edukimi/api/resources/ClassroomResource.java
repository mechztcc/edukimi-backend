package com.edukimi.api.resources;

import java.net.URI;
import java.util.List;

import com.edukimi.api.domain.Classroom;
import com.edukimi.api.dto.ClassroomDTO;
import com.edukimi.api.services.ClassroomService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(value = "/classroom")
public class ClassroomResource {
    
    @Autowired
    ClassroomService classroomService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> create(@RequestBody ClassroomDTO classDto) {
        Classroom obj = classroomService.create(classDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Classroom>> findAll() {
        List<Classroom> obj = classroomService.findAll();
        return ResponseEntity.ok(obj);
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Classroom> findById(@PathVariable Integer id) {
        Classroom obj = classroomService.findById(id);
        return ResponseEntity.ok(obj);
    }
}
