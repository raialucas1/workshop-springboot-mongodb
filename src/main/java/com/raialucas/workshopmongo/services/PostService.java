package com.raialucas.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raialucas.workshopmongo.domain.Post;
import com.raialucas.workshopmongo.repositories.PostRepository;
import com.raialucas.workshopmongo.services.exceptions.ObjectNotFoundException;

@Service
public class PostService {

	
	@Autowired
	private PostRepository repository;
	
	public Post findById(String id) {
		Optional<Post> post=repository.findById(id);
		if(post.isEmpty()) {
			throw new ObjectNotFoundException("Post não encontrado");
		}
		
		return post.get();
	}
	
	public List<Post> findByTitle(String text){
		return repository.searchTitle(text);
	}
}
