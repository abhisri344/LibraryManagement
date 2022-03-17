package com.nagarro.models;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Model class for interacting with API in order to send and retrieve data from
 * it
 * 
 * @author abhisheksrivastava02
 *
 */
public class Book {
	private int id;
	private String name;
	private String author;
	private String dateAdded;

	public Book() {
		super();
	}

	public Book(String name, String author) {
		super();
		this.name = name;
		this.author = author;
		setDateAdded();
		this.dateAdded = getDateAdded();
	}

	public Book(int id, String name, String author) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
		setDateAdded();
		this.dateAdded = getDateAdded();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getDateAdded() {
		return dateAdded;
	}

	public void setDateAdded() {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();

		this.dateAdded = formatter.format(date);

	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", author=" + author + ", dateAdded=" + dateAdded + "]";
	}

}
