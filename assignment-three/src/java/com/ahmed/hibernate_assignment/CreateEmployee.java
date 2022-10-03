package com.ahmed.hibernate_assignment;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ahmed.hibernate_assignment.entity.Employee;



/**
 * Hello world!
 *
 */
public class CreateEmployee {
	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {
			// create a employee object
			Employee e1 = new Employee("Ahmed", "TRB-3");
			Employee e2 = new Employee("Raza", "TRB-1");
			
			// start a transaction
			session.beginTransaction();

			// save the student object
			session.save(e1);
			session.save(e2);
			// commit transaction
			session.getTransaction().commit();
		} finally {
			session.close();
			factory.close();
		}
	}
}
