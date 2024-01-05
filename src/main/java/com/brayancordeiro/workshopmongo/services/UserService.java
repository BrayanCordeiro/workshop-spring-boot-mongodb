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
	
	public User findById(String id) {
		
		return repository.findById(id)
				.orElseThrow(() -> new ObjectNotFoundException("Object not found!"));
	}
	
	public User insertUser(User usuario) {
		return repository.insert(usuario);
	}
	
	public User updateUser(User usuario) {
		User novoUsuario = repository.findById(usuario.getId())
				.orElseThrow(() -> new ObjectNotFoundException("Object not found!"));	
		updateData(novoUsuario, usuario);
		
		return repository.save(novoUsuario);
	}
	
	private void updateData(User novoUsuario, User usuario) {
		novoUsuario.setName(usuario.getName());
		novoUsuario.setEmail(usuario.getEmail());	
	}

	public void deleteUser(String id) {
		findById(id);
		repository.deleteById(id);
	}
	
	public User fromDTO(UserDTO usuarioDTO) {
		return new User(usuarioDTO.getId(), usuarioDTO.getName(), usuarioDTO.getEmail());
	}
	

}
