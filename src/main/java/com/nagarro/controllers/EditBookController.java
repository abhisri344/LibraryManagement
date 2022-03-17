package com.nagarro.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.*;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.models.Book;
import com.nagarro.services.BookApi;

/**
 * EditBookController class is responsible for updating the given book
 * 
 * @author abhisheksrivastava02
 *
 */
@Controller
public class EditBookController {

	RestTemplate restTemplate = new RestTemplate();

	/**
	 * editBook function is used to get book details of passed id from api and
	 * redirecting to edit page
	 * 
	 * @param id - the id of the book to be deleted
	 * @return
	 */
	@RequestMapping("/update/{id}")
	public ModelAndView editBook(@PathVariable("id") int id) {
		ModelAndView view = new ModelAndView();

		Map<String, Integer> param = new HashMap<String, Integer>();
		param.put("id", id);

		Book book = restTemplate.getForObject("http://localhost:8090/book/{id}", Book.class, param);
		System.out.println(book);
		view.addObject("username", LoginSignUpController.user_name);
		view.addObject("book", book);
		view.setViewName("../edit.jsp");
		return view;

	}

	/**
	 * updateBook function takes the input from the form and passes it to the API 
	 @param request  is used to retrieve incoming HTTP request headers and form
	 *                 data
	 * @param response is used to set the HTTP response headers (e.g., content-type)
	 *                 and the response message body
	 * @return
	 */
	@RequestMapping("/updateBook")
	public ModelAndView updateBook(HttpServletRequest request, HttpServletResponse response) {

		BookApi api = new BookApi();
		ModelAndView view = new ModelAndView();

		int id = Integer.parseInt(request.getParameter("bookid"));
		String name = request.getParameter("bookname");
		String author = request.getParameter("author");

		Book book = new Book(id, name, author);
		System.out.println(book);

		restTemplate.put("http://localhost:8090/update", book);

		ArrayList<Book> books = api.getBooks();
		System.out.println(books);
		view.addObject("books", books);
		view.addObject("username", LoginSignUpController.user_name);
		view.setViewName("home.jsp");
		return view;
	}
}
