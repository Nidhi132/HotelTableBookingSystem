package org.jss.controller;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class book {
	
	private int idbook;
	private String email;
	private java.sql.Date date;
	private String time_slot;
	private int nop;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getIdbook() {
		return idbook;
	}
	public void setIdbook(int idbook) {
		this.idbook = idbook;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public java.sql.Date getDate() {
		return date;
	}
	public void setDate(java.sql.Date date) {
		this.date = date;
	}
	public String getTime_slot() {
		return time_slot;
	}
	public void setTime_slot(String time_slot) {
		this.time_slot = time_slot;
	}
	public int getNop() {
		return nop;
	}
	public void setNop(int nop) {
		this.nop = nop;
	}

	public book(int idbook, String email, Date date, String time_slot, int nop) {
		super();
		this.idbook = idbook;
		this.email = email;
		this.date = date;
		this.time_slot = time_slot;
		this.nop = nop;
	}

	public book() {
		super();
	}

	public book(String email, Date date, String time_slot, int nop) {
		super();
		this.email = email;
		this.date = date;
		this.time_slot = time_slot;
		this.nop = nop;
	}
	
	@Override
	public String toString() {
		return "book [idbook=" + idbook + ", email=" + email + ", date=" + date + ", time_slot=" + time_slot + ", nop="
				+ nop + "]";
	}
	
	
}
