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
@Table(name="country")
public class Country {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="country_id")
	private List<Capital> capitals;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="continent_id")
	private Continent continent;
	
	public Country() {
		
	}

	public Country(String name) {
		this.name = name;
	}

	public Continent getContinent() {
		return continent;
	}

	public void setContinent(Continent continent) {
		this.continent = continent;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Capital> getCapitals() {
		return capitals;
	}

	public void setCapitals(List<Capital> capitals) {
		this.capitals = capitals;
	}

	@Override
	public String toString() {
		return "Country [id=" + id + ", name=" + name + ", capitals=" + capitals + "]";
	}
	
	public void addCapital(Capital capital) {
		if(capitals == null) {
			capitals = new ArrayList<Capital>();
		}
		
		capitals.add(capital);
	}
	
}
