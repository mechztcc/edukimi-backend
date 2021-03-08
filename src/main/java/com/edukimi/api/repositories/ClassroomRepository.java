package com.edukimi.api.repositories;

import com.edukimi.api.domain.Classroom;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassroomRepository extends JpaRepository<Classroom, Integer>{
    
}
