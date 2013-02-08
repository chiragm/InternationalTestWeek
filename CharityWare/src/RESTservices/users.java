package RESTservices;


//import java.util.ArrayList;


import hibernateEntities.HibernateUtil;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.xml.bind.JAXBElement;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import staticResources.PasswordEncryption;

//import ConnectionManager.*;

import ConnectionManager.DatabaseManager;
import RESTdataEntities.*;
import RESTdataEntities.usersEnum.UsersEnum;

@Path("/users")
public class users {
	@Context
	  UriInfo uriInfo;
	  @Context
	  Request request;
	
		//for an application requesting the service	
		@GET
		@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
		public ArrayList<userEntity> resultToXML() {
			userEntitys people= new userEntitys();
		    people.setUsers(DatabaseManager.retrieveAllNames());
			
		    return DatabaseManager.retrieveAllNames();
			//return people;
		}
		
		//for the web browser
		@GET
		@Produces(MediaType.TEXT_XML)
		public userEntitys browserToXML() {
			userEntitys people= new userEntitys();
		    people.setUsers(DatabaseManager.retrieveAllNames());
			
			return people;
		}
		
		// returns the number of users registered on the charityDB
		@GET
		  @Path("count")
		  @Produces(MediaType.TEXT_PLAIN)
		  public String getCount() {
		    int count = UsersEnum.instance.getModel().size();
		    return String.valueOf(count);
		  }
	
		  @POST
		  //@Produces(MediaType.APPLICATION_XML)
		  @Consumes(MediaType.APPLICATION_FORM_URLENCODED)//wrong consume
		  //no output = void
		  public void newUser(@FormParam("Username") String username,
		      @FormParam("User_Email")  String userEmail,
		      @FormParam("User_Password") String user_password,
		      @FormParam("User_Type_Id") int userTypeId,
		      @FormParam("isActive") int isactive
		      /*@Context HttpServletResponse servletResponse*/) throws IOException {
			  
			  //Session session = HibernateUtil.getSessionFactory().openSession();
			  //Transaction tx = null;
			  try{
				  //tx = session.beginTransaction();
				  userEntity user = new userEntity();
				  user.setName(username);
				  user.setUserEmail(userEmail);
				  String salt = PasswordEncryption.createSalt();
				  String hashedPW = PasswordEncryption.encryptPassword(user_password, salt);
				  user.setPassword(hashedPW);
				  user.setSalt(salt);
				  user.setActive(isactive);
				  user.setUser_Type_Id(userTypeId);
				  int num = DatabaseManager.addUser(user);
				  System.out.println(num);
				  
				 // session.save(user);
				  //tx.commit();
				  
			  }catch(Exception e) {
	        
				  e.printStackTrace(); 
			  }finally {
				 // session.close(); 
			  }
			  //System.out.println(user.getName());
			    	//
			    	//
		  }
		
		 @Path("{users}")
		  public userResource getUser(@PathParam("users") String id) {
		    return new userResource(uriInfo, request, id);
		  }

		
}
