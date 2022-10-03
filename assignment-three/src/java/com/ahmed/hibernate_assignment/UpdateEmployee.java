package com.ahmed.hibernate_assignment;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ahmed.hibernate_assignment.entity.Employee;



/**
 * Hello world!
 *
 */
public class UpdateEmployee {
	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {
			int empId = 1;
			
			// start a transaction
			session.beginTransaction();
			Employee emp = session.get(Employee.class, empId);
			
			System.out.println("\n\n\nEmployee with id: "+empId+" -> "+emp);
			emp.setEmpBand("TRB-1");
			// commit transaction
			session.getTransaction().commit();
		} finally {
			session.close();
			factory.close();
		}
	}
}
