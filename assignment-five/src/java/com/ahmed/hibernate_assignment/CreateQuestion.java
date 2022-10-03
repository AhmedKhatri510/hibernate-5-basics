package com.ahmed.hibernate_assignment;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ahmed.hibernate_assignment.entity.Answer;
import com.ahmed.hibernate_assignment.entity.Option;
import com.ahmed.hibernate_assignment.entity.Question;

/**
 * Hello world!
 *
 */
public class CreateQuestion {
	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Question.class)
				.addAnnotatedClass(Option.class).addAnnotatedClass(Answer.class).buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			// start a transaction
			session.beginTransaction();

			// creating questions and answer and saving it.

			Question q1 = new Question("What is question 1?");
			Answer ans1 = new Answer("option 1");

			q1.setAnswer(ans1);
			session.save(q1);

			// saving options related to specific question

			Option o1 = new Option("option 1");
			Option o2 = new Option("option 2");
			Option o3 = new Option("option 3");
			Option o4 = new Option("option 4");

			q1.add(o1);
			q1.add(o2);
			q1.add(o3);
			q1.add(o4);

			session.save(o1);
			session.save(o2);
			session.save(o3);
			session.save(o4);

			// commit transaction
			session.getTransaction().commit();
		} finally {
			session.close();
			factory.close();
		}
	}
}
