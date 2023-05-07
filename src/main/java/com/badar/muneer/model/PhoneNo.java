package com.badar.muneer.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;

@Embeddable
public class PhoneNo 
{
	
	private String countryCode;
	@NotBlank(message = "* Phone number is required")
	private String phoneNumber;
	
	@Column(name = "COUNTRY_CODE", length = 10)
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	
	@Column(name = "PHONE_NO", length = 20)
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	@Override
	public String toString() {
		return getCountryCode() + "-" + getPhoneNumber();
	}

}
