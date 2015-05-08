package uno.mgmt.service;

import java.util.ArrayList;

import javax.jws.WebService;

import uno.mgmt.dao.PersonnelSkillDao;
import uno.mgmt.dao.PersonnelSkillDaoImpl;


@WebService(name="PersonalSkillService")
public class PersonnelSkillServiceImpl implements PersonnelSkillService{
	
	PersonnelSkillDao personnelSkillDao = new PersonnelSkillDaoImpl();
	
	@Override
	public ArrayList personSkill(String personName) {
		
		ArrayList<String> listSkills = new ArrayList<String>();
		
		if(personName!=null)
		{
			listSkills = personnelSkillDao.personSkill(personName);
		}else
		{
			listSkills.add("certificate Can't be Null");
		}
		
		return listSkills;
	}

	@Override
	public ArrayList personCertificate(String personName) {

		ArrayList<String> listCertificats = new ArrayList<String>();
		
		if(personName!=null)
		{
			listCertificats = personnelSkillDao.personCertificate(personName);
		}else
		{
			listCertificats.add("Person Name Can't be Null");
		}
		return listCertificats;
		
	}
	
	@Override
	public ArrayList skillCall(String skills) {
		
		ArrayList<String> skillPersons = new ArrayList<String>();
			
			if(skills!=null)
			{
				skillPersons = personnelSkillDao.skillCall(skills);
			}else
			{
				skillPersons.add("certificate Can't be Null");
			}
		
		return skillPersons;
	}

		
	@Override
	public ArrayList certificateCall(String certificate) {
	
		ArrayList<String> listCertificats = new ArrayList<String>();
		if(certificate!=null){
		listCertificats = personnelSkillDao.certificateCall(certificate);
		}else
		{
			listCertificats.add("certificate Can't be Null");
		}
		return listCertificats;
	}

	

}
