package com.contacts.contacts.manager.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.contacts.contacts.manager.model.ActiveContacts;
import com.contacts.contacts.manager.model.DeletedContacts;
import com.contacts.contacts.manager.model.User;
import com.contacts.contacts.manager.repo.ContactsRepository;
import com.contacts.contacts.manager.repo.DeletedContactRepository;
import com.contacts.contacts.manager.repo.UserRepository;

@Service
public class ContactService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ContactsRepository contactsRepository;

    @Autowired
    private DeletedContactRepository deletedContactRepository;

   
    // REGISTER USER
  
    public String registerUser(User user) {

        User existingUser = userRepository.findByEmail(user.getEmail());

        if (existingUser != null) {
            return "Email already registered";
        }

        userRepository.save(user);
        return "User registered successfully";
    }

   
    // LOGIN User
  
    public User loginUser(String email, String password) {

        User user = userRepository.findByEmail(email);

        if (user != null && user.getPassword().equals(password)) {
            return user;
        }

        return null;
    }

   
    // SAVE CONTACT
 
    public String saveContact(ActiveContacts contact) {

        contactsRepository.save(contact);
        return "Contact saved successfully";
    }

    
    // DELETE CONTACT (MOVE TO DELETED TABLE)
   
    public String deleteContact(int contactId) {

        Optional<ActiveContacts> optionalContact =
                contactsRepository.findById(contactId);

        if (optionalContact.isEmpty()) {
            return "Contact not found";
        }

        ActiveContacts contact = optionalContact.get();

        // move to deleted table
        DeletedContacts deleted = new DeletedContacts();

        deleted.setContactname(contact.getContactname());
        deleted.setPhone(contact.getContactno());
        deleted.setType(contact.getType());
        deleted.setOriginalContactId(contact.getContactid());
        deleted.setUser(contact.getUser());

        deletedContactRepository.save(deleted);

        // delete from active contacts
        contactsRepository.deleteById(contactId);

        return "Contact deleted successfully";
    }

   
    // UPDATE CONTACT
    
    public String updateContact(int contactId, ActiveContacts updatedContact) {

        Optional<ActiveContacts> optionalContact =
                contactsRepository.findById(contactId);

        if (optionalContact.isEmpty()) {
            return "Contact not found";
        }

        ActiveContacts existing = optionalContact.get();

        existing.setContactname(updatedContact.getContactname());
        existing.setContactno(updatedContact.getContactno());
        existing.setType(updatedContact.getType());

        contactsRepository.save(existing);

        return "Contact updated successfully";
    }

   
    // SEARCH CONTACT BY NAME
  
    public List<ActiveContacts> searchByContactName(String contactName) {

        return contactsRepository
                .findByContactNameContainingIgnoreCase(contactName);
    }
}