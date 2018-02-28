package org.emp;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="User_DB")
public class UserDatabase {
	@Id	
	private String empId;
	private String fName;
	private String lName;
	private String email;
	private long phone;
	@Temporal(TemporalType.DATE)
	private Date dob;
	private String designation;
	private String location;
	
	public UserDatabase() {
		super();
	}
	public UserDatabase(String empId, String fName, String lName, String email, long phone, Date dob, String desgination, String location) {
		super();
		this.empId = empId;
		this.fName = fName;
		this.lName = lName;
		this.email = email;
		this.phone = phone;
		this.dob = dob;
		this.designation = desgination;
		this.location = location;
	}
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
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
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	
	
}
