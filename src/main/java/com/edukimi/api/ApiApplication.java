package com.edukimi.api;

import java.util.Arrays;

import com.edukimi.api.domain.Address;
import com.edukimi.api.domain.Classroom;
import com.edukimi.api.domain.Database;
import com.edukimi.api.domain.Parent;
import com.edukimi.api.domain.Student;
import com.edukimi.api.domain.User;
import com.edukimi.api.repositories.AddressRepository;
import com.edukimi.api.repositories.ClassroomRepository;
import com.edukimi.api.repositories.DatabaseRepository;
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
	DatabaseRepository databaseRepository;

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

		Database data1 = new Database(null, "Santa maria", true, user1);
		Database data2 = new Database(null, "Necy amazonas", true, user1);

		Classroom clas1 = new Classroom(null, "6 A", true, data1);
		Classroom clas2 = new Classroom(null, "7 c", true, data1);
		Classroom clas3 = new Classroom(null, "8 A", true, data2);
		
		user1.setDatabases(Arrays.asList(data1));
		
		
		userRepository.save(user1);

		databaseRepository.save(data1);
		databaseRepository.save(data2);
		
		classroomRepository.save(clas1);
		classroomRepository.save(clas2);
		classroomRepository.save(clas3);
		// Existe um erro ao cadastrar dados no database2
		
		userRepository.save(user2);
		databaseRepository.save(data2);


		Parent par1 = new Parent(null, "Robertinho carrara", "roberto@email.com", "81 9-8888-7777");
		parentRepository.save(par1);

		Address addr1 = new Address(null, "Rua do iate", "26", "53900-000", "Itamaracá", "Forno da cal");
		addressRepository.save(addr1);
		
		
		Student std1 = new Student(null, "222", true, "22/22/2222", par1, addr1);
		studentRepository.save(std1);
		


		
	}

}
