package com.edukimi.api.resources;

import com.edukimi.api.domain.User;
import com.edukimi.api.dto.UserLoginDTO;
import com.edukimi.api.services.LoginService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/login")
public class LoginResource {
    
    @Autowired
    LoginService loginService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<User> validateUser(@RequestBody UserLoginDTO user) {
        User obj = loginService.validateUser(user);
        return ResponseEntity.ok(obj);
    }
}
