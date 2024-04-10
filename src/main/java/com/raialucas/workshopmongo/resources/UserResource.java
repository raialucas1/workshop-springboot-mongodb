package com.raialucas.workshopmongo.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.raialucas.workshopmongo.domain.User;

@RestController
@RequestMapping(value="/users")
public class UserResource {
      
	@GetMapping
	public ResponseEntity<List<User>> findAll(){
		User raia= new User("1", "Raia", "railaucas@gmail");
		User maia= new User("3","Maia","Maia@gmail.com");
		List<User> list= new ArrayList<>();
		list.addAll(Arrays.asList(raia,maia));
		return ResponseEntity.ok().body(list);
	}
}
