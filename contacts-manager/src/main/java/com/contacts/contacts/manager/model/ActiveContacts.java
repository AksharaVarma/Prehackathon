package com.contacts.contacts.manager.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="ActiveContacts")
public class ActiveContacts {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer contactid;
	
	@ManyToOne
	@JoinColumn(name="userid")
	private User user;
	
	private String contactname;
	private String contactno;
	private String type;
	public ActiveContacts() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ActiveContacts(Integer contactid, User user, String contactname, String contactno, String type) {
		super();
		this.contactid = contactid;
		this.user = user;
		this.contactname = contactname;
		this.contactno = contactno;
		this.type = type;
	}
	@Override
	public String toString() {
		return "ActiveContacts [contactid=" + contactid + ", user=" + user + ", contactname=" + contactname
				+ ", contactno=" + contactno + ", type=" + type + "]";
	}
	public Integer getContactid() {
		return contactid;
	}
	public void setContactid(Integer contactid) {
		this.contactid = contactid;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getContactname() {
		return contactname;
	}
	public void setContactname(String contactname) {
		this.contactname = contactname;
	}
	public String getContactno() {
		return contactno;
	}
	public void setContactno(String contactno) {
		this.contactno = contactno;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	}