package uno.personnel.service;

import java.util.ArrayList;

import javax.jws.WebService;



public interface PositionSkillMgmtService {

	
	public String addJob(String Job,int pay, String Type);				// Add a new Job
	public String addSkill(String Skill);
	public String addJobSkill(String JobID,String Skills);					// add skills to a job
	public String dropJobSkill(String JobID,String Skills);					// drop skills for a job
	public ArrayList positionSkill(String jobTitle); 					// Skills required for a job
	public ArrayList possiblePosition(String SKills);					// Positions available set of Skills
	// vacentPositions
	
	
}
