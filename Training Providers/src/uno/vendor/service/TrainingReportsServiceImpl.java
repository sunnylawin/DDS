package uno.vendor.service;

import java.util.ArrayList;
import java.util.Date;

import javax.jws.WebService;

import uno.vendor.dao.TrainingReportDao;
import uno.vendor.dao.TrainingReportDaoImpl;
import uno.vendor.vo.GradeSetVO;

@WebService(name="TrainingReportService")
public class TrainingReportsServiceImpl implements TrainingReportService{

	TrainingReportDao trainingReportDao = new TrainingReportDaoImpl();
	
	@Override
	public ArrayList getAllGrades(String personName) {
		ArrayList<String> result = trainingReportDao.getAllGrades(personName); 
		return result;
	}

	

	@Override
	public ArrayList getGrade(String personName, String session_id) {
		
		ArrayList<String> result  = trainingReportDao.getGrade(personName,session_id); 
		return result;
	}

}
