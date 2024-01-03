package com.brayancordeiro.workshopmongo.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.brayancordeiro.workshopmongo.domain.User;

@RestController
@RequestMapping(value="/users")
public class UserResource {
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<User>> findAll(){
		
		User maria = new User("1", "Maria Luisa", "ml01@gmail.com");
		User danilo = new User("2", "Danilo Moura", "dm02@gmail.com");
		List<User> usuarios = new ArrayList<>();
		usuarios.addAll(Arrays.asList(maria, danilo));
		return ResponseEntity.ok().body(usuarios);
		
	}
	
}
