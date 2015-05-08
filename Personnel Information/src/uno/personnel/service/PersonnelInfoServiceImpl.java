package uno.personnel.service;

import java.util.ArrayList;
import java.util.Date;

import javax.jws.WebService;

import uno.object.vo.ContactInfo;
import uno.personnel.dao.PersonalInfoMgmtDao;
import uno.personnel.dao.PersonalInfoMgmtDaoImpl;


@WebService(name="PersonalInfoMgmtService")
public class PersonnelInfoServiceImpl implements PersonnelInfoService{


	PersonalInfoMgmtDao personalInfoMgmtDao= new PersonalInfoMgmtDaoImpl();
	 String result="";
	public ContactInfo personContactInfo(String name) {
		
		System.out.println("####### Getting Person Contact Information ############# ");
		
		ContactInfo objContactInfo= new ContactInfo();
		
		objContactInfo = personalInfoMgmtDao.personContactInfo(name);
		
		return objContactInfo;
	}

	
	public ArrayList  personPositionInfo(String name) {

		ArrayList<String> list = new ArrayList<String>();
		System.out.println("####### Getting Person Position Information ############# ");
		list = personalInfoMgmtDao.getpersonPositionInfo(name);
        
	/*	for (String element : list) {
		    System.out.println(">>>>>>>>  Positions >>>"+element);
		}*/
		
		return list;
	}

	
	public String personSeniorityInfo(String name) {
		
		String seniority ="";
		System.out.println("####### Getting Person Seniority Information ############# ");
		// TODO Auto-generated method stub
		seniority = personalInfoMgmtDao.personSeniorityInfo(name);
		return seniority;
	}

}
