package com.raialucas.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raialucas.workshopmongo.domain.User;
import com.raialucas.workshopmongo.dto.UserDTO;
import com.raialucas.workshopmongo.repositories.UserRepository;
import com.raialucas.workshopmongo.services.exceptions.ObjectNotFoundException;

@Service
public class UserService {
      
	@Autowired
	private UserRepository repo;
	
	public List<User> findAll(){
		return repo.findAll();
	}
	
	public User findById(String id) {
		Optional<User> user=repo.findById(id);
		if(user.isEmpty()) {
			throw new ObjectNotFoundException("Objeto não encontrado!");
		}	
		return user.get();	
	}
	
	public User insert(User user) {
		return repo.insert(user);
	}
	
	public User fromDTO(UserDTO userdto) {
		return new User(userdto.getId(), userdto.getName(),userdto.getEmail());
	}
}
