package com.nagarro.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.models.Book;
import com.nagarro.models.User;
import com.nagarro.services.BookApi;
import com.nagarro.services.LoginSignupService;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * The class LoginSignupController represents a controller which is called when
 * a user registers or login to website. It is having two methods one for login
 * and other for regstration
 * 
 * @author abhisheksrivastava02
 *
 */
@Controller
public class LoginSignUpController {
	public static String user_name;
	final LoginSignupService service = new LoginSignupService();
	final BookApi api = new BookApi();

	/**
	 * Method login is responsible for taking the data entered by user and
	 * validating it against the entries in database and redirecting him to search
	 * page
	 * 
	 * @param request  is used to retrieve incoming HTTP request headers and form
	 *                 data
	 * @param response is used to set the HTTP response headers (e.g., content-type)
	 *                 and the response message body
	 * @return
	 */
	@RequestMapping("/login")
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = new ModelAndView();

		String username = request.getParameter("userName");
		String password = request.getParameter("password");

		if (service.isUser(username, password)) {
			System.out.println("Login Successful");
			request.getSession().setAttribute("authorized", true);
			request.getSession().setAttribute("user", service.getUser(username));
			user_name = username;

			ArrayList<Book> books = api.getBooks();
//			System.out.println(books);
			view.addObject("books", books);

			view.setViewName("home.jsp");
			view.addObject("username", username);

		} else {
			request.setAttribute("message", "Invalid login");
			view.setViewName("index.jsp");
		}
		return view;

	}

	/**
	 * Method register is responsible for taking the data entered by user and adding
	 * it to the database
	 * 
	 * @param requestis used to retrieve incoming HTTP request headers and form data
	 * @param response  is used to set the HTTP response headers (e.g.,
	 *                  content-type) and the response message body
	 * @return
	 */
	@RequestMapping("/register")
	public ModelAndView signup(HttpServletRequest request, HttpServletResponse response) {

		ModelAndView view = new ModelAndView();

		String username = request.getParameter("userName");
		String password = request.getParameter("password");

		boolean ans = service.addUser(username, password);
		if (ans) {
			System.out.println("registered successfully");
			view.setViewName("index.jsp");
		} else {
			System.out.println("not registered successfully");
			view.setViewName("registration.jsp");
		}

		return view;

	}

	@RequestMapping("/logout")
	public void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
		service.logout(request, response);
	}
}
