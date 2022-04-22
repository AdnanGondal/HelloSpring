package com.AdnanGondal.HelloSpring.repositories;

import org.springframework.data.repository.CrudRepository;

import com.AdnanGondal.HelloSpring.models.Book;

public interface BookRepository extends CrudRepository<Book,Long> {
	
	

}
