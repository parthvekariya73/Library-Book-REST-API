package com.springboot.restapi.book.service;

import java.util.List;
//import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.restapi.book.dao.BookRepository;
import com.springboot.restapi.book.entities.Book;

@Service
public class BookService_usingDB {
// Database Service :-
	@Autowired
	private BookRepository bookRepository;
	
	// 1. get all Books :-
	public List<Book> getAllBooks() {
		List<Book> list = (List<Book>)this.bookRepository.findAll();
		return list;
	}
	
	// 2. get single Book by Id :-
	public Book getBookById(int id) {
		Book book = null;
		try {
			book = this.bookRepository.findById(id);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return book;
	}
	
	// 3. adding the book :-
	public Book addBook(Book b) {
		Book result = this.bookRepository.save(b);
		return result;
	}
	
	// 4. deleting the book :-
	public void deleteBook(int bookId) {
		this.bookRepository.deleteById(bookId);
	}
	
	// 5. updating Book :-
	public void updateBook(Book book, int BookId) {
		book.setId(BookId);
		this.bookRepository.save(book);	// save or update
	}
	
	
}
