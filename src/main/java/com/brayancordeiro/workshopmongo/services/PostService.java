package com.brayancordeiro.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brayancordeiro.workshopmongo.domain.Post;
import com.brayancordeiro.workshopmongo.repositoty.PostRepository;
import com.brayancordeiro.workshopmongo.services.exceptions.ObjectNotFoundException;

@Service
public class PostService {
	
	@Autowired
	private PostRepository repository;
	
	public Post findById(String id) {
		
		return repository.findById(id)
				.orElseThrow(() -> new ObjectNotFoundException("Object not found!"));
	}
	
	public List<Post> findByTitle(String text){
		
		return repository.findByTitle(text);
	}
	
}
