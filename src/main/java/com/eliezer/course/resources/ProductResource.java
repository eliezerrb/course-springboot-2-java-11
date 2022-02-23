package com.eliezer.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eliezer.course.entities.Product;
import com.eliezer.course.services.ProductService;

@RestController
@RequestMapping(value = "/products")

public class ProductResource {
	
	@Autowired
	private ProductService service;

	
	@GetMapping //anotação indica que o metodo responde a requisição do tipo get do HTTP
	//tipo ResponseEntity retornar respostas de requisições web
	public ResponseEntity<List<Product>> findAll(){
		List<Product> list = service.findAll();
		//retornando resposta com sucesso(ok) e corpo da resposta(body) 
		return ResponseEntity.ok().body(list);
		
	}
	
	//requisição vai aceitar um id dentro da URL
	@GetMapping(value = "/{id}")
	public ResponseEntity<Product> findById(@PathVariable /*Spring aceitar o id na URL*/   Long id){
		Product obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	

}
