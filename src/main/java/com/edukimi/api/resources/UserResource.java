package com.edukimi.api.resources;

import java.net.URI;
import java.util.List;

import com.edukimi.api.domain.User;
import com.edukimi.api.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(value = "/user")
public class UserResource {

    @Autowired
    private UserService service;
    
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity findAllUser() {
        List<User> obj = service.findAll();
        return ResponseEntity.ok(obj);
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity findUser(@PathVariable Integer id) {
        User obj = service.findById(id);
        return ResponseEntity.ok(obj);
    }


    // @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    // public ResponseEntity update(@PathVariable Integer id, @RequestBody User user) {

    //     }
    //     return ResponseEntity.ok(obj);
    // }



    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> create(@RequestBody User user) {
        User obj = service.create(user);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

}
