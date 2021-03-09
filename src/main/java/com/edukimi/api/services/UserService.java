package com.edukimi.api.services;

import java.util.List;
import java.util.Optional;

import com.edukimi.api.domain.User;
import com.edukimi.api.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    
    @Autowired
    private UserRepository repo;

    public User create(User user) {
        user = repo.save(user);
        return user;
    }

    public List<User> findAll() {
        List<User> users = repo.findAll();
        return users;
    }

    public User findById(Integer id) {
        Optional<User> obj = repo.findById(id);
        return obj.orElseThrow(() -> new RuntimeException("Usuário não encontrado!"));
    }


 
}
