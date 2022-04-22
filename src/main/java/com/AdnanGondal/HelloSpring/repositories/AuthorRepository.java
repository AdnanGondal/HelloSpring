package com.AdnanGondal.HelloSpring.repositories;

import org.springframework.data.repository.CrudRepository;

import com.AdnanGondal.HelloSpring.models.Author;

public interface AuthorRepository extends CrudRepository<Author, Long>{
	
	

}
