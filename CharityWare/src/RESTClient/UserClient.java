package RESTClient;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import hibernateEntities.User;

import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import org.codehaus.jackson.jaxrs.JacksonJsonProvider;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.representation.Form;

public class UserClient {
	
	public static User get(String parameter){
		ClientConfig clientConfig = new DefaultClientConfig();
		clientConfig.getClasses().add(JacksonJsonProvider.class);
		Client Myclient = Client.create(clientConfig);
		ClientResponse clientresponse = Myclient.resource("http://localhost:8080/CharityWare/REST/")
				.path("userService").path("userName").path(parameter)
				.accept(MediaType.APPLICATION_JSON).type(MediaType.APPLICATION_JSON).
				get(ClientResponse.class);
		return clientresponse.getEntity(User.class);
	}
	
	public static Map<Integer,List<String>> getForms(){
		ClientConfig clientConfig = new DefaultClientConfig();
		clientConfig.getClasses().add(JacksonJsonProvider.class);
		Client client = Client.create(clientConfig);
		ClientResponse clientresponse = client.resource("http://localhost:8080/CharityWare/REST/userService/").path("json/users/forms/").
				accept(MediaType.APPLICATION_JSON).type(MediaType.APPLICATION_JSON).
				get(ClientResponse.class);
		return clientresponse.getEntity(new GenericType<Map<Integer,List<String>>>(){});
	}

	public static void addUser(Form form){
		ClientConfig config = new DefaultClientConfig();
	    Client client = Client.create(config);
	    WebResource service = client.resource(getBaseURI());
	    
		service.path("REST").path("users")
        .type(MediaType.APPLICATION_FORM_URLENCODED)
        .post(ClientResponse.class, form);
	}
	
	private static URI getBaseURI() {
	    return UriBuilder.fromUri("http://localhost:8080/CharityWare").build();
	  }
}
