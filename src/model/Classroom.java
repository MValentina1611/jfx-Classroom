package model;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.image.Image;
public class Classroom {

	private List<UserAccount> userAccountList;
	public static Image profilePhoto;  
	
	public Classroom()
	{
		userAccountList = new ArrayList<UserAccount>();
		userAccountList.add(new UserAccount("username","password","gender","career","birthday","browser", profilePhoto));		
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
	
	public int userPos(String username,String password) 
	{
        int pos=-1;
        
        for(int i=0; i< userAccountList.size();i++) 
        {
            if(username.equals(userAccountList.get(i).getUsername()) && 
            		password.equals(userAccountList.get(i).getPassword())) 
            {
                pos=i;
            }
        }
        
        return pos;

    }
	
	
}
