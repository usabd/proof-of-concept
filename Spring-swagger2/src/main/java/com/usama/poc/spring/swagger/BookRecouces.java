package com.usama.poc.spring.swagger;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class BookRecouces {

	ConcurrentMap<String, Book> booksMap = new ConcurrentHashMap<String, Book>();
	
	@PostMapping("/")
	public Book addBook(@RequestBody Book book) {
		
		 booksMap.put(book.getTitle(),book);
		return book;
	}
	@GetMapping("/")
	public List<Book> getAllBooks(){
		return new ArrayList<Book>(booksMap.values());
	}
	@GetMapping("/{bookId}")
	public Book getBook(@PathVariable String bookId) {
		return booksMap.get(bookId);
	}
	
	@DeleteMapping("/")
	public void removeBook(@RequestBody Book book) {
		booksMap.remove(book.getTitle());
	}
}
