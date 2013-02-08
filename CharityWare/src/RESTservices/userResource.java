package RESTservices;

import java.sql.SQLException;

import javax.annotation.Resource;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
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

import ConnectionManager.DatabaseManager;
//import RESTdataEntities.UsersDatabaseAdapter;
import RESTdataEntities.userEntity;
import RESTdataEntities.usersEnum.UsersEnum;

public class userResource {

	  @Context
	  UriInfo uriInfo;
	  @Context
	  Request request;
	  String id;
	  public userResource(UriInfo uriInfo, Request request, String id) {
	    this.uriInfo = uriInfo;
	    this.request = request;
	    this.id = id;
	  }
	  
	  //for Application
	  @GET
	  @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	  public userEntity getUser() {
		  userEntity user = UsersEnum.instance.getModel().get(id);
	    if(user==null)
	      throw new RuntimeException("Get: user with ID " + id +  " not found");
	    return user;
	  }
		
	  //for Browser
	  @GET
	  @Produces(MediaType.TEXT_XML)
	  public userEntity getUserBrowser() {
		  userEntity user = UsersEnum.instance.getModel().get(id);
	    if(user==null)
	      throw new RuntimeException("Get: user with ID " + id +  " not found");
	    return user;
	  }
	  
	  
		@PUT
		@Consumes(MediaType.APPLICATION_XML)
		  public Response putUsers(userEntity user) throws SQLException {
			int num=10;
			Response res;
			user.setActive(0);
			num = DatabaseManager.editUser(user);
			System.out.println(num);
			res = Response.created(uriInfo.getAbsolutePath()).build();
		    return res;
		  }
		
	
		 @DELETE
		  public void deleteUser() {
			 userEntity user = new userEntity();
			 user.setUser_Id(Integer.valueOf(id));
			 DatabaseManager.deleteUser(user);
		      throw new RuntimeException("Delete: Todo with " + id +  " not found");
		  }
		
		  
	
	  
}
