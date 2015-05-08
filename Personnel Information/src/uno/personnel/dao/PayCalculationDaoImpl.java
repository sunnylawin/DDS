package uno.personnel.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import uno.database.session.ConnectionFactory;
import uno.database.session.DbUtil;

public class PayCalculationDaoImpl implements PayCalculationDao{
	
	private Connection connection;
	private Statement statement;
	
	
	public PayCalculationDaoImpl() {
	}

	@Override
	public String personPayable(String name) {
		// TODO Auto-generated method stub
		String amountDue=null;
		int payRoll =0;
		try {
			
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();
			String query = "select JOB_ID from POSITION where PAY_STATUS ='DUE' and PERSON_ID = (select PERSON_ID from PERSON where NAME='"+name+"')";
			ResultSet rs = null;

			statement = connection.createStatement();
			rs = statement.executeQuery(query);
			int index =0;
			while (rs.next()) {
				
				
				query = "select PAY_ROLL from JOB where JOB_ID='"+rs.getString(1)+"'";
				rs = statement.executeQuery(query);
				if(rs.next()){
				payRoll =+Integer.parseInt(rs.getNString(1));
				amountDue = "";
				
				}else if(amountDue==null){
					amountDue ="No Due";
				}
				index++;
				// System.out.println("Result set >>>>>>>  "+objContact.toString());
			}
			if(index==0)
			{
				amountDue = "Employee Not Exist";
			}
			if(payRoll>0 && amountDue!=null)
			{
				amountDue =""+payRoll;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// DbUtil.close(rs);
			DbUtil.close(statement);
			DbUtil.close(connection);
		}
		
		return amountDue;
	}

	@Override
	public List<String> makePayroll() {
		// TODO Auto-generated method stub
		
		List<String> list = new ArrayList<String>();
		String amountDue=null;
		int payRoll =0;
		
		try {
			
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();
			String query = "select NAME from PERSON where PERSON_ID in (select PERSON_ID from position where PAY_STATUS ='DUE')";
			ResultSet rs = null;

			statement = connection.createStatement();
			rs = statement.executeQuery(query);
			int index =0;
			while (rs.next()) {
				String temp="";
				temp=personPayable(rs.getString(1));
				list.add(rs.getString(1)+":"+temp);
				index++;
			}
			if(index==0)
			{
				list.add("No Dues");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// DbUtil.close(rs);
			DbUtil.close(statement);
			DbUtil.close(connection);
		}
		
		return list;
	}

}
