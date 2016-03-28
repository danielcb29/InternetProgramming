package model;

import java.util.Map;

public class User {
	private long id;
	private String name;
	private String email;
	private String password;
	
	public boolean validate_password(Map<String, String> messages,String pass){
		if(!this.password.equals(pass)) {
			messages.put("error", "Las contraseñas no coinciden");
			return false;
		} 
		return true;
	}
	
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
	
	//Metodos adicionales
	public String karma(){
		return "20k karmoso";
	}

}
