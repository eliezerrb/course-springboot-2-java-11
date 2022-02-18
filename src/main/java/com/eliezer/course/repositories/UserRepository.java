package com.eliezer.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eliezer.course.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
