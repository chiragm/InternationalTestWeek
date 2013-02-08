package junit;

import static org.junit.Assert.*;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;


import hibernateEntities.User;
import hibernateEntities.UserType;
import hibernateManagers.CharityLoginManager;
import hibernateManagers.UserManager;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CharityLoginTest {

	User user;
	
	
	@Before
	public void init() {
		user = new User();
		user.setUserName("amartin");
		user.setUser_id(3);
		user.setIsActive(true);
		user.setSalt("Y4qeEqBlJk");
		user.setUserEmail("amartin@ucl.ac.uk");
		user.setDateCreated(new Date(1));
		user.setUserPassword("456");
		UserType type = new UserType();
		type.setDescription("");
		type.setTimestamp(new Timestamp(1));
		type.setIsActive(true);
		type.setUserType("Charity Worker");
		type.setUserTypeId(2);
		user.setUserTypeId(type);
	}
	@Test
	public void test() {
		ArrayList<User> users = UserManager.getUsersFromName("amartin");
		assertEquals("Returned more than one user", 1, users.size());
		User ruser = users.get(0);
		assertEquals("Incorrect user e-mail",user.getUserEmail(),ruser.getUserEmail());
		assertNotNull("User has no user type attached",user.getUserTypeId());
		assertEquals("Incorrect user type attached to user",2,user.getUserTypeId().getUserTypeId().intValue());
		
	}
	
	@After
	public void clean() {
		user = null;
	}

}
