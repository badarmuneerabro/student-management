package com.badar.muneer.comparator;

import java.util.Comparator;

import com.badar.muneer.model.Student;

public class StudentComparator implements Comparator<Student>
{

	public int compare(Student o1, Student o2) 
	{
		int batch1 = o1.getRollNo().getBatch();
		int batch2 = o2.getRollNo().getBatch();
		
		
		if(batch1 < batch2)
			return 1;
		else if(batch1 > batch2)
			return -1;
		
		int number1 = o1.getRollNo().getNumber();
		int number2 = o2.getRollNo().getNumber();
		
		if(number1 < number2)
			return -1;
		else if(number1 > number2)
			return 1;
		
		return 0;
	}
	
}
