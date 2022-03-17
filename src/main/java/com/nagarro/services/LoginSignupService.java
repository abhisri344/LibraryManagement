package com.nagarro.services;

import java.io.IOException;
import java.net.http.HttpResponse;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nagarro.hibernate.Hibernate;
import com.nagarro.models.User;

/**
 * LoginSignupService class is responsible for creating of account of new users
 * and providing a login and logout functionality to already existing users
 * 
 * @author abhisheksrivastava02
 *
 */
public class LoginSignupService {

	public static Session session = Hibernate.getSession();

	/**
	 * isUser function checks if the user is valid or not by checking it in the
	 * database
	 * 
	 * @param userName - stores the username of the user
	 *
	 * @param password - stores the password of the user
	 * @return true if the user is verified and false otherwise
	 */
	public boolean isUser(String userName, String password) {
		try {

			Transaction transaction = session.beginTransaction();
			User user = session.get(User.class, userName);
			transaction.commit();
			if (user.getUsername() != null && user.getPassword().equals(password)) {
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	/**
	 * getUser function is responsible for getting details of the user whose
	 * username is passed to it
	 * 
	 * @param username - stores the username of the user
	 * @return user object of User type
	 */
	public User getUser(String username) {
		User user = null;
		try {
			user = session.get(User.class, username);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return user;
	}

	/**
	 * addUser function is responsible for creating account of a user and adding his
	 * details to the database
	 * 
	 * @param userName - stores the username of the user
	 *
	 * @param password - stores the password of the user
	 * @return true if the account creation is successful and false otherwise
	 */
	public boolean addUser(String username, String password) {
		User user = null;
		try {
			Transaction transaction = session.beginTransaction();
			user = new User(username, password);

			session.save(user);
			transaction.commit();
		} catch (Exception e) {
			System.out.println(e);
		}
		if (user == null)
			return false;
		else
			return true;
	}

	/**
	 * logout function is responsible for signing out of user
	 * 
	 * @param request  - it is used to get current session
	 * 
	 * @param response - used for redirecting to login page
	 * @throws IOException
	 */
	public void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		session.removeAttribute("username");
		session.invalidate();
		response.sendRedirect("index.jsp");
	}
}
