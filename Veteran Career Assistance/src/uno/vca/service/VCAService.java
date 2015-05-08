package uno.vca.service;

import java.util.ArrayList;
import java.util.Date;

import javax.jws.WebService;



public interface VCAService {
 
	public ArrayList courseSuggested(String personName,String JobName); 
	public ArrayList positionOpen(String personName);
	public ArrayList personSkills(String Name);
	// missing Skills
	// Apply Job
	// possible Jobs and Skills
	// Recommended Course
}
