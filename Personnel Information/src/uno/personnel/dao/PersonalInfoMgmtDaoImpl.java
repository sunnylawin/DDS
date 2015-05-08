package uno.personnel.dao;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

import uno.database.session.ConnectionFactory;
import uno.database.session.DbUtil;
import uno.object.vo.ContactInfo;
import uno.operations.support.MiscellaneousSupport;

public class PersonalInfoMgmtDaoImpl implements PersonalInfoMgmtDao {

	private Connection connection;
	private Statement statement;

	public PersonalInfoMgmtDaoImpl() {
	}

	
	@Override
	public ContactInfo personContactInfo(String name) {

		ContactInfo objContact = new ContactInfo();

		try {

				connection = ConnectionFactory.getConnection();
				statement = connection.createStatement();
				connection = ConnectionFactory.getConnection();
				statement = connection.createStatement();
				String query = "SELECT * FROM PERSON Where LOWER(NAME) =" + "'"+ name + "'";
				ResultSet rs = null;
	
				statement = connection.createStatement();
				rs = statement.executeQuery(query);
				ResultSetMetaData rsmd = rs.getMetaData();

			 int index =0;  
				
			while (rs.next()) {
				
				objContact.setPerson_Id(rs.getString("PERSON_ID"));
				objContact.setName(rs.getString("NAME"));
				objContact.setContact(rs.getString("CONTACT"));
				objContact.setAddress(rs.getString("ADDRESS"));
				objContact.setGender(rs.getString("GENDER"));
				objContact.setAge(rs.getString("AGE"));
				index++;
				// System.out.println("Result set >>>>>>>  "+objContact.toString());
			}
			
			if(index==0)  // this is to check whether person exist or not
			{
				
				objContact.setName("Person Doesn't Exist");
				
			}
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// DbUtil.close(rs);
			DbUtil.close(statement);
			DbUtil.close(connection);
		}

		return objContact;
	}
	
	
	@Override
	public ArrayList getpersonPositionInfo(String name) {

		ArrayList<String> list = new ArrayList<String>();
		String personID ="";

		try {
				connection = ConnectionFactory.getConnection();
				statement = connection.createStatement();
				String query = "SELECT PERSON_ID FROM PERSON Where NAME =" + "'"+ name + "'";
				ResultSet rs = null;
				rs = statement.executeQuery(query);
				ResultSetMetaData rsmd = rs.getMetaData();
			
			
			if(rs.next() && rs.getString(1)!=null)
			{
				personID= rs.getString(1);
				query = "select JOB_ID from POSITION where PERSON_ID='"+personID+"'";
   				rs = statement.executeQuery(query);
   				String job_Ids = "''";
				while(rs.next() && rs.getString(1)!=null)
				{
					job_Ids += ",'"+rs.getString(1)+"'";
				}
						
					query = "Select TITLE from JOB where JOB_ID in ("+job_Ids+")";
					rs = statement.executeQuery(query);
					int index =0;
					while (rs.next()) 
					{
						String temp="";
						temp = rs.getString(1);
						list.add(temp);
						index++;
					}if(index==0)
					{
						list.add("Employee has No JOBS");
					}
		
			}else{
			list.add("Employee Not Exist");
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DbUtil.close(statement);
			DbUtil.close(connection);
		}

		return list;
	}


	@Override
	public String personSeniorityInfo(String name) {

		MiscellaneousSupport datecomparision = new MiscellaneousSupport();
		String joiningDate = "";
		String perID ="";
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();
			String query = "SELECT PERSON_ID FROM PERSON Where LOWER(NAME) =" + "'"+ name.toLowerCase() + "'";
			ResultSet rs = null;
			rs = statement.executeQuery(query);
			ResultSetMetaData rsmd = rs.getMetaData();
		
		
		if(rs.next() && rs.getString(1)!=null)
		{
			perID= rs.getString(1);	
			query = "select Min(DOJ) from POSITION where PERSON_ID= '"+ perID + "'";
			rs = null;
			statement = connection.createStatement();
			rs = statement.executeQuery(query);
			int count = 0;
			while (rs.next() && rs.getNString(1)!=null) {

				try {
					joiningDate = datecomparision.getDatedifference(""
							+ rs.getNString(1));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				count++;
				
			}if(count==0)
			{
				joiningDate ="Employee has No Job Seniority";
			}

		} else{
			joiningDate ="Employee Not Exist";
		}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// DbUtil.close(rs);
			DbUtil.close(statement);
			DbUtil.close(connection);
		}

		return joiningDate;
	}

}
