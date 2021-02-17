package com.mersedes.dracmagicv3.jwt;

public class UsernameAndPasswordAuthenticationRequest {

	private String email; //username
	private String password;
	
	public UsernameAndPasswordAuthenticationRequest() {

	}

	public String getEmail() {
		return email;
	}

	public void setUsername(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
