package com.eliezer.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eliezer.course.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
