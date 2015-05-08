package uno.vendor.service;

import java.util.ArrayList;
import java.util.Date;

import javax.jws.WebService;

import uno.vendor.vo.GradeSetVO;


public interface TrainingReportService {
 
	public ArrayList getAllGrades(String person_id); // -- list the courses and corresponding earned grades
	public ArrayList getGrade(String personName,String courseName); // -- list the grade of the person in the session
}
