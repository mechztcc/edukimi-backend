package com.edukimi.api;

import java.util.Arrays;

import com.edukimi.api.domain.Address;
import com.edukimi.api.domain.Classroom;
import com.edukimi.api.domain.School;
import com.edukimi.api.domain.Parent;
import com.edukimi.api.domain.Student;
import com.edukimi.api.domain.User;
import com.edukimi.api.repositories.AddressRepository;
import com.edukimi.api.repositories.ClassroomRepository;
import com.edukimi.api.repositories.SchoolRepository;
import com.edukimi.api.repositories.ParentRepository;
import com.edukimi.api.repositories.StudentRepository;
import com.edukimi.api.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiApplication implements CommandLineRunner {


	@Autowired
	UserRepository userRepository;

	@Autowired
	SchoolRepository schoolRepository;

	@Autowired
	StudentRepository studentRepository;

	@Autowired
	ParentRepository parentRepository;

	@Autowired
	AddressRepository addressRepository;

	@Autowired
	ClassroomRepository classroomRepository;

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		User user1 = new User(null, "Alberto", "Paiva", "alberto@email.com", "1234");
		User user2 = new User(null, "Claudio", "Ferreira", "claudio@email.com", "1234");

		School school1 = new School(null, "Santa maria", true, user1);
		School school2 = new School(null, "Necy amazonas", true, user1);

		Classroom clas1 = new Classroom(null, "6 A", true, school1);
		Classroom clas2 = new Classroom(null, "7 c", true, school1);
		Classroom clas3 = new Classroom(null, "8 A", true, school2);
		
		user1.setSchools(Arrays.asList(school1));
		
		
		userRepository.save(user1);

		schoolRepository.save(school1);
		schoolRepository.save(school2);
		
		classroomRepository.save(clas1);
		classroomRepository.save(clas2);
		classroomRepository.save(clas3);
		// Existe um erro ao cadastrar dados no database2
		
		userRepository.save(user2);
		schoolRepository.save(school2);


		Parent par1 = new Parent(null, "Robertinho carrara", "roberto@email.com", "81 9-8888-7777");
		parentRepository.save(par1);

		Address addr1 = new Address(null, "Rua do iate", "26", "53900-000", "Itamaracá", "Forno da cal");
		addressRepository.save(addr1);
		
		
		Student std1 = new Student(null, "Paulo", "222", true, "22/22/2222");
		std1.setAddress(addr1);
		std1.setParent(par1);
		std1.setClassroom(clas1);
		studentRepository.save(std1);
		


		
	}

}
