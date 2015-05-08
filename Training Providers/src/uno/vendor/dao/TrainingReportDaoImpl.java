package uno.vendor.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import uno.database.session.ConnectionFactory;
import uno.database.session.DbUtil;
import uno.operations.support.MiscellaneousSupport;
import uno.vendor.vo.GradeSetVO;

public class TrainingReportDaoImpl implements TrainingReportDao{

	private Connection connection;
	private Statement statement;
	MiscellaneousSupport miscellaneousSupport = new MiscellaneousSupport();
	
	
	@Override
	public ArrayList getAllGrades(String personName) {
		
		ArrayList<String> listAllgrades = new ArrayList<String>();
		int index=0;
		

		try{
		connection = ConnectionFactory.getConnection();
		statement = connection.createStatement();
		String query="select GRADE from GRADES where PERSON_ID = (select PERSON_ID from PERSON where LOWER(NAME)='"+personName+"')  AND GRADE_STATUS='GRADED'";
		ResultSet rs = null;
		rs = statement.executeQuery(query);
		
		while(rs.next()) 
		{
			listAllgrades.add(rs.getString(1));
			index++;
		}
		
		if(index==0){
			
			listAllgrades.add("Grades Doesn't Exist");
		}
		
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
		
			
			DbUtil.close(statement);
			DbUtil.close(connection);
		}
		
		return listAllgrades;
	}

	@Override
	public ArrayList getGrade(String personName, String courseName) {
		
		ArrayList<String> listSessiongrades = new ArrayList<String>();
		int index=0;
		

		try{
		connection = ConnectionFactory.getConnection();
		statement = connection.createStatement();
		String query="select GRADE from GRADES where PERSON_ID = (select PERSON_ID from PERSON where LOWER(NAME)='"+personName+"')  AND COURSE_ID = (select COURSE_ID from COURSES where LOWER(TITLE) ='"+courseName+"') AND GRADE_STATUS='GRADED'";
		ResultSet rs = null;
		rs = statement.executeQuery(query);
		
		while(rs.next()) 
		{
			listSessiongrades.add(rs.getString(1));
			index++;
		}
		
		if(index==0){
			
			listSessiongrades.add("Grades Doesn't Exist");
		}
		
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
		
			
			DbUtil.close(statement);
			DbUtil.close(connection);
		}
		
		return listSessiongrades;// TODO Auto-generated method stub
		
	}

}
