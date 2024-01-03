package com.brayancordeiro.workshopmongo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.brayancordeiro.workshopmongo.domain.User;
import com.brayancordeiro.workshopmongo.repositoty.UserRepository;


@Configuration
public class Instantiation implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		
		userRepository.deleteAll();
		
		User maria = new User(null, "Maria Luisa", "ml01@gmail.com");
		User danilo = new User(null, "Danilo Souza", "ds02@outlook.com");
		User douglas = new User(null, "Douglas Marinho", "dm03@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maria, danilo, douglas));
		
	}

}
