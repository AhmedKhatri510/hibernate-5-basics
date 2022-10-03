package com.ahmed.hibernate_assignment.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="passport")
public class Passport {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="pass_no")
	private String passportNo;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="emp_id")
	private Employee employee;
	
	public Passport() {
		
	}
	
	public Passport(String passportNo) {
		this.passportNo = passportNo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPassportNo() {
		return passportNo;
	}

	public void setPassportNo(String passportNo) {
		this.passportNo = passportNo;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "Passport [id=" + id + ", passportNo=" + passportNo + ", employee=" + employee + "]";
	}

	
	
	


	
	
}
