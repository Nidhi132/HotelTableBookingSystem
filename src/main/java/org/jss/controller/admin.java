package org.jss.controller;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class admin {

	@Override
	public String toString() {
		return "admin [name=" + name + ", password=" + password + "]";
	}

	private String name;
	private String password;
	
	@Id
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public admin(String name, String password) {
		super();
		this.name = name;
		this.password = password;
	}
	
	public admin() {
		super();
	}
	
}
