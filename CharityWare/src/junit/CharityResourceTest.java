package junit;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import ConnectionManager.DatabaseManager;
import RESTdataEntities.Charity;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.instanceOf;

public class CharityResourceTest {
	Charity charityObj;
	@Before
	public void init(){
		charityObj = new Charity();
		charityObj.setAccountNo("123456");
		charityObj.setAddressLine1("8 Wakley Street");
		charityObj.setCharityDescription("I CAN is the charity that helps children with speech and language difficulties across the UK.");
		charityObj.setCharityID(15);
		charityObj.setCharityName("I Can");
		charityObj.setEmail("info@ican.co.uk");
		charityObj.setPhone("07894688526");
		charityObj.setUserId(12);
		charityObj.setRegistrationNo("210031");
		charityObj.setIsVerified(true);
		charityObj.setIsActive(true);
	}
	
	
	
	@Test
	public void test(){
		for(int i=1;i<20;i++){
		try {
			Object obj =null;
			obj = DatabaseManager.getCharity(i);
			if(null!=obj){
				System.out.println(obj);
				assertThat(obj,instanceOf(Charity.class));
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}
	
	@Test
	public void test2(){		
		try {
			Charity obj = DatabaseManager.getCharity(15);
			
			assertEquals("Incorrect Account No.",charityObj.getAccountNo(),obj.getAccountNo());
			assertEquals("Incorrect Address Line 1",charityObj.getAddressLine1(),obj.getAddressLine1());
			assertEquals("Incorrect Charity Description",charityObj.getCharityDescription(),obj.getCharityDescription());
			assertEquals("Incorrect Charity Id",charityObj.getCharityID(),obj.getCharityID());
			assertEquals("Incorrect Charity Name",charityObj.getCharityName(),obj.getCharityName());
			assertEquals("Incorrect Email Id",charityObj.getEmail(),obj.getEmail());
			assertEquals("Incorrect Phone Number",charityObj.getPhone(),obj.getPhone());
			assertEquals("Incorrect User Id",charityObj.getUserId(),obj.getUserId());
			assertEquals("Incorrect Registration No",charityObj.getRegistrationNo(),obj.getRegistrationNo());
			assertEquals("Not Verified",charityObj.getIsVerified(),obj.getIsVerified());
			assertEquals("Not Active",charityObj.getIsActive(),obj.getIsActive());			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	
	@Test
	public void test3(){
		List<Charity> chs = new ArrayList<Charity>();
        try {
        chs = DatabaseManager.readCharityTable();
        assertNotNull("No charities present", chs);
        for(int i=0;i<chs.size();i++){
        	assertThat(chs.get(i),instanceOf(Charity.class));
        }
        }
        catch (Exception e)
        {
        	e.printStackTrace(); 
        }
	}
	
	
	@Test
	public void test4(){
		Charity ch =new Charity();
		ch.setAccountNo("654321");
		ch.setAddressLine1("125 Bond Street");
		ch.setCharityDescription("Test Description");
		ch.setCharityName("Test Charity");
		ch.setEmail("info@test.co.uk");
		ch.setPhone("07894688526");
		ch.setUserId(33);
		ch.setRegistrationNo("210033");
		ch.setIsVerified(true);
		ch.setIsActive(true);
		ch.setAddressLine2("Test");
		ch.setLocation("Test");
		ch.setPostCode("NW16XX");
		Date d=new Date();
		ch.setTimestamp(new Timestamp(d.getTime()));
		ch.setConnectionString("Test");
		
		try{
            DatabaseManager.addCharity(ch);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
		
		
		try {
			List<Charity> chs = new ArrayList<Charity>();
			Charity ob=new Charity();
	        chs = DatabaseManager.readCharityTable();
	        assertNotNull("No charities present", chs);
	        for(int i=0;i<chs.size();i++){
	        	ob=null;
	        	ob=chs.get(i);
	        	if(ch.getCharityName().equalsIgnoreCase(ob.getCharityName())){
	        		break;
	        	}
	        }
			
			
			Charity obj = DatabaseManager.getCharity(ob.getCharityID());
			
			assertEquals("Incorrect Account No.",ch.getAccountNo(),obj.getAccountNo());
			assertEquals("Incorrect Address Line 1",ch.getAddressLine1(),obj.getAddressLine1());
			assertEquals("Incorrect Charity Description",ch.getCharityDescription(),obj.getCharityDescription());
			assertEquals("Incorrect Charity Id",ch.getCharityID(),obj.getCharityID());
			assertEquals("Incorrect Charity Name",ch.getCharityName(),obj.getCharityName());
			assertEquals("Incorrect Email Id",ch.getEmail(),obj.getEmail());
			assertEquals("Incorrect Phone Number",ch.getPhone(),obj.getPhone());
			assertEquals("Incorrect User Id",ch.getUserId(),obj.getUserId());
			assertEquals("Incorrect Registration No",ch.getRegistrationNo(),obj.getRegistrationNo());
			assertEquals("Not Verified",ch.getIsVerified(),obj.getIsVerified());
			assertEquals("Not Active",ch.getIsActive(),obj.getIsActive());			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		
	}

}
