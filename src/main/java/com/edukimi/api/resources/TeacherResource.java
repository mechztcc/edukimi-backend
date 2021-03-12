package com.edukimi.api.resources;

import java.net.URI;
import java.util.List;

import com.edukimi.api.domain.Teacher;
import com.edukimi.api.dto.TeacherDTO;
import com.edukimi.api.services.TeacherService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(value = "/teacher")
public class TeacherResource {
    
    @Autowired
    TeacherService teacherService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Teacher>> findAll() {
        List<Teacher> teachers = teacherService.findAll();
        return ResponseEntity.ok(teachers);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Teacher> findById(@PathVariable Integer id) {
        Teacher teacher = teacherService.findById(id);
        return ResponseEntity.ok(teacher);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Teacher> create(@RequestBody TeacherDTO teacherDto) {
        Teacher teacher = teacherService.fromDto(teacherDto);
        teacher = teacherService.create(teacher);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(teacher.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
