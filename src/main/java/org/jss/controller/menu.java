package org.jss.controller;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class menu {

	public menu() {
		super();
	}

	private int id;
	private String name;
	private float cost;
	
	@Id
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public float getCost() {
		return cost;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}
	
	public menu(int id, String name, float cost) {
		super();
		this.id = id;
		this.name = name;
		this.cost = cost;
	}
	
	@Override
	public String toString() {
		return "menu [id=" + id + ", name=" + name + ", cost=" + cost + "]";
	}
	
	
}
