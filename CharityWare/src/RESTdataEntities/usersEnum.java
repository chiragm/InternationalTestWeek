package RESTdataEntities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import ConnectionManager.DatabaseManager;

public class usersEnum {
	
	public enum UsersEnum {
		   instance;
		  
		  private Map<String, userEntity> content = new HashMap<String, userEntity>();
		  
		  private UsersEnum() {
			  
		    ArrayList<userEntity> result = DatabaseManager.retrieveAllNames();
		    for (int i = 0; i < result.size(); i++){
		    	content.put(String.valueOf(result.get(i).getUser_Id()), result.get(i));
		    }
		  }
		  public Map<String,userEntity> getModel(){
			  getUsersEnum();
		    return content;
		  }
		private void getUsersEnum() {
			
			ArrayList<userEntity> result = DatabaseManager.retrieveAllNames();
		    for (int i = 0; i < result.size(); i++){
		    	content.put(String.valueOf(result.get(i).getUser_Id()), result.get(i));
		    }
		  
		} 
	}
}
