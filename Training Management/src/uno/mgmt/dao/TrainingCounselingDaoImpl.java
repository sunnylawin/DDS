package uno.mgmt.dao;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import uno.database.session.ConnectionFactory;
import uno.database.session.DbUtil;
import uno.mgmt.service.PersonnelSkillService;
import uno.mgmt.service.PersonnelSkillServiceImpl;
import uno.mgmt.service.TrainingCounselingService;
import uno.operations.support.MiscellaneousSupport;
import uno.personnel.service.PositionSkillMgmtServiceProxy;
import uno.vendor.service.CatalogServicesImplProxy;

public class TrainingCounselingDaoImpl implements TrainingCounselingDao{

	private Connection connection;
	private Statement statement;
	MiscellaneousSupport miscellaneousSupport = new MiscellaneousSupport();
	
	@Override
	public ArrayList missingSkill(String personName, String Job) {
		
		PositionSkillMgmtServiceProxy personnelInfoPROXY = new PositionSkillMgmtServiceProxy();
		PersonnelSkillService personnelSkillService = new PersonnelSkillServiceImpl();
		
		ArrayList<String> listResult = new ArrayList<String>();
		Object[] jobSkills = null;
		ArrayList<String>  personSkills = null;
		ArrayList<String>	temp = null;
		
			try {
				jobSkills = personnelInfoPROXY.positionSkill(Job);
			} catch (RemoteException e) {
				
				e.printStackTrace();
			} 
			if(jobSkills.length>0)
			{
				try{
					 
					personSkills = personnelSkillService.personSkill(personName);
					
				
					if(personSkills!=null)
					{
						
						for(int counter=0;counter<jobSkills.length;counter++)
						{
							if(personSkills.contains(jobSkills[counter]))
							{
								System.out.println(">>>>>>>>>>>>>>>>>   "+jobSkills[counter]);
								
							}
							else
							{
								listResult.add(""+jobSkills[counter]);
							}
						}
						
						
					}else
					{
						listResult.add("Employee Not Exist");
					}
		
					
				} catch (Exception e) {
				
					e.printStackTrace();
				} finally {
				
					
					DbUtil.close(statement);
					DbUtil.close(connection);
				}
			}else
			{
				listResult.add("Job Not Exist");
			}
		
			return listResult;
		}

	@Override
	public ArrayList recommendCourse(String personName, String Job) {

		CatalogServicesImplProxy psProxy = new CatalogServicesImplProxy();
		ArrayList<String> missingSkills = missingSkill(personName,Job);
		
		ArrayList<String> result =new ArrayList<String>();
		
		for(String str:missingSkills)
		{
			try {
				result.add(psProxy.recommendCourse(str.toLowerCase()).getCourseTitle());
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return result;
	}

	
	
	
	
}
