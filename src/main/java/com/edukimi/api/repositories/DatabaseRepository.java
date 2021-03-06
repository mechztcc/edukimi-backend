package com.edukimi.api.repositories;

import com.edukimi.api.domain.Database;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DatabaseRepository extends JpaRepository<Database, Integer>{
    
}
