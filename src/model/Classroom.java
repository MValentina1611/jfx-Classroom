package model;

import java.util.ArrayList;
import java.util.List;
public class Classroom {

	private List<UserAccount> userAccountList;
	
	public Classroom()
	{
		userAccountList = new ArrayList<UserAccount>();
		userAccountList.add(new UserAccount("username","password","gender","career","birthday","browser", "urlProfilePhoto"));		
	}
			
	public List<UserAccount> getUserAccountList() {
		return userAccountList;
	}


	public boolean  add( UserAccount newUserAccount )
	{
		if( userAccountList.add( newUserAccount ) )
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean verifyUser( String userNI, String passwordI )
	{
		boolean match = false;
		
		for(int i = 0; i < userAccountList.size(); i++ )
		{
			if ( ( userAccountList.get(i).getUsername().equals(userNI) ) &&  
					userAccountList.get(i).getPassword().equals(passwordI) )
			{
				match = true;
			}	
		}		
		return match; 
	}
	
	public boolean verifyFullFields(String [] userInfo )
	{ 
		boolean incompleteFields = false; 
		
		for(int i = 0; i < userInfo.length && !incompleteFields; i++ )
		{
			if( userInfo[i] == null ) 
			{
				incompleteFields = true;
			}
		}
		
		return incompleteFields;
	}
	
}
