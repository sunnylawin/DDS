package uno.personnel.service;

import java.sql.Connection;
import java.sql.Statement;
import java.util.List;

import javax.jws.WebService;

import uno.personnel.dao.PayCalculationDao;
import uno.personnel.dao.PayCalculationDaoImpl;


@WebService(name="PayCalculationService")
public class PayCalculationServiceImpl implements PayCalculationService{
	
	
	PayCalculationDao payCalculationDao = new PayCalculationDaoImpl();

	@Override
	public String personPayable(String name) {
		// TODO Auto-generated method stub
		String amountDue  = "";
		amountDue = payCalculationDao.personPayable(name);
		
		return amountDue;
	}


	@Override
	public List<String> makePayroll() {
		
		List<String> list = payCalculationDao.makePayroll();
		return list;
	}

}
