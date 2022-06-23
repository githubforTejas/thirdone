package com.crm.genericutility;

import java.util.Date;
import java.util.Random;

/**
 * 
 * @author Admin
 *
 */
public class JavaUtility {
/**
 * it is used to generate a random number
 */
	public int getRandomNumber()
	{
		Random random=new Random();
		int randNum = random.nextInt(1000);
		return randNum;
	}
/**
 * it is used to get system date and time in IST format
 */
public String getSystemDateAndTimeInISTFormat()
{
	Date date=new Date();
	return date.toString();
}
/**
 * 
 */
public String getSystemDateAndTimeInFormat()
{
	Date date=new Date();
	String dateAndTime = date.toString();
	
	String YYYY = dateAndTime.split(" ")[5];
	String DD = dateAndTime.split(" ")[2];
	//String MM = dateAndTime.split(" ")[1];
	int MM = date.getMonth()+1;
	
	String finalFormat= YYYY+" "+DD+" "+MM;
	return finalFormat;
}
}
