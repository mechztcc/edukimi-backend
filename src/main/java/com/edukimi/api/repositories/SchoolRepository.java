package com.edukimi.api.repositories;

import java.util.List;

import com.edukimi.api.domain.School;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchoolRepository extends JpaRepository<School, Integer>{
    
    // public Database findAllByUserId(Integer id);
    // TODO criar método para buscar databases usando 'fk user_id'
    

    List<School> findAllByUserId(Integer userId);
}
