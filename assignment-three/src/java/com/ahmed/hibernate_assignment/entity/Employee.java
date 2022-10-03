package com.ahmed.hibernate_assignment.entity;

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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "emp_id")
	private int emp_id;

	@Column(name = "name")
	private String name;

	@Column(name = "emp_band")
	private String empBand;

	public Employee() {

	}

	public Employee(String name, String empBand) {
		this.name = name;
		this.empBand = empBand;
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

	public String getEmpBand() {
		return empBand;
	}

	public void setEmpBand(String empBand) {
		this.empBand = empBand;
	}

	@Override
	public String toString() {
		return "Employee [emp_id=" + emp_id + ", name=" + name + ", empBand=" + empBand + "]";
	}

}