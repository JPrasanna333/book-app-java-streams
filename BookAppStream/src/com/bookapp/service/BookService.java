package com.bookapp.service;

import java.util.List;

import com.bookapp.exception.BookNotFoundException;
import com.bookapp.model.Book;

public interface BookService {
	Book getBookById(int bookid) throws BookNotFoundException;

	List<Book> getBookByAuthor(String author) throws BookNotFoundException;

	List<Book> getBooksByCategory(String catogory) throws BookNotFoundException;

	List<Book> getBooksByTitle(String title) throws BookNotFoundException;

	List<Book> getAllBooks() throws BookNotFoundException;

	List<Book> getBooksByLessPrice(double price) throws BookNotFoundException;

}
