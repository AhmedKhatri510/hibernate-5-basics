package com.ahmed.hibernate_assignment.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="emp_id")
	private int emp_id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="designation")
	private String designation;
	
	@Column(name="emp_dob")
	private Date empDob;
	
	@Column(name="emp_jod")
	private Date empJod;
	
	@Column(name="emp_age")
	private int empAge;
	
	@Column(name="emp_basicpay")
	private float empBasicpay;

	public Employee() {

	}

	public Employee(String name, String designation, Date empDob, Date empJod, int empAge, float empBasicpay) {
		this.name = name;
		this.designation = designation;
		this.empDob = empDob;
		this.empJod = empJod;
		this.empAge = empAge;
		this.empBasicpay = empBasicpay;
	}

	public int getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public Date getEmpDob() {
		return empDob;
	}

	public void setEmpDob(Date empDob) {
		this.empDob = empDob;
	}

	public Date getEmpJod() {
		return empJod;
	}

	public void setEmpJod(Date empJod) {
		this.empJod = empJod;
	}

	public int getEmpAge() {
		return empAge;
	}

	public void setEmpAge(int empAge) {
		this.empAge = empAge;
	}

	public float getEmpBasicpay() {
		return empBasicpay;
	}

	public void setEmpBasicpay(float empBasicpay) {
		this.empBasicpay = empBasicpay;
	}

	@Override
	public String toString() {
		return "Employee [emp_id=" + emp_id + ", name=" + name + ", designation=" + designation + ", empDob=" + empDob
				+ ", empJod=" + empJod + ", empAge=" + empAge + ", empBasicpay=" + empBasicpay + "]";
	}

	

}