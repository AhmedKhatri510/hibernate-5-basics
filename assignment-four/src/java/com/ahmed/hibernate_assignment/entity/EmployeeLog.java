package com.ahmed.hibernate_assignment.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employee_log")
public class EmployeeLog {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="emp_id")
	private int empId;
	
	@Column(name="name")
	private String name;
	
	@Column(name="designation")
	private String designation;
	
	@Column(name="leave_date")
	private Date leaveDate;
	
	@Column(name="last_drawnsalary")
	private float lastDrawnsalary;
	
	public EmployeeLog() {
		
	}

	public EmployeeLog(int empId, String name, String designation, Date leaveDate, float lastDrawnsalary) {
		this.empId = empId;
		this.name = name;
		this.designation = designation;
		this.leaveDate = leaveDate;
		this.lastDrawnsalary = lastDrawnsalary;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
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

	public Date getLeaveDate() {
		return leaveDate;
	}

	public void setLeaveDate(Date leaveDate) {
		this.leaveDate = leaveDate;
	}

	public float getLastDrawnsalary() {
		return lastDrawnsalary;
	}

	public void setLastDrawnsalary(float lastDrawnsalary) {
		this.lastDrawnsalary = lastDrawnsalary;
	}

	@Override
	public String toString() {
		return "EmployeeLog [id=" + id + ", empId=" + empId + ", name=" + name + ", designation=" + designation
				+ ", leaveDate=" + leaveDate + ", lastDrawnsalary=" + lastDrawnsalary + "]";
	}

	
	
	

}
