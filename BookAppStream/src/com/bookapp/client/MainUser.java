package com.bookapp.client;

import java.util.Scanner;

import com.bookapp.exception.BookNotFoundException;
import com.bookapp.model.Book;
import com.bookapp.service.BookService;
import com.bookapp.service.BookServiceImpl;

public class MainUser {

	public static void main(String[] args) {
		BookService service = new BookServiceImpl();

		Scanner kb = new Scanner(System.in);

		while (true) {

			System.out.println(
					"\nPlease enter your choice\n\n1.To get all the Book\n2.To get the book by the id\n3.To get book by the author\n4.To get book by the title\n5.To get book by the category\n6.To get book the price\n7.To exit");
			int choice = kb.nextInt();
			switch (choice) {
			case 1:
				try {
					for (Book allBook : service.getAllBooks()) {
						System.out.println(allBook);
					}

				} catch (BookNotFoundException e) {

					System.out.println(e.getMessage());
				}
				break;
			case 2:
				System.out.println("\nPlease enter the ID of the book you want to find");
				int id = kb.nextInt();
				try {
					System.out.println(service.getBookById(id));
				} catch (BookNotFoundException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 3:
				System.out.println("\nPlease enter the author name of the book you want to find");
				String author = kb.next();
				try {
					for (Book bookAuthor : service.getBookByAuthor(author)) {
						System.out.println(bookAuthor);
					}
				} catch (BookNotFoundException e) {

					System.out.println(e.getMessage());
				}
				break;
			case 4:
				System.out.println("\nPlease enter the title name of the book you want to find");
				String title = kb.next();
				try {
					for (Book bookTitle : service.getBooksByTitle(title)) {
						System.out.println(bookTitle);
					}

				} catch (BookNotFoundException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 5:
				System.out.println("\nPlease enter category of the book you want to find");
				String category = kb.next();
				try {
					for (Book bookCategory : service.getBooksByCategory(category)) {
						System.out.println(bookCategory);
					}
				} catch (BookNotFoundException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 6:
				System.out.println("\nPlease enter price of the book you want to find");
				double price = kb.nextDouble();
				try {
					for (Book bookPrice : service.getBooksByLessPrice(price)) {
						System.out.println(bookPrice);
					}

				} catch (BookNotFoundException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 7:
				System.out.println("exiting...");
				kb.close();
				System.exit(0);
				break;
			default:
				System.out.println("Invalid choice");

			}

		}

	}

}
