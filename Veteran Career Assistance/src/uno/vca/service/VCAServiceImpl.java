package uno.vca.service;

import java.util.ArrayList;
import java.util.Date;

import javax.jws.WebService;

import uno.operations.support.MiscellaneousSupport;
import uno.vca.dao.VCADao;
import uno.vca.dao.VCADaoImpl;


@WebService(name="VCAService")
public class VCAServiceImpl implements VCAService{

	VCADao vcaDao = new VCADaoImpl();
	MiscellaneousSupport miscellaneousSupport = new MiscellaneousSupport();
	@Override
	public ArrayList courseSuggested(String personName, String courseName) {

		ArrayList<String> list = new ArrayList<String>();
		
		if(personName!=null && courseName!=null)
		{
			list = vcaDao.courseSuggested(personName, courseName);
		}else
		{
			list.add("Values cannot be null");
		}
		
		
		return list;
	
	}

	@Override
	public ArrayList positionOpen(String name) {
		

		
		ArrayList<String> list = new ArrayList<String>();
		if(name!=null)
		{
			list = vcaDao.positionOpen(name);
		}else
		{
			list.add("Values cannot be null");
		}
		
		
		return list;
	
		
	}

	@Override
	public ArrayList personSkills(String name) {
		
		ArrayList<String> list = new ArrayList<String>();
		if(name!=null)
		{
			list = vcaDao.personSkills(name);
		}else
		{
			list.add("Values cannot be null");
		}
		
		
		return list;
		
	}
	


}
