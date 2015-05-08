package uno.personnel.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import uno.database.session.ConnectionFactory;
import uno.database.session.DbUtil;
import uno.operations.support.MiscellaneousSupport;

public class PositionSkillMgmtDaoImpl implements PositionSkillMgmtDao{

	
	private Connection connection;
	private Statement statement;
	
	MiscellaneousSupport miscellaneousSupport = new MiscellaneousSupport();
	
	
	@Override
	public String addJobSkill(String jobTitle,String Skills) {
		
		String jobID;
		String status = "";
		List<String> list = miscellaneousSupport.getList(Skills);
		
		try{
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();
			String query = "SELECT JOB_ID FROM JOB Where LOWER(TITLE) =LOWER('"+ jobTitle + "')";
			ResultSet rs = null;
			rs = statement.executeQuery(query);
			
			if(rs.next()) {
				
				jobID = rs.getString(1);
				String skill="''";
				for(String str:list)
				{
					skill +=",'"+str.toLowerCase()+"'";
					System.out.println(str);
				}
				
				query = "Select S_ID from SKILLS where LOWER(S_TITLE) in ("+skill+")";
				//rs = null;
				System.out.println(">>>>>>>>>>>>>>  "+query);
				rs = connection.createStatement().executeQuery(query);
				int index=0;
				while(rs.next()){
					
					
						String insertQuery = "";
						insertQuery = "insert into JOB_SKILLS values('"+jobID+"','"+rs.getString(1)+"')";
						//System.out.println(">>>>>>>> insert Query "+insertQuery);
						statement.executeQuery(insertQuery);
						
						status = "Successfully Skill added to Job";
						index++;
						
				}if(index==0){
					status="Skills Does Not Exist, Add Skill's  ";
				}
				
			
			}else{
				
				status="JOB Does Not Exist, Add Job Before adding Skills";
			}


			
		} catch (SQLException e) {
		
			e.printStackTrace();
		} finally {
		
			
			DbUtil.close(statement);
			DbUtil.close(connection);
		}
		
		return status;
		
	}

	@Override
	public String addSkill(String Skill) {
		String status="";
		String insertID="";
		List<String> list = miscellaneousSupport.getList(Skill);
		
		try{
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();
			String query = "select * from SKILLS order by S_ID";
			ResultSet rs = null;
			rs = statement.executeQuery(query);
			String  lastID="";
			
			while(rs.next())
			{
				insertID = rs.getString(1);
			}
			
			
			if(insertID != null)
			{
				for(String str:list)
				{
					
					lastID=insertID;
					
					insertID = miscellaneousSupport.generatedID(insertID);
					//System.out.println(insertID+"     >>insertID>>>>>>>>>>>lastID  "+lastID);
					query = "insert into SKILLS values('"+insertID+"','"+str.toUpperCase()+"')";
					//System.out.println(">>>>>>>>>>>Skills>>>>>>>> "+query);
					statement.executeQuery(query);
					status = "Skill added succesfully";
				}
			}else
			{
				
			}
			} catch (SQLException e) {
				
				e.printStackTrace();
			} finally {
			
				
				DbUtil.close(statement);
				DbUtil.close(connection);
			}
		return status;
	}
	
