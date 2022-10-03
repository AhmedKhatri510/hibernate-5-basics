package com.ahmed.hibernate_assignment;

import java.sql.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ahmed.hibernate_assignment.entity.Employee;
import com.ahmed.hibernate_assignment.entity.EmployeeLog;



/**
 * Hello world!
 *
 */
public class DeleteAndSaveEmployee {
	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Employee.class)
				.addAnnotatedClass(EmployeeLog.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {
			int empId = 1;			
			
			// start a transaction
			session.beginTransaction();
			
			//get the emp with id=1
			Employee emp = session.get(Employee.class, empId);
			
			//create the log before deleting the object
			EmployeeLog empLog = new EmployeeLog(emp.getEmp_id(),emp.getName(), emp.getDesignation(), new Date(System.currentTimeMillis()), emp.getEmpBasicpay());
			
			//save the log
			session.save( empLog);
			
			//delete the employee
			session.delete(emp);

			// commit transaction
			session.getTransaction().commit();
		} finally {
			session.close();
			factory.close();
		}
	}
}
