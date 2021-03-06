package com.edukimi.api;

import com.edukimi.api.domain.Database;
import com.edukimi.api.domain.User;
import com.edukimi.api.repositories.DatabaseRepository;
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


	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		User user1 = new User(null, "Alberto", "Paiva", "alberto@email.com", "1234");
		User user2 = new User(null, "Alberto", "Paiva", "alberto@email.com", "1234");

		Database data1 = new Database(null, "Escola", true, user1);
		Database data2 = new Database(null, "Escola", true, user1);
		
		userRepository.save(user1);
		databaseRepository.save(data1);
		
		userRepository.save(user2);
		databaseRepository.save(data2);

		
	}

}
