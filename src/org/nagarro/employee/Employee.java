package org.nagarro.employee;

import java.util.Date;

public class Employee {
	
    private long ecode;
	
	private String ename;
	
	private String location;
	
	public Employee() {
		
	}

	private String email;
	
	private Date edob ;
	
	public Employee(String ename, String location, String email, Date edob) {
		super();
		this.ename = ename;
		this.location = location;
		this.email = email;
		this.edob = edob;
	}

	public long getEcode() {
		return ecode;
	}

	public void setEcode(long ecode) {
		this.ecode = ecode;
	}


	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getEdob() {
		return edob;
	}

	public void setEdob(Date edob) {
		this.edob = edob;
	}
	
}

