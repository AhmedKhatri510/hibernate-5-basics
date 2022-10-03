package com.ahmed.hibernate_assignment.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="event")
public class PhotoEvent {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="event_name")
	private String eventName;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="event_id")
	private List<Photo> photos;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="album_id")
	private Album album;
	
	public PhotoEvent() {
		
	}

	public PhotoEvent(String eventName) {
		this.eventName = eventName;
	}
	
	public Album getAlbum() {
		return album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public List<Photo> getPhotos() {
		return photos;
	}

	public void setPhotos(List<Photo> photos) {
		this.photos = photos;
	}

	@Override
	public String toString() {
		return "Event [id=" + id + ", eventName=" + eventName + ", photos=" + photos + "]";
	}
	
	public void addPhoto(Photo photo) {
		if(photos == null) {
			photos = new ArrayList<Photo>();
			
		}
		photos.add(photo);
	}
}
