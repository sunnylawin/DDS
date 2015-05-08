package uno.personnel.service;

import java.util.List;

import javax.jws.WebService;


public interface PayCalculationService {
	
	public  String personPayable(String name);  // returns the amount due to pay to the person
	public 	List<String> makePayroll();	// should return the number of persons to be paid
	
}
