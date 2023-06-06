package com.manytoone;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Comment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer id;
   
   private String content;
   
   @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
   private Blog blog;

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

public Blog getBlog() {
	return blog;
}

public void setBlog(Blog blog) {
	this.blog = blog;
}

@Override
public String toString() {
	return "Comment [id=" + id + ", content=" + content + ", blog=" + blog + "]";
}
   
   
}
