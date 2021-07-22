package org.jss.controller;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity 
public class user {
	
	private String name;
	private String email;
	private long phone;
	private String password;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Id
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public user(String name, String email, long phone, String password) {
		super();
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.password = password;
	}
	public user(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
	public user() {
		super();
	}
	
	

}
