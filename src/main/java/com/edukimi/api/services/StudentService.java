package com.edukimi.api.services;

import java.util.Optional;

import com.edukimi.api.domain.Address;
import com.edukimi.api.domain.Classroom;
import com.edukimi.api.domain.Parent;
import com.edukimi.api.domain.Student;
import com.edukimi.api.dto.StudentCreateDTO;
import com.edukimi.api.repositories.AddressRepository;
import com.edukimi.api.repositories.ClassroomRepository;
import com.edukimi.api.repositories.ParentRepository;
import com.edukimi.api.repositories.StudentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    
    @Autowired
    StudentRepository studentRepository;

    @Autowired
    AddressRepository addressRepository;

    @Autowired
    ParentRepository parentRepository;

    @Autowired
    ClassroomRepository classroomRepository;


    public Student create(Student student) {
        student = studentRepository.save(student);
        return student;

    }

    public Student findById(Integer id) {
        Optional<Student> obj = studentRepository.findById(id);
        return obj.orElseThrow(() -> new RuntimeException("Classroom não encontrado!"));
    }

    public Student fromDto(StudentCreateDTO studentCreateDto) {
        Classroom classroom = classroomRepository.findById(studentCreateDto.getClassroom()).get();
        Address addrs = new Address(null, studentCreateDto.getStreet(), studentCreateDto.getNumber(), studentCreateDto.getZip(), studentCreateDto.getCity(), studentCreateDto.getDistrict());
        addrs = addressRepository.save(addrs);

        Parent parent = new Parent(null, studentCreateDto.getName(), studentCreateDto.getEmail(), studentCreateDto.getPhone());
        parent = parentRepository.save(parent);
        Student std = new Student(null, studentCreateDto.getName(), studentCreateDto.getRegistration(), studentCreateDto.getStatus(), studentCreateDto.getBirth());

        std.setAddress(addrs);
        std.setParent(parent);
        std.setClassroom(classroom);

        return std;
    }
}
