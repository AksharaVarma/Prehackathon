package com.contacts.contacts.manager.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.contacts.contacts.manager.model.User;

@Repository
public interface UserRepository
        extends JpaRepository<User, Integer> {

    // find user using email during login
    User findByEmail(String email);

}
