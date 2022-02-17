package com.eliezer.course.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eliezer.course.entities.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	//tipo ResponseEntity retornar respostas de requisições web
	
	@GetMapping //anotação indica que o metodo responde a requisição do tipo get do HTTP
	public ResponseEntity<User> findAll(){
		User u = new User(1L, "Maria", "maria@gmail.com", "999999", "123");
		
		//retornando resposta com sucesso(ok) e corpo da resposta(body) 
		return ResponseEntity.ok().body(u);
		
	}

}
