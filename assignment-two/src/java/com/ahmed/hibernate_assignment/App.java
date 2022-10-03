package com.ahmed.hibernate_assignment;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ahmed.hibernate_assignment.entity.Product;



/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Product.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {
			// create a employee object
			System.out.println("creating a new student object..");

			Product p1 = new Product("Samsung phone", 30000);
			Product p2 = new Product("LG Washing Machine", 40000);
			Product p3 = new Product("Philips light", 300);
			Product p4 = new Product("Woodland slipper", 1000);
			Product p5 = new Product("Titan watch", 20000);
			Product p6 = new Product("Nike shoe", 3000);
			Product p7 = new Product("Puma Tshirt", 2000);
			Product p8 = new Product("Pepe Jeans", 1000);
			Product p9 = new Product("Eye Glasses", 1000);
			Product p10 = new Product("Godrej Refrigerator", 50000);
			// start a transaction
			session.beginTransaction();

			// save the student object
			System.out.println("saving the products...");
			session.save(p1);
			session.save(p2);
			session.save(p3);
			session.save(p4);
			session.save(p5);
			session.save(p6);
			session.save(p7);
			session.save(p8);
			session.save(p9);
			session.save(p10);
			// commit transaction
			session.getTransaction().commit();
		} finally {
			factory.close();
		}
	}
}
