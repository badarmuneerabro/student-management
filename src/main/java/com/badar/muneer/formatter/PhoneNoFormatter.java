package com.badar.muneer.formatter;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.format.Formatter;

import com.badar.muneer.model.PhoneNo;

public class PhoneNoFormatter implements Formatter<PhoneNo>
{

	public String print(PhoneNo phoneNo, Locale locale) 
	{
		// TODO Auto-generated method stub
		return phoneNo.getCountryCode() + "-" + phoneNo.getPhoneNumber();
	}

	public PhoneNo parse(String text, Locale locale) throws ParseException 
	{
		PhoneNo phoneNumber = new PhoneNo();
		if(text.contains("-"))
		{
			String[] phone = text.split("-");
			
			phoneNumber.setCountryCode(phone[0]);
			phoneNumber.setPhoneNumber(phone[1]);
			
		}
		
		else if(!text.contains("-"))
		{
			phoneNumber.setCountryCode("+92");
			phoneNumber.setPhoneNumber(text);
		}
		return phoneNumber;
	}
	

}
