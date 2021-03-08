package com.edukimi.api.repositories;

import com.edukimi.api.domain.Student;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer>{
    
}
