package RESTdataEntities;

import javax.xml.bind.annotation.*;


@XmlRootElement
public class UserLoginEntity {
	String username;
	String password;
	String salt;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}


	
	
}


