package com.brayancordeiro.workshopmongo.repositoty;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.brayancordeiro.workshopmongo.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String>{

	//Nesse ponto o springdata monta a consulta
	List<Post> findByTitleContainingIgnoreCase(String text);
	
}
