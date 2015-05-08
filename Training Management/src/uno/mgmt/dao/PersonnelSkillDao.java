package uno.mgmt.dao;

import java.util.ArrayList;

public interface PersonnelSkillDao {
	
	public ArrayList personSkill(String personName);  			// – a person’s skills
	public ArrayList personCertificate(String personName); 	//– a person’s certificates
	public ArrayList skillCall(String skillID); 				// – enumeration of the persons who possess the skills
	public ArrayList certificateCall(String certID); 			// enumeration of the persons who possess the certificate
	//public void updateTrainingStatus(String personID,String[] knowledgeSkillInfo);
	// addSkill(PID,Skills[])     // Adds Skills to a person
	// addCertificate(PID,certificates[]) // Adds a Certificates to a person

}
