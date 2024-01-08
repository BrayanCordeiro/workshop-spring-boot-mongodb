package com.brayancordeiro.workshopmongo.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.brayancordeiro.workshopmongo.domain.Post;
import com.brayancordeiro.workshopmongo.domain.User;
import com.brayancordeiro.workshopmongo.dto.UserDTO;
import com.brayancordeiro.workshopmongo.services.UserService;

@RestController
@RequestMapping(value="/users")
public class UserResource {
	
	@Autowired
	private UserService service;
	
	@GetMapping
	public ResponseEntity<List<UserDTO>> findAll(){
		
		List<User> usuarios = service.findAll();
		List<UserDTO> usuariosDTO = usuarios.stream()
				.map(x -> new UserDTO(x)).collect(Collectors.toList());
		
		return ResponseEntity.ok().body(usuariosDTO);		
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<UserDTO> findById(@PathVariable String id){
		User usuario = service.findById(id);
		
		return ResponseEntity.ok().body(new UserDTO(usuario));
	}
	
	@PostMapping
	public ResponseEntity<Void> insertUser(@RequestBody UserDTO usuarioDTO){
		User usuario = service.fromDTO(usuarioDTO);
		usuario = service.insertUser(usuario);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(usuario.getId()).toUri();
		
		return ResponseEntity.created(uri).build();	
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<Void> updateUser(@RequestBody UserDTO usuarioDTO, @PathVariable String id){
		User usuario = service.fromDTO(usuarioDTO);
		usuario.setId(id);
		usuario = service.updateUser(usuario);

		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable String id){
		
		service.deleteUser(id);
		
		return ResponseEntity.noContent().build();	
	}
	
	@GetMapping(value="/{id}/posts")
	public ResponseEntity<List<Post>> findPosts(@PathVariable String id){
		User usuario = service.findById(id);
		
		return ResponseEntity.ok().body(usuario.getPosts());
	}
	
}
