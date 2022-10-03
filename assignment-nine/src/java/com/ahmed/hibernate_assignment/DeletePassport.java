package com.ahmed.hibernate_assignment;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import com.ahmed.hibernate_assignment.entity.Passport;
import com.ahmed.hibernate_assignment.entity.Employee;



/**
 * Hello world!
 *
 */
public class DeletePassport {
	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Passport.class)
				.addAnnotatedClass(Employee.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			// start a transaction
			session.beginTransaction();
			
			int id = 1;
			
			Passport p1 = session.get(Passport.class, id);
			
			session.delete(p1);
			
			// commit transaction
			session.getTransaction().commit();
		} finally {
			session.close();
			factory.close();
		}
	}
}
