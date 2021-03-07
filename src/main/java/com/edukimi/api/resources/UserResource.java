package com.edukimi.api.resources;

import com.edukimi.api.domain.User;
import com.edukimi.api.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
public class UserResource {

    @Autowired
    private UserService service;
    
    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public ResponseEntity findUser(@PathVariable Integer userId) {
        User obj = service.findById(userId);
        return ResponseEntity.ok(obj);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> create(@RequestBody User user) {
        User obj = service.create(user);
        return ResponseEntity.noContent().build();
    }

}
