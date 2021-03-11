package com.edukimi.api.resources;

import java.net.URI;

import com.edukimi.api.domain.Student;
import com.edukimi.api.dto.StudentCreateDTO;
import com.edukimi.api.services.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(value = "/student")
public class StudentResource {
    
    @Autowired
    StudentService studentService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity create(@RequestBody StudentCreateDTO studentCreateDto) {
        Student obj = studentService.fromDto(studentCreateDto);
        obj = studentService.create(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity findById(@PathVariable Integer id) {
        Student obj = studentService.findById(id);
        
        return ResponseEntity.ok(obj);
    }
}
    

