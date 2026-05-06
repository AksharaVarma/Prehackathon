package com.contacts.contacts.manager.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.contacts.contacts.manager.model.DeletedContacts;

@Repository
public interface DeletedContactRepository
        extends JpaRepository<DeletedContacts, Integer> {

	DeletedContacts save(DeletedContacts deleted);

}

