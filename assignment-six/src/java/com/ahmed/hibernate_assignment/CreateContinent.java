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
public class CreateContinent {
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
			
			Continent c1 = new Continent("Asia");
			Country country1 = new Country("India");
			country1.addCapital(new Capital("Delhi"));
			country1.addCapital(new Capital("Mumbai"));
			
			c1.addCountry(country1);
			
			Country country2 = new Country("Pakistan");
			country2.addCapital(new Capital("Karachi"));
			country2.addCapital(new Capital("Lahor"));
			
			c1.addCountry(country2);
			
			session.save(country1);
			session.save(country2);
			// commit transaction
			session.getTransaction().commit();
		} finally {
			session.close();
			factory.close();
		}
	}
}
