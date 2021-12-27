package com.Assesment.demo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table (name="USERS")
public class User  {
	
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	
	 public long id;
	@Column
	public String fname;
	@Column
	public String lname;
	@Column
	public String dob;
	@Column
	public String city;
	 @Column
	 public String mobileno;
	
	
	public User() {
		
	}
	
	public User(long id,String fname,String lname,String dob,String city,String mobileno) {
		
		this.id= id;
		this.fname = fname;
		this.lname = lname;
		this.dob = dob;
		this.city = city;
		this.mobileno = mobileno;
		
	}
	

	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getMobileno() {
		return mobileno;
	}

	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}	

}
