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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="question")
public class Question {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="qname")
	private String qName;
	
	@OneToMany(mappedBy="question",cascade=CascadeType.ALL)
	private List<Option> options;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="answer_id")
	private Answer answer;
	
	public Question() {
		
	}

	public Question(String qName) {
		this.qName = qName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getqName() {
		return qName;
	}

	public void setqName(String qName) {
		this.qName = qName;
	}

	public List<Option> getOptions() {
		return options;
	}

	public void setOptions(List<Option> options) {
		this.options = options;
	}


	public Answer getAnswer() {
		return answer;
	}

	public void setAnswer(Answer answer) {
		this.answer = answer;
	}
	
	@Override
	public String toString() {
		return "Question [id=" + id + ", qName=" + qName + ", options=" + options + ", answer=" + answer + "]";
	}

	public void add(Option tempOption) {
		if(options == null) {
			options = new ArrayList<Option>();
		}
		
		options.add(tempOption);
		tempOption.setQuestion(this);
	}
	
}
