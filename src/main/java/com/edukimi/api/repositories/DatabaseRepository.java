package com.edukimi.api.repositories;

import java.util.List;

import com.edukimi.api.domain.Database;
import com.edukimi.api.domain.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DatabaseRepository extends JpaRepository<Database, Integer>{
    
    // public Database findAllByUserId(Integer id);
    // TODO criar método para buscar databases usando 'fk user_id'

    List<Database> findAllByUserId(Integer userId);
}
