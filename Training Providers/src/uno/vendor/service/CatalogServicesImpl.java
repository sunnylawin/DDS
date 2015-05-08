/**
 * CatalogServicesImpl.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package uno.vendor.service;

import java.util.ArrayList;

import javax.jws.WebService;

import uno.vendor.dao.CatalogDao;
import uno.vendor.dao.CatalogDaoImpl;
import uno.vendor.vo.CourseInfoVO;

@WebService
public class CatalogServicesImpl implements CatalogServices  {
	
	CatalogDao catalogDao = new CatalogDaoImpl();

	@Override
	public CourseInfoVO courseInfo(String courseName) {
		CourseInfoVO infoCourse = new CourseInfoVO();
		infoCourse = catalogDao.courseInfo(courseName);
		return infoCourse;
		
	}

	@Override
	public ArrayList areaCall(String AreaName) {

		ArrayList<String> courses = catalogDao.areaCall(AreaName);
		return courses;
		
	}

	@Override
	public CourseInfoVO recommendCourse(String skillIDs) {
		CourseInfoVO courseInfoVO = new CourseInfoVO();
		courseInfoVO = catalogDao.recommendCourse(skillIDs);
		return courseInfoVO;
		
	}

	
		
}
