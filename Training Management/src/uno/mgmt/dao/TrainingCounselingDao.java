package uno.mgmt.dao;

import java.util.ArrayList;

public interface TrainingCounselingDao {
	
	public ArrayList missingSkill(String personName,String Job);  // Returns Skills required by person for a position
	public ArrayList recommendCourse(String personName,String Job); // Recommended Course for a position, to fill the skill gap 
	//-- find the person’s skills by calling personSkill in the “Person skill service”,
	//-- find the required skills of the position by calling positionSkill in the “Position-skill management Service"
	//-- and call recommendCourse in Catalog service.
	
	
}
