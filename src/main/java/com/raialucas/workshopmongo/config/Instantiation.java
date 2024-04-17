package com.raialucas.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.raialucas.workshopmongo.domain.Post;
import com.raialucas.workshopmongo.domain.User;
import com.raialucas.workshopmongo.dto.AuthorDTO;
import com.raialucas.workshopmongo.repositories.PostRepository;
import com.raialucas.workshopmongo.repositories.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PostRepository postRepository;
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		userRepository.deleteAll();
		postRepository.deleteAll();
		User u1= new User(null,"Raia Lucas","raiacosta@gmail.com");
		User u2 = new User(null,"Maia","maia@gmail.com");
		User u3= new User(null,"Neto","neto@gmail.com");
		userRepository.saveAll(Arrays.asList(u1,u2,u3));
		Post p1= new Post(null, sdf.parse("12/09/2005"), "Partiu viagem!", "Vou viajar para França. Abraços!",new AuthorDTO(u3));
		Post p2= new Post(null,sdf.parse("28/04/2019"),"Dia Horrível!","Apostei minha casa em um jogo de futebol e perdi. Lamentável",new AuthorDTO(u1));
		
		
		
		postRepository.saveAll(Arrays.asList(p1,p2));
		
	}
  
	
}
