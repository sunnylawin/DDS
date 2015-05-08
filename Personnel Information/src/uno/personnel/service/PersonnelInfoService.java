package uno.personnel.service;

import uno.object.vo.*;

import java.util.ArrayList;
import java.util.Date;

import javax.jws.WebService;



public interface PersonnelInfoService {
	
	public ContactInfo personContactInfo(String name); // Returns the Information of a person
	public ArrayList personPositionInfo(String name);   // working on this
	public String personSeniorityInfo(String name);	// returns the Date of Joining to calculate Seniority comparing to present date
	

}
