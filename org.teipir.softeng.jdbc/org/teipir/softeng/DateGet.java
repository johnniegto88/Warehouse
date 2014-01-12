package org.teipir.softeng;

import java.util.Date;


public class DateGet {

	
public String getNewDate(){
	

	 Date c = new Date();
	 
	
	int date = c.getDate();
	String rdate = ""+date;
	if (date < 10){
		rdate = "0"+date;
	}
	int month = c.getMonth() +1 ;
	String rmonth = ""+month;
	if (month <10){
		rmonth = "0"+month;
	}
	int year = c.getYear();
	int ryear = year - 100;

	String dmy = ""+rdate+"/"+rmonth+"/"+ryear+"" ;
	 
	return dmy;
}
 
		
	}


