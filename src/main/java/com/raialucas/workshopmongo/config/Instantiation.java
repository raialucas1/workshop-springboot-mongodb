package com.raialucas.workshopmongo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.raialucas.workshopmongo.domain.User;
import com.raialucas.workshopmongo.repositories.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository repository;
	@Override
	public void run(String... args) throws Exception {
		
		repository.deleteAll();
		User u1= new User(null,"Raia Lucas","raiacosta@gmail.com");
		User u2 = new User(null,"Maia","maia@gmail.com");
		User u3= new User(null,"Neto","neto@gmail.com");
		
		repository.saveAll(Arrays.asList(u1,u2,u3));
		
	}
  
	
}
