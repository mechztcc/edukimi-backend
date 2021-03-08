package com.edukimi.api.resources;

import com.edukimi.api.domain.Classroom;
import com.edukimi.api.dto.ClassroomDTO;
import com.edukimi.api.services.ClassroomService;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/classroom")
public class ClassroomResource {
    
    @Autowired
    ClassroomService classroomService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> create(@RequestBody ClassroomDTO classDto) {
        Classroom obj = classroomService.create(classDto);
        return ResponseEntity.noContent().build();
    }
}
