package com.nagarro.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * User is a model class used for storing Username and passwords of different
 * users in the database
 * 
 * @author abhisheksrivastava02
 *
 */
@Entity
@Table(name = "userDetailsTable")
public class User {
	@Id
	@Column(name = "username")
	private String username;
	@Column(name = "userpassword")
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + "]";
	}

	public User() {
		// TODO Auto-generated constructor stub
	}

}
