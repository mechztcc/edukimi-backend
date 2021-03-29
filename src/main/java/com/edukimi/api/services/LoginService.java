package com.edukimi.api.services;

import com.edukimi.api.domain.User;
import com.edukimi.api.dto.UserLoginDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


// All of this content is temporary and has testing purposes only, please implement a jwt.

@Service
public class LoginService {

    @Autowired
    UserService userService;

    public User validateUser(UserLoginDTO user) {

        User empt = new User();
        User obj = userService.findByEmail(user.getEmail());
        obj = obj.getPassword().equals(user.getPassword()) ?  obj : empt;
        return obj;


    }
}
