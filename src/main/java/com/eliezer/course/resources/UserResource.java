package com.eliezer.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eliezer.course.entities.User;
import com.eliezer.course.services.UserService;

@RestController
@RequestMapping(value = "/users")

public class UserResource {
	
	@Autowired
	private UserService service;

	
	@GetMapping //anotação indica que o metodo responde a requisição do tipo get do HTTP
	//tipo ResponseEntity retornar respostas de requisições web
	public ResponseEntity<List<User>> findAll(){
		List<User> list = service.findAll();
		//retornando resposta com sucesso(ok) e corpo da resposta(body) 
		return ResponseEntity.ok().body(list);
		
	}
	
	//requisição vai aceitar um id dentro da URL
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable /*Spring aceitar o id na URL*/   Long id){
		User obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	

}
