package com.eliezer.course.resources;

import java.net.URI;
import java.util.List;

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

import com.eliezer.course.entities.User;
import com.eliezer.course.services.UserService;

@RestController
@RequestMapping(value = "/users")

public class UserResource {

	@Autowired
	private UserService service;

	@GetMapping // anotação indica que o metodo responde a requisição do tipo get do HTTP
	// tipo ResponseEntity retornar respostas de requisições web
	public ResponseEntity<List<User>> findAll() {
		List<User> list = service.findAll();
		// retornando resposta com sucesso(ok) e corpo da resposta(body)
		return ResponseEntity.ok().body(list);

	}

	// requisição vai aceitar um id dentro da URL
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable /* Spring aceitar o id na URL como variavel */ Long id) {
		User obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	// definindo um metodo post do HTTP
	@PostMapping
	public ResponseEntity<User> insert(@RequestBody /* Dizendo que o objeto vai chegar como json */ User obj) {
		obj = service.insert(obj);
		
		//gerar endereço do novo recurso inserido
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		
		//retornando o código 201 de criação de um novo recurso
		return ResponseEntity.created(uri).body(obj);
	}
	
	@DeleteMapping(value = "/{id}")
	//void porque a resposta da requisição não retorna corpo
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User obj){
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}

}
