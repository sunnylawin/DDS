package uno.personnel.dao;

import java.util.ArrayList;
import java.util.Date;

import uno.object.vo.ContactInfo;

public interface PersonalInfoMgmtDao {
		
	public ContactInfo personContactInfo(String name);
	public ArrayList  getpersonPositionInfo(String name);
	public String personSeniorityInfo(String name);
	
}
