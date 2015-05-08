package uno.vendor.dao;

import java.util.ArrayList;

import uno.vendor.vo.GradeSetVO;

public interface TrainingReportDao {
	
	public ArrayList getAllGrades(String personName); // -- list the courses and corresponding earned grades
	public ArrayList getGrade(String personName,String courseName); // -- list the grade of the person in the session
 	
}
