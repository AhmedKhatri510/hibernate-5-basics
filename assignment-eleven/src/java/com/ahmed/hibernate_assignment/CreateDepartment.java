package com.ahmed.hibernate_assignment;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import com.ahmed.hibernate_assignment.entity.Department;
import com.ahmed.hibernate_assignment.entity.Employee;



/**
 * Hello world!
 *
 */
public class CreateDepartment {
	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Department.class)
				.addAnnotatedClass(Employee.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			// start a transaction
			session.beginTransaction();
			
			Department d1 = new Department("Computer Science");
			List<Employee> employees = new ArrayList<Employee>();
			employees.add(new Employee("Ahmed"));
			employees.add(new Employee("Raza"));
			d1.setEmployees(employees);
			
			session.save(d1);
			
			// commit transaction
			session.getTransaction().commit();
		} finally {
			session.close();
			factory.close();
		}
	}
}
