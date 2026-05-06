package com.contacts.contacts.manager.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "deleted_contacts")
public class DeletedContacts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int deletedId;
private String contactname;



	private int originalContactId;

    private String phone;

    private String type;

    // deleted contact also belongs to user
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

	public DeletedContacts() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "DeletedContacts [deletedId=" + deletedId + ", contactname=" + contactname + ", originalContactId="
				+ originalContactId + ", phone=" + phone + ", type=" + type + ", user=" + user + "]";
	}

	public DeletedContacts(int deletedId, String contactname, int originalContactId, String phone, String type,
			User user) {
		super();
		this.deletedId = deletedId;
		this.contactname = contactname;
		this.originalContactId = originalContactId;
		this.phone = phone;
		this.type = type;
		this.user = user;
	}

	public int getDeletedId() {
		return deletedId;
	}

	public void setDeletedId(int deletedId) {
		this.deletedId = deletedId;
	}

	public String getContactname() {
		return contactname;
	}

	public void setContactname(String contactname) {
		this.contactname = contactname;
	}

	public int getOriginalContactId() {
		return originalContactId;
	}

	public void setOriginalContactId(int originalContactId) {
		this.originalContactId = originalContactId;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}


}