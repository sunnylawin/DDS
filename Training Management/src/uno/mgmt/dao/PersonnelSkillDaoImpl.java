package uno.mgmt.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import uno.database.session.ConnectionFactory;
import uno.database.session.DbUtil;
import uno.operations.support.MiscellaneousSupport;

public class PersonnelSkillDaoImpl implements PersonnelSkillDao{

	private Connection connection;
	private Statement statement;
	MiscellaneousSupport miscellaneousSupport = new MiscellaneousSupport();
	
	
	/* Returns the list of skills a person has*/
	@Override
	public ArrayList personSkill(String personName) {
		
		ArrayList<String> listSkills = new ArrayList<String>();
		int index=0;
		
		try{
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();
			String query = "Select S_TITLE from SKILLS where S_ID in (select S_ID from PERSON_SKILLS where P_ID = (select P_ID from PERSON where LOWER(NAME) =LOWER('"+personName+"')))";
			ResultSet rs = null;
			rs = statement.executeQuery(query);
			
			while(rs.next()) 
			{
				listSkills.add(rs.getString(1));
				index++;
			}
			
			if(index==0){
				
				listSkills.add("Doesn't Exist");
			}


			
		} catch (SQLException e) {
		
			e.printStackTrace();
		} finally {
		
			
			DbUtil.close(statement);
			DbUtil.close(connection);
		}
		
		return listSkills;
		
	}

	/* Returns the list of Certificates a person has*/
	@Override
	public ArrayList personCertificate(String personName) {
		
		ArrayList<String> listCertificats = new ArrayList<String>();
		int index=0;
		
		
		try{
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();
			
			
			String query = "Select C_TITLE from CERTIFICATE where C_ID in (select C_ID from PERSON_CERTIFICATES where P_ID = (select P_ID from PERSON where LOWER(NAME) =LOWER('"+personName+"')))";
			ResultSet rs = null;
			rs = statement.executeQuery(query);
			
			while(rs.next()) 
			{
				listCertificats.add(rs.getString(1));
				index++;
			}
			
			if(index==0){
				
				listCertificats.add("Does Not Exist");
			}


			
		} catch (SQLException e) {
		
			e.printStackTrace();
		} finally {
		
			
			DbUtil.close(statement);
			DbUtil.close(connection);
		}
		
		return listCertificats;
	}

	@Override
	public ArrayList skillCall(String skill) {
		ArrayList<String> skillPersons = new ArrayList<String>();
		
		
		System.out.println(">>>>>>>>>>>>>>>>>>>>   "+skill);
		try{
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();
			
			String query = "Select NAME from PERSON where P_ID in(select distinct(P_ID) from PERSON_SKILLS where S_ID in (select S_ID from SKILLS where LOWER(S_TITLE) in ('"+skill.toLowerCase()+"')))";
			ResultSet rs = null;
			rs = statement.executeQuery(query);
			int index=0;
			while(rs.next()) 
			{
				skillPersons.add(rs.getString(1));
				index++;
			}
			
			if(index==0){
				
				skillPersons.add("Does Not Exist");
			}


			
		} catch (SQLException e) {
		
			e.printStackTrace();
		} finally {
		
			
			DbUtil.close(statement);
			DbUtil.close(connection);
		}
		
		return skillPersons;
	}

	/* Returns the list of Person having a certificate*/
	@Override
	public ArrayList certificateCall(String certificate) {
		
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>   "+certificate);
		ArrayList<String> listPersons = new ArrayList<String>();
		int index=0;
		
		try{
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();
			String query = "Select NAME from PERSON where P_ID in(select distinct(P_ID) from PERSON_CERTIFICATES where C_ID in (select C_ID from CERTIFICATE where C_TITLE in ('"+certificate.toUpperCase()+"')))";
			ResultSet rs = null;
			rs = statement.executeQuery(query);
			
			while(rs.next()) 
			{
				listPersons.add(rs.getString(1));
				index++;
			}
			
			if(index==0){
				
				listPersons.add("Does Not Exist");
			}


			
		} catch (SQLException e) {
		
			e.printStackTrace();
		} finally {
		
			
			DbUtil.close(statement);
			DbUtil.close(connection);
		}
		
		return listPersons;
	}
	

}
