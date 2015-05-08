package uno.vendor.dao;

import java.util.ArrayList;

import uno.vendor.vo.CourseInfoVO;

public interface CatalogDao {

	public CourseInfoVO courseInfo(String courseName); //-- query, CourseInfo includes the skills/knowledge covered by the course as well as the level information
	public ArrayList areaCall(String AreaName); //-- list the courses in an area
	public CourseInfoVO recommendCourse(String skillIDs); //– skillIDs is a list

	
}
