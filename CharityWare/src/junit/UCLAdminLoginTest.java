package junit;

import static org.junit.Assert.*;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;

import hibernateEntities.User;
import hibernateEntities.UserType;
import hibernateManagers.UserManager;

import org.junit.Before;
import org.junit.Test;

public class UCLAdminLoginTest {

	User user;
	
	@Before
	public void init(){
		user = new User();
		user.setUserName("lchirchop");
		user.setUser_id(1);
		user.setIsActive(true);
		user.setSalt("Y4qeEqBlJk");
		user.setUserEmail("lchirchop@ucl.ac.uk");
		user.setDateCreated(new Date(1));
		user.setUserPassword("123");
		UserType type = new UserType();
		type.setDescription("");
		type.setTimestamp(new Timestamp(1));
		type.setIsActive(true);
		type.setUserType("UCL Administrator");
		type.setUserTypeId(1);
		user.setUserTypeId(type);
	}
	
	@Test
	public void test() {
		ArrayList<User> users = UserManager.getUsersFromName("lchirchop");
		assertEquals("Returned at least one user", true, users.size()>0);
		User ruser = users.get(0);
		assertEquals("Incorrect user e-mail",user.getUserEmail(),ruser.getUserEmail());
		assertNotNull("User has no user type attached",user.getUserTypeId());
		assertEquals("Incorrect user type attached to user",1,user.getUserTypeId().getUserTypeId().intValue());
		assertEquals("Incorrect user id",ruser.getUser_id(),user.getUser_id());
	}
	
	

}
