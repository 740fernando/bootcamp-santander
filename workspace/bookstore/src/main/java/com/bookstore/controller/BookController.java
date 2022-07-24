package com.bookstore.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.model.Book;
import com.bookstore.service.BookService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/book")
public class BookController {
	
	private final BookService bookService;

	public BookController(BookService bookService) {
		super();
		this.bookService = bookService;
	}
	
	@GetMapping(produces= "application/json")
	public ResponseEntity<List<Book>>findAll(){
		return new ResponseEntity<>(bookService.getBookList(), HttpStatus.OK);
	}
	
	@GetMapping(value="/{id}",produces= "application/json")
	public ResponseEntity<Book>findById(@PathVariable("id")Long id){
		return new ResponseEntity<>(bookService.getBookId(id), HttpStatus.OK);
	}
	
	@PostMapping(value="/createBook",produces= "application/json")
	public ResponseEntity<Book>createBook(Book book){
		return new ResponseEntity<>(bookService.createBook(book), HttpStatus.CREATED);
	}
	
	@PostMapping(value="/updateBook/{id}",produces= "application/json")
	public ResponseEntity<Book>updateBook(@PathVariable("id")Long id,Book book){
		return new ResponseEntity<>(bookService.updateBook(id, book), HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping(value="/deletBook/{id}",produces= "application/json")
	public ResponseEntity<?>updateBook(@PathVariable("id")Long id){
		bookService.deleteBook(id);
		return ResponseEntity.ok().build();
	}
}
