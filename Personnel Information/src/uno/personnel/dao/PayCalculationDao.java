package uno.personnel.dao;

import java.util.List;

public interface PayCalculationDao {
	
	public  String personPayable(String name);  // returns the amount due to pay to the person
	public 	List<String> makePayroll();	// should return the number of persons to be paid
	// isPayed(PID) // returns boolean payed or Due 
	// list of person Names with amount Due

}