	@Override
	public String dropJobSkill(String jobTitle,String Skills) {
		
		String jobID;
		String status = null;
		List<String> list = miscellaneousSupport.getList(Skills);
		
		try{
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();
			String query = "SELECT JOB_ID FROM JOB Where LOWER(TITLE) =LOWER('"+ jobTitle + "')";
			ResultSet rs = null;
			rs = statement.executeQuery(query);
			
			if(rs.next()) {
				
				jobID = rs.getString(1);
				String skill="''";
				for(String str:list)
				{
					skill +=",'"+str.toLowerCase()+"'";
					System.out.println(str);
				}
				
				query = "Select S_ID from SKILLS where LOWER(S_TITLE) in ("+skill+")";
				
				rs = connection.createStatement().executeQuery(query);
			
				while(rs.next()){
					
					
						String deleteQuery = "";
						deleteQuery = "DELETE from JOB_SKILLS WHERE JOB_ID= '"+jobID+"' and S_ID='"+rs.getString(1)+"'";

						//System.out.println(">>>>>>>> deleteQuery >>>>   "+deleteQuery);
						statement.executeQuery(deleteQuery);
						status = "Successfully Skill deleted from Job";
				}
				
			
			}else{
				
				status="JOB Does Not Exist, Add Job Before adding Skills";
			}


			
		} catch (SQLException e) {
		
			e.printStackTrace();
		} finally {
		
			
			DbUtil.close(statement);
			DbUtil.close(connection);
		}
		
		return status;
	}

	@Override
	public ArrayList positionSkill(String jobTitle) {
		
		String jobID;
		String status = null;
		String skillIds="''";
		ArrayList<String> list =new ArrayList<String>();
		
		try{
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();
			String query = "select S_ID from JOB_SKILLS where JOB_ID = (SELECT JOB_ID FROM JOB Where LOWER(TITLE) =LOWER('"+jobTitle+"'))";
			ResultSet rs = null;
			rs = statement.executeQuery(query);
			int index=0;
			while(rs.next()) {
				
					jobID = rs.getString(1);
					skillIds +=",'"+rs.getString(1).toUpperCase()+"'";
					index++;
				}
				
			
			if(index>0)
			{
				
				query = "Select S_TITLE from SKILLS where S_ID in ("+skillIds+")";
				//rs = null;
				//System.out.println(">>>>>>>>>>>>>>  "+query);
				rs = connection.createStatement().executeQuery(query);
				
				
				while(rs.next()){
					
					list.add(rs.getString(1));
						
				}
				
			
			}else{
				
				list.add("JOB Does Not Exist");
			}


			
		} catch (SQLException e) {
		
			e.printStackTrace();
		} finally {
		
			
			DbUtil.close(statement);
			DbUtil.close(connection);
		}
		
		return list;
		
	}

	@Override
	public ArrayList possiblePosition(String Skills) {
		
		
		List<String> skillsList = miscellaneousSupport.getList(Skills);
		ArrayList<String> jobList =new ArrayList<String>();
		
		
		String skill="''";
		for(String str:skillsList)
		{
			skill +=",'"+str.toLowerCase()+"'";
			System.out.println(str);
		}
		
		try{
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();
			String query = "select TITLE from JOB where JOB_ID in( select distinct(JOB_ID) from JOB_SKILLS where S_ID in (Select S_ID from SKILLS where LOWER(S_TITLE) in ("+skill+")))";
			ResultSet rs = null;
			rs = statement.executeQuery(query);
			int index=0;
			while(rs.next())
			{
				jobList.add(rs.getString(1));
				index++;
			}
			
			if(index==0)
			{
				
			
			}
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		} finally {
		
			
			DbUtil.close(statement);
			DbUtil.close(connection);
		}
		
		return jobList;
		
	}

	@Override
	public String addJob(String job,int pay, String type) {
		// TODO Auto-generated method stub
		String status="";
		try{
		String insertID="";
		connection = ConnectionFactory.getConnection();
		statement = connection.createStatement();
		String query = "SELECT * FROM JOB order by JOB_ID";
		ResultSet rs = null;
		rs = statement.executeQuery(query);
		
		while(rs.next())
		{
			insertID = rs.getString(1);
		}
		
		if(insertID != null)
		{
			insertID = miscellaneousSupport.generatedID(insertID);
			query = "insert into JOB values('"+insertID+"','"+job+"','"+pay+"','"+type+"')";
			statement.executeQuery(query);
			status = "New JOB added Successfully";
		}else
		{
			status = "JOB adding Failed";
		}
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
		
			DbUtil.close(statement);
			DbUtil.close(connection);
		}
		
		
		return status;
	}

}
