package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
import com.luv2code.hibernate.demo.entity.Student;

public class CreateCourseAndStudentsDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Student.class)
				.addAnnotatedClass(Review.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			session.beginTransaction();

			Course tempCourse = new Course("The pacman course");

			System.out.println("course: " + tempCourse);
			session.save(tempCourse);

			Student s1 = new Student("Ahmed", "Raza", "whatever@gmail.com");

			Student s2 = new Student("Khatri", "Raza", "something@gmail.com");

			tempCourse.addStudent(s1);
			tempCourse.addStudent(s2);

			session.save(s1);
			session.save(s2);
			System.out.println("students: " + tempCourse.getStudents());

			// commit transaction
			session.getTransaction().commit();
		} finally {
			factory.close();
		}
	}

}
