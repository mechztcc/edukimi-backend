package com.edukimi.api.repositories;

import com.edukimi.api.domain.Teacher;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Integer>{
    
}
