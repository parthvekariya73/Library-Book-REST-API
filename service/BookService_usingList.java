//package com.springboot.restapi.book.service;
//
//import java.util.ArrayList;
//import java.util.List;
////import java.util.stream.Collectors;
//
//import org.springframework.stereotype.Service;
//
//import com.springboot.restapi.book.entities.Book;
//
//@Service
//public class BookService_usingList {
//// Fake Service :-
//	private static List<Book> list = new ArrayList<>();
//
//	static {
//		list.add(new Book(1,"Introduction of Java","XYZ"));
//		list.add(new Book(2,"Cyber Security laws","ABC"));
//		list.add(new Book(3,"Overview of Basic Maths","POR"));
//	}
//	
//	
//	
//	// 1. get all Books :-
//	public List<Book> getAllBooks() {
//		return list;
//	}
//	
//	
//	// 2. get single Book by Id :-
//	public Book getBookById(int id) {
//		Book book = null;
//		try {
//			// 1) using stream :-
//				book = list.stream().filter(b->b.getId()==id).findFirst().get();
//			// 2) using for each loop :-
//				/*for(Book b : list) {
//					if(b.getId() == id) {
//						book = new Book(b.getId(), b.getTitle(), b.getAuthor());
//						break;
//					}
//				}*/
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//		return book;
//	}
//	
//	
//	// 3. adding the book :-
//	public Book addBook(Book b) {
//		list.add(b);
//		return b;
//	}
//	
//	
//	// 4. deleting the book :-
//	public void deleteBook(int bookId) {
//		// 1) using stream :-
////			list = list.stream().filter(book->book.getId()!=bookId)
////					.collect(Collectors.toList());
//		// 2) using for each loop :-
//		int i = 0;
//		for(Book b : list) {
//			if(b.getId() == bookId) {
//				list.remove(i);
//				break;
//			}
//			++i;
//		} 
//	}
//	
//	
//	// 5. updating Book :-
//	public void updateBook(Book book, int BookId) {
//		// 1) using stream :-
//		/*list = list.stream().map(b->{
//			if(b.getId() == BookId) {
//				b.setTitle(book.getTitle());
//				b.setAuthor(book.getAuthor());
//			}
//			return b;
//		}).collect(Collectors.toList());*/
//		// 2) using for each :-
//		for(Book b : list) { 
//			if(b.getId() == BookId) {
//				b.setTitle(book.getTitle());
//				b.setAuthor(book.getAuthor());
//				list.remove(b);
//			}
//		}
//	}
//}