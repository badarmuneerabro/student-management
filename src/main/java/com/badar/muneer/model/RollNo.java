package com.badar.muneer.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class RollNo 
{

	private int batch;
	private String dept;
	private int number;
	
	@Column(name = "BATCH")
	public int getBatch() {
		return batch;
	}
	public void setBatch(int batch) {
		this.batch = batch;
	}
	
	@Column(name = "DEPT", length = 10)
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	
	@Column(name = "NUMBER")
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	@Override
	public String toString() {
		return getBatch() + "" + getDept() + "" + getNumber();
	}
}
