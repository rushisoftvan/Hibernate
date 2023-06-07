package onetomanybi;

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
public class Student {
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
 	private  Integer id;
	
	private String name;
	@OneToMany(fetch = FetchType.EAGER,cascade = {CascadeType.ALL},mappedBy = "student")
	List<Phone> phones;
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Student(Integer id, String name, List<Phone> phones) {
		super();
		this.id = id;
		this.name = name;
		this.phones = phones;
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
	public List<Phone> getPhones() {
		return phones;
	}
	public void setPhones(List<Phone> phones) {
		this.phones = phones;
	}
	
	public  void addPhone(Phone phone) {
		getPhones().add(phone);
		phone.setStudent(this);
	}
    
	public String toString() {
		return  "Student[id="+ id+",name ="+name+",phones.size()"+ phones.size() +"]";
	}
	
	
	
}
