package com.springboot.restapi.book.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.restapi.book.entities.Book;
import com.springboot.restapi.book.service.BookService_usingDB;
//import com.springboot.restapi.book.service.BookService_usingList;

@RestController
public class BookController {

// 1) using Fake Service :-	import com.springboot.restapi.book.service.BookService_usingList;
	// @Autowired
	// private BookService_usingList bookService;
	
// 2) using Database Service :-
	@Autowired
	private BookService_usingDB bookService;
	
	
	
	
	

// 1. get all Books Handler
	//	@GetMapping("/books")
	//	public List<Book> getBooks() {
	//		return this.bookService.getAllBooks();
	//	}

	@GetMapping("/books")	// with status code
	public ResponseEntity<List<Book>> getBooks_Status() {
		List<Book> list = this.bookService.getAllBooks(); 
		if(list.size() <= 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		System.out.println(list);
		return ResponseEntity.of(Optional.of(list));
	}
	
	
	
// 2. get single Book by Id :-
	//	@GetMapping("/books/{id}")
	//	public Book getBook(@PathVariable("id") int id) {
	//		return this.bookService.getBookById(id);
	//	}

	@GetMapping("/books/{id}")	// with status code
	public ResponseEntity<Book> getBook(@PathVariable("id") int id) {
		Book book = this.bookService.getBookById(id);
		if(book == null) {
			System.out.println("Not Found any Book...");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		System.out.println(book);
		return ResponseEntity.of(Optional.of(book));
	}
	
	
	
// 3. add Book Handler :-
	//	@PostMapping("/books")
	//	public Book addingBook(@RequestBody Book book) {
	//		Book b = this.bookService.addBook(book);
	//		System.out.println(b);
	//		return b; 
	//	}
	
	@PostMapping("/books")	// with status code
	public ResponseEntity<Book> addingBook(@RequestBody Book book) {
		Book b = null;
		try {
			b = this.bookService.addBook(book);
			System.out.println("Add Book Successfully :- "+ b);
			return ResponseEntity.ok().body(b);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); 
		}
	}
	

	
// 4. Delete Book Handler :-
	//	@DeleteMapping("/books/{id}")
	//	public void deletingBook(@PathVariable("id") int bookId) {
	//		this.bookService.deleteBook(bookId);
	//		System.out.println("Delete Book Number "+ bookId);
	//	}

	@DeleteMapping("/books/{id}")	// with status code
	public ResponseEntity<Void> deletingBook(@PathVariable("id") int bookId) {
		try {
			this.bookService.deleteBook(bookId);
			System.out.println("Delete Book Number "+ bookId);
			// The server successfully processed the request, but is not returning any content.
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		} 
	}
	
	
	
// 5. Update Book Handler :-
	//	@PutMapping("/books/{id}")
	//	public Book updatingBook(@RequestBody Book book, @PathVariable("id") int bookId) {
	//		this.bookService.updateBook(book, bookId);
	//		System.out.println(book);
	//		return b;
	//	}
	
	@PutMapping("/books/{id}")	// with status code
	public ResponseEntity<Book> updatingBook(@RequestBody Book book, @PathVariable("id") int bookId) {
		try {
			this.bookService.updateBook(book, bookId);
			System.out.println("Update Book :- " + book);
			return ResponseEntity.ok().body(book);	
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

}	 
 



/*
	---> OUTPUT in JSON Format (PostMan):-

	1. get all Books Handler :-
	[
		{
	        "id": 1,
	        "title": "Introduction of Java",
	        "author": "XYZ"
	    },
	    {
	        "id": 2,
	        "title": "Cyber Security laws",
	        "author": "ABC"
	    },
	    {
	        "id": 3,
	        "title": "Overview of Basic Maths",
	        "author": "POR"
	    }
	] 
		
	
	2. get single Book by Id :-
	{
	    "id": 1,
	    "title": "Introduction of Java",
	    "author": "XYZ"
	}
	
	
	3. add Book Handler :-
	{
	    "id": 4,
	    "title": "Java Programming",
	    "author": "HTDH"
	} 
	
	
	4. delete Book Handler :-
	Delete Book Number 4
	
	5. update Book Handler :-
	{
        "id": 4,
        "title": "C++ Programming",
        "author": "PQR"
    }


*/