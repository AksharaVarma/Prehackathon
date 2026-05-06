package com.contacts.contacts.manager.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.contacts.contacts.manager.model.ActiveContacts;
import com.contacts.contacts.manager.model.User;

@Repository
public interface ContactsRepository
        extends JpaRepository<ActiveContacts, Integer> {

    List<ActiveContacts>
    findByContactNameContainingIgnoreCase(String contactName);

    // ⭐ ADD THIS (VERY USEFUL FOR USER-WISE CONTACTS)
    List<ActiveContacts> findByUser(User user);
}