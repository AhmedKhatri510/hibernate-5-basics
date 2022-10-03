package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;

public class CreateCourseDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class)
				.addAnnotatedClass(Student.class).buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			session.beginTransaction();

			int id = 1;
			Instructor tempIns = session.get(Instructor.class, id);

			Course c1 = new Course("The Air guiter - complete guide");
			Course c2 = new Course("Pinball Masterclass");

			tempIns.add(c1);
			tempIns.add(c2);

			session.save(c1);
			session.save(c2);

			// commit transaction
			session.getTransaction().commit();
		} finally {
			factory.close();
		}
	}

}
