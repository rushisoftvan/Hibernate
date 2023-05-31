package com.learn.jpa_crud_opration;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;

@Entity
@Table(name = "Employee")
public class EmployeeEntity {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "SURNAME")
	private String surname;

	@Column(name = "AGE")
	private Integer age;
    
	@Column(name="CREATED_ON")
	private LocalDateTime createdOn;
    
	@Column(name="UPDATED_ON")
	private LocalDateTime updatedOn;
    
	  public EmployeeEntity() {
		  
	  }
	
	public EmployeeEntity(String name, String surname, Integer age) {
		this.name = name;
		this.surname = surname;
		this.age = age;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public LocalDateTime getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(LocalDateTime createdOn) {
		this.createdOn = createdOn;
	}

	public LocalDateTime getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(LocalDateTime updatedOn) {
		this.updatedOn = updatedOn;
	}

	@PrePersist
	public void cratedDate() {
		this.createdOn = LocalDateTime.now();
		this.updatedOn = LocalDateTime.now();
	}

	@PreUpdate
	public void updatDate() {
		this.updatedOn = LocalDateTime.now();
	}

	@Override
	public String toString() {
		return "EmployeeEntity [id=" + id + ", name=" + name + ", surname=" + surname + ", age=" + age + ", createdOn="
				+ createdOn + ", updatedOn=" + updatedOn + "]";
	}
	
}