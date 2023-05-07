package com.badar.muneer.model;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "STUDENT")
public class Student 
{
	private long id;
	
	private RollNo rollNo;
	private String firsName;
	private String lastName;
	private String country;
	private PhoneNo phone;
	
	@Id
	@Column(name = "ID")
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	@Embedded
	public RollNo getRollNo() {
		return rollNo;
	}
	
	public void setRollNo(RollNo rollNo) {
		this.rollNo = rollNo;
	}
	
	@Column(name = "FIRST_NAME", length = 50)
	public String getFirsName() {
		return firsName;
	}
	public void setFirsName(String firsName) {
		this.firsName = firsName;
	}
	
	@Column(name = "LAST_NAME", length = 50)
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@Column(name = "COUNTRY", length = 50)
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	@Embedded
	public PhoneNo getPhone() {
		return phone;
	}
	public void setPhone(PhoneNo phone) {
		this.phone = phone;
	}
	
	
	@Override
	public String toString() {
		return "Student [id=" + id + ", rollNo=" + rollNo + ", firsName=" + firsName + ", lastName=" + lastName
				+ ", country=" + country + ", phone=" + phone + "]";
	}
	
	
}
