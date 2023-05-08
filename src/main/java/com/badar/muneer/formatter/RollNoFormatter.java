package com.badar.muneer.formatter;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.format.Formatter;

import com.badar.muneer.model.RollNo;

public class RollNoFormatter implements Formatter<RollNo>
{

	public String print(RollNo rollNo, Locale locale) 
	{
		String number = "";
		if(rollNo.getNumber() < 10)
			number = "0" + rollNo.getNumber();
		else
			number = rollNo.getNumber() + "";
		return rollNo.getBatch() + "" + rollNo.getDept() + "" + number;
	}

	public RollNo parse(String text, Locale locale) throws ParseException 
	{
		RollNo rollNo = new RollNo();
		int batch = 0;
		String dept = null;
		int number = 0;
		
		if(text.length() == 6)
		{
			batch = Integer.parseInt(text.substring(0, 2));
			dept = text.substring(2, 4);
			number = Integer.parseInt(text.substring(4, text.length()));
		}
		
		else if(text.length() == 7)
		{
			batch = Integer.parseInt(text.substring(0, 2));
			dept = text.substring(2, 5);
			number = Integer.parseInt(text.substring(5, text.length()));
		}
		
		rollNo.setBatch(batch);
		rollNo.setDept(dept);
		rollNo.setNumber(number);
		return rollNo;
	}

}
