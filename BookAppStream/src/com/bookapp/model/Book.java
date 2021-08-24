package com.bookapp.model;

public class Book {
	private String title;
	private String author, category;
	private double price;
	private Integer bookId;

	public Book() {
		super();

	}

	public Book(String title, String author, String category, double price, Integer bookid) {
		super();
		this.title = title;
		this.author = author;
		this.category = category;
		this.price = price;
		this.bookId = bookid;
	}

	@Override
	public String toString() {
		return "Book [title=" + title + ", author=" + author + ", category=" + category + ", price=" + price
				+ ", bookid=" + bookId + "]";
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getCategory() {
		return category;
	}

	public void setCatogory(String category) {
		this.category = category;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Integer getBookid() {
		return bookId;
	}

	public void setBookid(Integer bookid) {
		this.bookId = bookid;
	}

}
