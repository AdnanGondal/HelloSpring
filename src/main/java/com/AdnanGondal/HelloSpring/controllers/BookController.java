package com.AdnanGondal.HelloSpring.controllers;

import com.AdnanGondal.HelloSpring.models.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import com.AdnanGondal.HelloSpring.repositories.BookRepository;

import java.util.Set;

@Controller
public class BookController {
	
	private final BookRepository bookRepository;
	
	
	public BookController(BookRepository bookRepository) {
		super();
		this.bookRepository = bookRepository;
	}


	@RequestMapping("/books")
	public String getBooks(Model model) {

		model.addAttribute("books",bookRepository.findAll());
		
		return "books/list";
	}



}
