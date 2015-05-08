package uno.personnel.dao;

import java.util.ArrayList;

public interface PositionSkillMgmtDao {
	
	public String addJob(String Job,int pay, String Type);				// Add a new Job
	public String addSkill(String Skill);
	public String addJobSkill(String JobID,String Skills);					// add skills to a job
	public String dropJobSkill(String JobID,String Skills);					// drop skills for a job
	public ArrayList positionSkill(String positionID); 					// Skills required for a job
	public ArrayList possiblePosition(String SKills);					// Positions available set of Skills

}
