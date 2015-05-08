package uno.personnel.service;

import java.util.ArrayList;

import javax.jws.WebService;

import uno.operations.support.Validation;
import uno.personnel.dao.PositionSkillMgmtDao;
import uno.personnel.dao.PositionSkillMgmtDaoImpl;


@WebService(name="PositionSkillMgmtService")
public class PositionSkilMgmtServiceImpl implements PositionSkillMgmtService {

	PositionSkillMgmtDao positionSkillMgmtDao = new PositionSkillMgmtDaoImpl();
	Validation validationObj = new Validation();
	
	@Override
	public String addSkill(String Skill) {
		String status="";
		status = positionSkillMgmtDao.addSkill(Skill);
		return status;
	}

	
	
	@Override
	public String  addJobSkill(String JobID,String Skills) {
		// TODO Auto-generated method stub
		String status="";
		if(validationObj.isNull(JobID) && validationObj.isNull(Skills))
		{
			status = positionSkillMgmtDao.addJobSkill(JobID, Skills);
		}else
		{
			status = "Values cannot be null";
		}
		return status;
	}
	
	
	@Override
	public String dropJobSkill(String JobID, String Skills) {
		String status="";
		status=positionSkillMgmtDao.dropJobSkill(JobID, Skills);
		return status;
	}

	@Override
	public ArrayList positionSkill(String jobTitle) {
		// TODO Auto-generated method stub
		ArrayList<String> list = new ArrayList<String>();
		//list = 
		list = positionSkillMgmtDao.positionSkill(jobTitle);
		return list;
	}

	@Override
	public ArrayList possiblePosition(String skills) {
		// TODO Auto-generated method stub
		
		ArrayList<String> list = new ArrayList<String>();
		if(validationObj.isNull(skills))
		{
			list = positionSkillMgmtDao.possiblePosition(skills);
		}else
		{
			list.add("Values cannot be null");
		}
		
		
		return list;
	}

	@Override
	public String addJob(String job,int pay, String type) {
		// TODO Auto-generated method stub
		String status="";
		if(validationObj.isNull(job) && validationObj.isNull(type) && validationObj.isSalary(pay))
		{
			status = positionSkillMgmtDao.addJob(job,pay,type);
		}
		return status;
	}

	

}
