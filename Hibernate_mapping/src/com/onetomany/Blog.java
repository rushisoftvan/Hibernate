package com.onetomany;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity

public class Blog {
   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	@Override
	public String toString() {
		return "Blog [id=" + id + ", content=" + content + ", getId()=" + getId() + ", getContent()=" + getContent()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	public void setContent(String content) {
		this.content = content;
	}
    
   
    
         
}
