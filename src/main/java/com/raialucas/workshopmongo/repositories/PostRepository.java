package com.raialucas.workshopmongo.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.raialucas.workshopmongo.domain.Post;

@Repository
public interface PostRepository  extends MongoRepository<Post, String>{
       List<Post> findByTitleContainingIgnoreCase(String text); 
}
