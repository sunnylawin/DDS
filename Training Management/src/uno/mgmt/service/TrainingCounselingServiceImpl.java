package uno.mgmt.service;

import java.util.ArrayList;

import javax.jws.WebService;

import uno.mgmt.dao.TrainingCounselingDao;
import uno.mgmt.dao.TrainingCounselingDaoImpl;
import uno.personnel.service.PositionSkillMgmtServiceProxy;


@WebService(name="TrainingCounselingService")
public class TrainingCounselingServiceImpl implements TrainingCounselingService{
	
	TrainingCounselingDao trainingCounselingDao = new TrainingCounselingDaoImpl();
	
	@Override
	public ArrayList missingSkill(String personName,String Job) {

		ArrayList<String> listResult = new ArrayList<String>();
		if(personName!=null && Job!=null)
		{
			listResult = trainingCounselingDao.missingSkill(personName, Job);
		}else{
			listResult.add("Inputs Cannot Be Null");
		}
		
		return listResult;
	}

	@Override
	public ArrayList recommendCourse(String personName,String Job) {

		ArrayList<String> listResult = new ArrayList<String>();
		if(personName!=null && Job!=null)
		{
		listResult = trainingCounselingDao.recommendCourse(personName,Job);
		}else{
			listResult.add("Inputs Cannot Be Null");
		}
		return listResult;
	}

	

}
