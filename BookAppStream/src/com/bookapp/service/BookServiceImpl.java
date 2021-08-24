package com.bookapp.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.bookapp.exception.BookNotFoundException;
import com.bookapp.model.Book;

public class BookServiceImpl implements BookService {
	@Override
	public Book getBookById(int bookid) throws BookNotFoundException {
		return showBooks().stream().filter((x) -> bookid == x.getBookid()).findAny()
				.orElseThrow(() -> new BookNotFoundException("Invalid id"));
	}

	@Override
	public List<Book> getBookByAuthor(String author) throws BookNotFoundException {
		List<Book> authorList = showBooks().stream().filter((x) -> x.getAuthor().equalsIgnoreCase(author))
				.collect(Collectors.toList());
		if (authorList.isEmpty()) {
			throw new BookNotFoundException("Author not found");
		}
		return authorList;
	}

	@Override
	public List<Book> getBooksByCategory(String catogory) throws BookNotFoundException {
		List<Book> categoryList = showBooks().stream().filter((x) -> x.getCategory().equalsIgnoreCase(catogory))
				.collect(Collectors.toList());
		if (categoryList.isEmpty()) {
			throw new BookNotFoundException("catogory is  not found ");
		}
		return categoryList;

	}

	@Override
	public List<Book> getBooksByTitle(String title) throws BookNotFoundException {
		List<Book> titleList = showBooks().stream().filter((x) -> x.getTitle().equalsIgnoreCase(title))
				.collect(Collectors.toList());
		if (titleList.isEmpty()) {
			throw new BookNotFoundException("Title not found");
		}
		return titleList;
	}

	@Override
	public List<Book> getAllBooks() throws BookNotFoundException {
		return showBooks();
	}

	@Override
	public List<Book> getBooksByLessPrice(double price) throws BookNotFoundException {
		List<Book> bookPrice = showBooks().stream().filter((x) -> price >= x.getPrice()).collect(Collectors.toList());
		if (bookPrice.isEmpty()) {
			throw new BookNotFoundException("Sorry book is not found at the given price range");
		}
		return bookPrice;
	}

	private List<Book> showBooks() {

		return Arrays.asList(new Book("Java", "kathy", "Tech", 1900, 1), new Book("Sam club", "robin", "Self", 900, 2),
				new Book("Captain", "jp", "children", 100, 3), new Book("Mansion", "robin", "self", 700, 4),
				new Book("Leadership", "apj", "novel", 180, 5));

	}

}
