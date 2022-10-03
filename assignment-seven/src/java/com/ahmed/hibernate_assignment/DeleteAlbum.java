package com.ahmed.hibernate_assignment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ahmed.hibernate_assignment.entity.Album;
import com.ahmed.hibernate_assignment.entity.Photo;
import com.ahmed.hibernate_assignment.entity.PhotoEvent;


/**
 * Hello world!
 *
 */
public class DeleteAlbum {
	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Album.class)
				.addAnnotatedClass(Photo.class)
				.addAnnotatedClass(PhotoEvent.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			// start a transaction
			session.beginTransaction();

			List<Album> albums = session.createQuery("from Album a where a.id > 1").getResultList();
			for(Album a: albums) {
				session.delete(a);			
			}
			
			// commit transaction
			session.getTransaction().commit();
		} finally {
			session.close();
			factory.close();
		}
	}
}
