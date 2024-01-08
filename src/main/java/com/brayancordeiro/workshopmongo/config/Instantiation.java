package com.brayancordeiro.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.brayancordeiro.workshopmongo.domain.Post;
import com.brayancordeiro.workshopmongo.domain.User;
import com.brayancordeiro.workshopmongo.repositoty.PostRepository;
import com.brayancordeiro.workshopmongo.repositoty.UserRepository;


@Configuration
public class Instantiation implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;

	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User maria = new User(null, "Maria Luisa", "ml01@gmail.com");
		User danilo = new User(null, "Danilo Souza", "ds02@outlook.com");
		User douglas = new User(null, "Douglas Marinho", "dm03@gmail.com");
		
		Post post1 = new Post(null, sdf.parse("02/11/2023"), "Indo ali", "Viajando pra São Paulo essa semana", maria);
		Post post2 = new Post(null, sdf.parse("16/12/2023"), "Bom dia", "Acordei feliz hoje!", maria);
		
		userRepository.saveAll(Arrays.asList(maria, danilo, douglas));
		postRepository.saveAll(Arrays.asList(post1, post2));
		
	}

}
