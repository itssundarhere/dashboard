package com.sample.web;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "data")
public class Details {
	@Column
	@Id
	String email;
	@Column
	String password;	
	@Column
	String fullname;

	public void setPassword(String password) {
		this.password = password;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

}