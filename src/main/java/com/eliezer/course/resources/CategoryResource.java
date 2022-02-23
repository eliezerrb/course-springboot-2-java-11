package com.eliezer.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eliezer.course.entities.Category;
import com.eliezer.course.services.CategoryService;

@RestController
@RequestMapping(value = "/categories")

public class CategoryResource {
	
	@Autowired
	private CategoryService service;

	
	@GetMapping //anotação indica que o metodo responde a requisição do tipo get do HTTP
	//tipo ResponseEntity retornar respostas de requisições web
	public ResponseEntity<List<Category>> findAll(){
		List<Category> list = service.findAll();
		//retornando resposta com sucesso(ok) e corpo da resposta(body) 
		return ResponseEntity.ok().body(list);
		
	}
	
	//requisição vai aceitar um id dentro da URL
	@GetMapping(value = "/{id}")
	public ResponseEntity<Category> findById(@PathVariable /*Spring aceitar o id na URL*/   Long id){
		Category obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	

}
