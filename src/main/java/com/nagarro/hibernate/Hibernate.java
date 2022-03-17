package com.nagarro.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hibernate class is responsible for creating session and providing it to the
 * requesting function
 * 
 * @author abhisheksrivastava02
 *
 */
public class Hibernate {
	static SessionFactory factory;
	static Session session;

	public static Session createConnection() {
		factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		session = factory.openSession();
		return session;

	}

	public static Session getSession() {
		if (session == null)
			createConnection();
		return session;
	}
}
