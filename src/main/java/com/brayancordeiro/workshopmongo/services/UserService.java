package com.brayancordeiro.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brayancordeiro.workshopmongo.domain.User;
import com.brayancordeiro.workshopmongo.dto.UserDTO;
import com.brayancordeiro.workshopmongo.repositoty.UserRepository;
import com.brayancordeiro.workshopmongo.services.exceptions.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public List<User> findAll(){
		
		return repository.findAll();
	}
	
	public User findByid(String id) {
		
		return repository.findById(id)
				.orElseThrow(() -> new ObjectNotFoundException("Object not found!"));
	}
	
	public User insertUser(User usuario) {
		return repository.insert(usuario);
	}
	
	public User fromDTO(UserDTO usuarioDTO) {
		return new User(usuarioDTO.getId(), usuarioDTO.getName(), usuarioDTO.getEmail());
	}

}
