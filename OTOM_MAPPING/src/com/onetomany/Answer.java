package com.onetomany;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Answer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String content;

    //@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	//private Question question;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "Answer [id=" + id + ", content=" + content + "]";
	}

	//public Question getQuestion() {
	//	return question;
	//}

	//public void setQuestion(Question question) {
	//	this.question = question;
	//}

	
	
	

}
