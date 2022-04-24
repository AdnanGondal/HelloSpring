package com.AdnanGondal.HelloSpring.controllers;

import com.AdnanGondal.HelloSpring.models.Book;
import com.AdnanGondal.HelloSpring.repositories.BookRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiController {

	private final BookRepository bookRepository;

	public ApiController(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	@GetMapping("/")
	public String index() {
		return "Greetings from Spring Boot!";
	}

	@RequestMapping("/books")
	public Iterable<Book> getBooksApi(){
		return  bookRepository.findAll();
	}


}
