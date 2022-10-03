package com.ahmed.hibernate_assignment;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ahmed.hibernate_assignment.entity.Capital;
import com.ahmed.hibernate_assignment.entity.Continent;
import com.ahmed.hibernate_assignment.entity.Country;



/**
 * Hello world!
 *
 */
public class DeleteContinent {
	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Continent.class)
				.addAnnotatedClass(Capital.class)
				.addAnnotatedClass(Country.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			// start a transaction
			session.beginTransaction();
			
			List<Country> albums = session.createQuery("from Country ").getResultList();
			for(Country a: albums) {
				session.delete(a);			
			}
			// commit transaction
			session.getTransaction().commit();
		} finally {
			session.close();
			factory.close();
		}
	}
}
