package com.contacts.contacts.manager.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;



@Entity
@Table(name="UserTable")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userid;
	private String username;
	private String password;
	private String email;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(Integer userid, String username, String password, String email, List<ActiveContacts> activecontacts,
			List<DeletedContacts> delcontacts) {
		super();
		this.userid = userid;
		this.username = username;
		this.password = password;
		this.email = email;
		this.activecontacts = activecontacts;
		this.delcontacts = delcontacts;
	}

	@Override
	public String toString() {
		return "User [userid=" + userid + ", username=" + username + ", password=" + password + ", email=" + email
				+ ", activecontacts=" + activecontacts + ", delcontacts=" + delcontacts + ", getUserid()=" + getUserid()
				+ ", getUsername()=" + getUsername() + ", getPassword()=" + getPassword() + ", getEmail()=" + getEmail()
				+ ", getActivecontacts()=" + getActivecontacts() + ", getDelcontacts()=" + getDelcontacts()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<ActiveContacts> getActivecontacts() {
		return activecontacts;
	}

	public void setActivecontacts(List<ActiveContacts> activecontacts) {
		this.activecontacts = activecontacts;
	}

	public List<DeletedContacts> getDelcontacts() {
		return delcontacts;
	}

	public void setDelcontacts(List<DeletedContacts> delcontacts) {
		this.delcontacts = delcontacts;
	}

	@OneToMany(mappedBy = "user")
	private List<ActiveContacts> activecontacts;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<DeletedContacts> delcontacts;
	
	}
