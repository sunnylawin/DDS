package uno.operations.support;

import javax.swing.JOptionPane;

public class Validation {
	boolean flag = true;
	
	public boolean isNull(String str)
	{
		if(str.length()==0 || str == null || str.equalsIgnoreCase("null"))
		{
			flag = false;
		}
		
		return flag;
		
	}
	
	
	public boolean isSalary(int num)
	{
		if(num < 0)
		{
			flag = false;
		}
		return flag;
	}
	

}
