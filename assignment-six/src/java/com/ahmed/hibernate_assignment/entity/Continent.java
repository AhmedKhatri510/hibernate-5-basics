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
@Table(name="continent")
public class Continent {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@OneToMany(mappedBy="continent", cascade=CascadeType.ALL)
	private List<Country> countries;
	
	public Continent() {
		
	}

	public Continent(String name) {
		this.name = name;
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

	public List<Country> getCountries() {
		return countries;
	}

	public void setCountries(List<Country> countries) {
		this.countries = countries;
	}

	@Override
	public String toString() {
		return "Continent [id=" + id + ", name=" + name + ", countries=" + countries + "]";
	}
	
	public void addCountry(Country country) {
		if(countries == null) {
			countries=new ArrayList<Country>();
		}
		
		countries.add(country);
		country.setContinent(this);
	}
	
}
