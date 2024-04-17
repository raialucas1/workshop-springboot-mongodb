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
import com.raialucas.workshopmongo.dto.CommentDTO;
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
		Post p1= new Post(null, sdf.parse("12/09/2005"), "Partiu viagem!", "Vou viajar para França. Abraços!",new AuthorDTO(u1));
		Post p2= new Post(null,sdf.parse("28/04/2019"),"Dia Horrível!","Apostei minha casa em um jogo de futebol e perdi. Lamentável",new AuthorDTO(u1));
		
		CommentDTO c1= new CommentDTO("Boa viagem mano!",sdf.parse("12/09/2033"),new AuthorDTO(u1));
		CommentDTO c2= new CommentDTO("Aproveite",sdf.parse("12/03/2002"),new AuthorDTO(u1));
		CommentDTO c3= new CommentDTO("KKKKKKKKKKKK",sdf.parse("23/02/2312"),new AuthorDTO(u3));
		
		p1.getComments().addAll(Arrays.asList(c1,c2));
		p2.getComments().addAll(Arrays.asList(c3));
		postRepository.saveAll(Arrays.asList(p1,p2));
		
		u1.getPosts().addAll(Arrays.asList(p1,p2));
		userRepository.save(u1);
	}
  
	
}
