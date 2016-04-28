package model;

import java.util.Map;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class User {
	@XmlElement(name = "id")
	private long id;
	@XmlElement(name = "name")
	private String name;
	@XmlElement(name = "email")
	private String email;
	@XmlElement(name = "password")
	private String password;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean validate_password(Map<String, String> messages,String pass){
		if(!this.password.equals(pass)) {
			messages.put("error", "Las contraseñas no coinciden");
			return false;
		} 
		return true;
	}

}
