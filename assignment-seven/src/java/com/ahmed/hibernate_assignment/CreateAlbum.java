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
public class CreateAlbum {
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

			Album album1 = new Album("album 1");
			
			PhotoEvent e1 = new PhotoEvent("Engagement");
			
			List<Photo> photos = new ArrayList<Photo>();
			
			Photo p1 = new Photo("photo 1");
			photos.add(p1);
			
			Photo p2 = new Photo("photo 2");
			photos.add(p2);
			
			e1.setPhotos(photos);
			
			album1.addEvent(e1);
			
			session.save(album1);

			
			// commit transaction
			session.getTransaction().commit();
		} finally {
			session.close();
			factory.close();
		}
	}
}
