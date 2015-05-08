package uno.vca.dao;

import java.util.ArrayList;


public interface VCADao {
	
	public ArrayList courseSuggested(String personName,String JobName); 
	public ArrayList positionOpen(String personName);
	public ArrayList personSkills(String Name);
	
}
