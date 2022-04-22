package com.AdnanGondal.HelloSpring;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.AdnanGondal.HelloSpring.models.Greeting;

//annotation identifies controllers
// these handle HTTP requests
// returns domain object instead of a view
@RestController
public class GreetingController {
	
	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
	
	// map requests to greeting end-point, to the greeting method
	// these exist for other methods, e.g. PostMapping
	@GetMapping("/greeting")      // query string
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}

}


//The Greeting object must be converted to JSON. 
//Thanks to Spring’s HTTP message converter support,
//you need not do this conversion manually. 
//Because Jackson 2 is on the classpath, Spring’s MappingJackson2HttpMessageConverter
//is automatically chosen to convert the Greeting instance to JSON.