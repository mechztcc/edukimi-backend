package com.edukimi.api.repositories;

import com.edukimi.api.domain.Parent;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ParentRepository extends JpaRepository<Parent, Integer>{
    
}
