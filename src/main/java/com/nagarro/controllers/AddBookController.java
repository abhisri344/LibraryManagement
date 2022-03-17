package com.nagarro.controllers;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nagarro.models.Book;
import com.nagarro.services.BookApi;

/**
 * AddBookController class is responsible for adding books to the library using
 * addBook functions and Rest Api
 * 
 * @author abhisheksrivastava02
 *
 */
@Controller
public class AddBookController {

	RestTemplate restTemplate = new RestTemplate();

	/**
	 * addBook function is responsible for redirecting to add.jsp page
	 * 
	 * @return
	 */
	@RequestMapping("/addBook")
	public ModelAndView addBook() {
		ModelAndView view = new ModelAndView();
		view.addObject("username", LoginSignUpController.user_name);
		view.setViewName("add.jsp");
		return view;
	}

	/**
	 * addBookDetails function is responsible for taking the details from the form
	 * and passing it to post of RestApi
	 * 
	 * @param request  is used to retrieve incoming HTTP request headers and form
	 *                 data
	 * @param response is used to set the HTTP response headers (e.g., content-type)
	 *                 and the response message body
	 * @return
	 */
	@RequestMapping("/add")
	public ModelAndView addBookDetails(HttpServletRequest request, HttpServletResponse response) {
		BookApi api = new BookApi();
		ModelAndView view = new ModelAndView();

		String name = request.getParameter("bookname");
		String author = request.getParameter("author");

		Book book = new Book(name, author);
		ResponseEntity<Book> b = restTemplate.postForEntity("http://localhost:8090/addBook", book, Book.class);
//		System.out.println(b.getBody());
		ArrayList<Book> books = api.getBooks();
//		System.out.println(books);
		view.addObject("books", books);

		view.addObject("username", LoginSignUpController.user_name);
		view.setViewName("home.jsp");
		return view;
	}

	/**
	 * goback function is responsible for redirecting to home page
	 * 
	 * @return
	 */
	@RequestMapping("/goback")
	public ModelAndView goback() {
		BookApi api = new BookApi();
		ModelAndView view = new ModelAndView();

		ArrayList<Book> books = api.getBooks();
//		System.out.println(books);
		view.addObject("books", books);
		view.addObject("username", LoginSignUpController.user_name);
		view.setViewName("home.jsp");
		return view;
	}
}
