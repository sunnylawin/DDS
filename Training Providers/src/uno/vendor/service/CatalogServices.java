/**
 * CatalogServices.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package uno.vendor.service;

import java.util.ArrayList;

import uno.vendor.vo.CourseInfoVO;

public interface CatalogServices  {
	public CourseInfoVO courseInfo(String courseName); //-- query, CourseInfo includes the skills/knowledge covered by the course as well as the level information
	public ArrayList areaCall(String AreaName); //-- list the courses in an area
	public CourseInfoVO recommendCourse(String skillIDs); //– skillIDs is a list
}
