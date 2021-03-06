package com.edukimi.api.resources;

import com.edukimi.api.domain.Database;
import com.edukimi.api.dto.DatabaseDTO;
import com.edukimi.api.services.DatabaseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/database")
public class DatabaseResource {
    
    @Autowired
    private DatabaseService service;

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public ResponseEntity<Void> create(@RequestBody DatabaseDTO objDto) {
        Database obj = service.create(objDto);
        return ResponseEntity.noContent().build();
        // TODO implementar uma camada DTO para receber um objeto com id do usuário + database, realizar a busca desse usuário no banco,
        // adicionar esse usuário ao obj database, e então, salvar no banco.
    }
}
