package com.ahmed.hibernate_assignment.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="album")
public class Album {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="albumid")
	private int id;
	
	@Column(name="aname")
	private String albumName;
	
	@OneToMany(mappedBy="album", cascade=CascadeType.ALL)
	private List<PhotoEvent> events;
	
	public Album() {
		
	}

	public Album(String albumName) {
		this.albumName = albumName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAlbumName() {
		return albumName;
	}

	public void setAlbumName(String albumName) {
		this.albumName = albumName;
	}

	
	
	public List<PhotoEvent> getEvents() {
		return events;
	}

	public void setEvents(List<PhotoEvent> events) {
		this.events = events;
	}
	

	@Override
	public String toString() {
		return "Album [id=" + id + ", albumName=" + albumName + ", events=" + events + "]";
	}

	public void addEvent(PhotoEvent event) {
		if(events == null) {
			events = new ArrayList<PhotoEvent>();
			
		}
		events.add(event);
		event.setAlbum(this);
	}
}
