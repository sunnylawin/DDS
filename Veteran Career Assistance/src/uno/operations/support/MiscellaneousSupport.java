package uno.operations.support;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class MiscellaneousSupport {
	
	/* This method takes the a date and returns the difference to the present date */
	public String getDatedifference(String dateString1) throws ParseException
	{
		    SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");

		    String dateString2 = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
		    Date date1 = format.parse(dateString1);
		    Date date2 = format.parse(dateString2); 

		    long diff = date1.getTime() - date2.getTime();
		    
			long diffSeconds = diff / 1000 % 60;
			long diffMinutes = diff / (60 * 1000) % 60;
			long diffHours = diff / (60 * 60 * 1000) % 24;
			long diffDays = diff / (24 * 60 * 60 * 1000);
 
			System.out.print(diffDays + " days, ");
			System.out.print(diffDays/365 + " Years, ");
			System.out.print(diffDays%365 + " rest days, ");
			
		    return diffDays/365 + " Years"+diffDays%365 + " days";
	}
	
	/* This method takes the string of values with commas and returns the list of strings */
	public List<String> getList(String splitString)
	{
		List<String> list = Arrays.asList(splitString.split(","));
		return list;
		
	}
	
	/* This method takes the present id and returns the incremented value */
	public String generatedID(String id) 
	{
		String genID ="";
		int number;
		genID +=id.substring(0,4);
		number = Integer.parseInt(id.substring(4));
		number++;
		genID +=""+number;
		//System.out.println("Return id >>>>>>>>>>>>>   "+genID);
		return genID;
	}

}
