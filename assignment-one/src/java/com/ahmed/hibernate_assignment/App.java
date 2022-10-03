package com.ahmed.hibernate_assignment;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ahmed.hibernate_assignment.entity.Employee;



/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {
			// create a employee object
			System.out.println("creating a new student object..");

			Employee tempEmployee1 = new Employee("Raza", "Software Developer", 30000);
			Employee tempEmployee2 = new Employee("Khatri", "DB Developer", 40000);
			Employee tempEmployee3 = new Employee("Ahmed", "Software Developer", 30000);
			Employee tempEmployee4 = new Employee("whatever", "Java Developer", 40000);
			Employee tempEmployee5 = new Employee("something", "React Developer", 30000);
			// start a transaction
			session.beginTransaction();

			// save the student object
			System.out.println("saving the employee...");
			session.save(tempEmployee1);
			session.save(tempEmployee2);
			session.save(tempEmployee3);
			session.save(tempEmployee4);
			session.save(tempEmployee5);
			// commit transaction
			session.getTransaction().commit();
		} finally {
			factory.close();
		}
	}
}
