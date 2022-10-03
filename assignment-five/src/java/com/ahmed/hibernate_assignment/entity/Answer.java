package com.ahmed.hibernate_assignment.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

@Entity
@Table(name="answer")
public class Answer {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="answer_name")
	private String answerName;
	
	
	public Answer() {
		
	}

	public Answer(String answerName) {
		this.answerName = answerName;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAnswerName() {
		return answerName;
	}

	public void setAnswerName(String answerName) {
		this.answerName = answerName;
	}

	@Override
	public String toString() {
		return "Answer [id=" + id + ", answerName=" + answerName + "]";
	}

	
}
