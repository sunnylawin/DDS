package uno.vendor.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import uno.database.session.ConnectionFactory;
import uno.database.session.DbUtil;
import uno.operations.support.MiscellaneousSupport;
import uno.vendor.vo.CourseInfoVO;

public class CatalogDaoImpl implements CatalogDao {

	
	private Connection connection;
	private Statement statement;
	MiscellaneousSupport miscellaneousSupport = new MiscellaneousSupport();
	
	
	@Override
	public CourseInfoVO courseInfo(String courseName) {
		CourseInfoVO courseInfoVO = new CourseInfoVO();
		
		try{
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();
			String query = "select * from COURSES where LOWER(TITLE) ='"+courseName.toLowerCase()+"'";
			ResultSet rs = null;
			rs = statement.executeQuery(query);
			
			int index=0;
			while(rs.next()) 
			{
				courseInfoVO.setCourseID(rs.getNString(1));
				courseInfoVO.setArea(rs.getNString(2));
				courseInfoVO.setCourseTitle(rs.getNString(3));
				courseInfoVO.setRank(rs.getNString(4));
				courseInfoVO.setDecp(rs.getNString(5));
				courseInfoVO.setStatus(rs.getNString(6));
				index++;
			}
			
			if(index==0){
				
				courseInfoVO.setCourseTitle("CourseTitle Does not Exist");
			}
	
		} catch (SQLException e) {
		
			e.printStackTrace();
		} finally {
		
			
			DbUtil.close(statement);
			DbUtil.close(connection);
		}
		
		
		return courseInfoVO;
	}

	@Override 			// input :  language 
	public ArrayList areaCall(String areaName) {
		ArrayList<String> courses = new ArrayList<String>() ;
		
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  area call "+areaName);
		try{
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();
			String query = "select * from COURSES where LOWER(AREA) ='"+areaName.toLowerCase()+"'";
			ResultSet rs ;
			rs = statement.executeQuery(query);
			
			int index=0;
			while(rs.next()) 
			{
				courses.add(rs.getNString(3));
				index++;
			}
			
			if(index==0){
				
				courses.add("Area Does not Exist");
			}


			
		} catch (SQLException e) {
		
			e.printStackTrace();
		} finally {
		
			
			DbUtil.close(statement);
			DbUtil.close(connection);
		}
		
		return courses;
	}

	@Override
	public CourseInfoVO recommendCourse(String skillName) {
		
		CourseInfoVO courseInfoVO = new CourseInfoVO();
		
		try{
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();
			String query = "Select * from COURSES where COURSE_ID =(Select COURSE_ID from COURSE_SKILLS where S_ID =(select S_ID from SKILLS where LOWER(S_TITLE) ='"+skillName+"'))";
			ResultSet rs = null;
			rs = statement.executeQuery(query);
			
			int index=0;
			while(rs.next()) 
			{
				courseInfoVO.setCourseID(rs.getNString(1));
				courseInfoVO.setArea(rs.getNString(2));
				courseInfoVO.setCourseTitle(rs.getNString(3));
				courseInfoVO.setRank(rs.getNString(4));
				courseInfoVO.setDecp(rs.getNString(5));
				courseInfoVO.setStatus(rs.getNString(6));
				index++;
			}
			
			if(index==0){
				
				courseInfoVO.setCourseTitle("No Course exist to aquire this Skill");
			}


			
		} catch (SQLException e) {
		
			e.printStackTrace();
		} finally {
		
			
			DbUtil.close(statement);
			DbUtil.close(connection);
		}
		
		
		
		return courseInfoVO;
	}

}
