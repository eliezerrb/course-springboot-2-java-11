package com.eliezer.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eliezer.course.entities.Order;
import com.eliezer.course.repositories.OrderRepository;


@Service //registrando como um componente para o autowired funcionar
public class OrderService {

	@Autowired
	private OrderRepository repository;
	
	public List<Order> findAll(){
		return repository.findAll();
	}

	public Order findById(Long id) {
		//Optional é o tipo do retorno do rerepository.findById(id);
		Optional<Order> obj = repository.findById(id);
		return obj.get();
	}
	
}
