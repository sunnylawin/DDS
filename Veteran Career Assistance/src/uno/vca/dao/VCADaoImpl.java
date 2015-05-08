package uno.vca.dao;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import uno.database.session.ConnectionFactory;
import uno.database.session.DbUtil;
import uno.operations.support.MiscellaneousSupport;
import uno.personnel.service.PositionSkillMgmtServiceProxy;
import uno.vca.service.VCAService;
import uno.vca.service.VCAServiceImpl;
import uno.vendor.service.CatalogServicesImplProxy;


public class VCADaoImpl implements VCADao{

	private Connection connection;
	private Statement statement;
	MiscellaneousSupport miscellaneousSupport = new MiscellaneousSupport();
	
	
	@Override
	public ArrayList courseSuggested(String personName, String Job) {
		
		Object[] jobSkills;
		 
		 ArrayList<String> personSkills = new ArrayList<String>();
		 ArrayList<String> missingSkill = new ArrayList<String>();
		 ArrayList<String> result = new ArrayList<String>();
		
		 if(personName!=null && Job!=null )
		 {
		
		 
			 PositionSkillMgmtServiceProxy positionproxy = new PositionSkillMgmtServiceProxy();
			 CatalogServicesImplProxy catalogProxy = new CatalogServicesImplProxy();
		 try {
			
			 personSkills=positionOpen(personName);
			 jobSkills = positionproxy.positionSkill(Job);
			 
			 
			 for(String str:personSkills)
			 {
				 System.out.println(">>>>Person Skills   "+str);
			 }
			 
			 for(Object o:jobSkills)
			 {
				 System.out.println(">>>>>>>Job Skills  "+o.toString());
			 }
			 
			 
			 for(int counter=0;counter<jobSkills.length;counter++)
			 {
				if(personSkills.contains(jobSkills[counter]))
				{
					//System.out.println(">>>>>>>>>>>>>>>>>   "+jobSkills[counter]);
					
				}
				else
				{
					//listResult.add(""+jobSkills[counter]);
					//System.out.println(">>>>>>>>>>>>>>>>>>   ");
					missingSkill.add(jobSkills[counter].toString());
				}
			
				for(String str:missingSkill)
				{
					System.out.println(">>>>>>>>>>>>>>   "+str);
					result.add(catalogProxy.recommendCourse(str).toString());
				}
			}
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		
		 }
		 return result;
	}
	@Override
	public ArrayList positionOpen(String personName) {
		
		ArrayList<String> listSkills = new ArrayList<String>();
		ArrayList<String> result = new ArrayList<String>();
		Object[] obj ;
		int index=0;
		
		try{
			
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();
			String query = "Select S_TITLE from SKILLS where S_ID in (select S_ID from VETEREN_SKILLS where V_ID = (select V_ID from VETERAN where LOWER(NAME) =LOWER('"+personName+"')))";
			ResultSet rs = null;
			String skills ="";
			rs = statement.executeQuery(query);
			
			while(rs.next()) 
			{
				skills +=rs.getNString(1)+",";
				index++;
			}
			
				PositionSkillMgmtServiceProxy proxy = new PositionSkillMgmtServiceProxy();
				try {
					obj = proxy.possiblePosition(skills);
					for(Object o:obj)
					{ 
						result.add(""+o);
					}
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
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
		
		
		return result;
		
	}
	@Override
	public ArrayList personSkills(String name) {
		
		
		ArrayList<String> listSkills = new ArrayList<String>();
		int index=0;
		
		try{
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();
			String query = "Select S_TITLE from SKILLS where S_ID in (select S_ID from VETEREN_SKILLS where V_ID = (select V_ID from VETERAN where LOWER(NAME) =LOWER('"+name+"')))";
			ResultSet rs = null;
			String skills ="";
			rs = statement.executeQuery(query);
			
			while(rs.next()) 
			{
				listSkills.add(rs.getNString(1));
				index++;
			}
				
			if(index==0){
				
				listSkills.add(" SKills Doesn't Exist");
			}
		
		} catch (SQLException e) {
		
			e.printStackTrace();
		} finally {
		
			
			DbUtil.close(statement);
			DbUtil.close(connection);
		}
		
		return listSkills;
	}
	
	

}
