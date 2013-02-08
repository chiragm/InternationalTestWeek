package staticResources;

import systemDBHibernateEntities.User;

public class DummyUser {
	User user = new User();
	
	public static String retrieveUser(String name){
		if (name.matches(".+")){
			return "the name contains no numbers";
		}
		return "name number assertion failed";
	}

}
