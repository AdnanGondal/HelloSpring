package com.AdnanGondal.HelloSpring.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.AdnanGondal.HelloSpring.models.Author;
import com.AdnanGondal.HelloSpring.models.Book;
import com.AdnanGondal.HelloSpring.models.Publisher;
import com.AdnanGondal.HelloSpring.repositories.AuthorRepository;
import com.AdnanGondal.HelloSpring.repositories.BookRepository;
import com.AdnanGondal.HelloSpring.repositories.PublisherRepository;

// tell spring it is a spring managed component
@Component
public class BootstrapData implements CommandLineRunner {

	
	private final AuthorRepository authorRepository;
	private final BookRepository bookRepository;
	private final PublisherRepository publisherRepository;
	
	
	// DO DI for Author and Book Repo instances
	
	public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository,
			PublisherRepository publisherRepository) {
		super();
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}



	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Publisher publisher = new Publisher("SFG","London SW11");
		publisherRepository.save(publisher);
	
		
		Author eric = new Author("Eric","Evans");
		Book ddd = new Book("Domain Driver Design", "1212121");
		eric.getBooks().add(ddd);
		ddd.getAuthors().add(eric);
		
		ddd.setPublisher(publisher);
		publisher.getBooks().add(ddd);
		
		
		
		
		authorRepository.save(eric);
		bookRepository.save(ddd);
		publisherRepository.save(publisher);
		
		Author rod = new Author("Rod","Johnson");
		Book noEJB = new Book("J2EE Development","289232");
		rod.getBooks().add(noEJB);
		noEJB.getAuthors().add(rod);
		noEJB.setPublisher(publisher);
		publisher.getBooks().add(noEJB);
		
		authorRepository.save(rod);
		bookRepository.save(noEJB);
		publisherRepository.save(publisher);
		
		// repository method used to save them
		// Under the hood, Hibernate uses an in memory H2 database
		
		System.out.println("Started in Bootstreap");
		System.out.println("Number of Books: "+bookRepository.count());
		
		
	}


	
	

}
