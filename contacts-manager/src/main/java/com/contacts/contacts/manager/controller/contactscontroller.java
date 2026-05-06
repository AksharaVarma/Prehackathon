package com.contacts.contacts.manager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.contacts.contacts.manager.model.ActiveContacts;
import com.contacts.contacts.manager.model.User;
import com.contacts.contacts.manager.service.ContactService;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class contactscontroller {

    @Autowired
    private ContactService contactService;

    // ================= REGISTER =================
    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        String response = contactService.registerUser(user);
        return ResponseEntity.ok(response);
    }

    // ================= LOGIN =================
    @PostMapping("/login")
    public ResponseEntity<String> loginUser(
            @RequestBody User user,
            HttpSession session) {

        User loggedInUser = contactService.loginUser(
                user.getEmail(),
                user.getPassword());

        if (loggedInUser != null) {
            session.setAttribute("loggedInUser", loggedInUser);
            return ResponseEntity.ok("Login Successful");
        }

        return ResponseEntity.status(401)
                .body("Invalid Email or Password");
    }

    // ================= SAVE CONTACT =================
    @PostMapping("/save")
    public ResponseEntity<String> saveContact(
            @RequestBody ActiveContacts contact,
            HttpSession session) {

        User user = (User) session.getAttribute("loggedInUser");

        if (user == null) {
            return ResponseEntity.status(401)
                    .body("Please Login First");
        }

        contact.setUser(user);
        return ResponseEntity.ok(contactService.saveContact(contact));
    }

    // ================= DELETE =================
    @DeleteMapping("/delete/{contactId}")
    public ResponseEntity<String> deleteContact(
            @PathVariable int contactId,
            HttpSession session) {

        User user = (User) session.getAttribute("loggedInUser");

        if (user == null) {
            return ResponseEntity.status(401)
                    .body("Please Login First");
        }

        return ResponseEntity.ok(
                contactService.deleteContact(contactId));
    }

    // ================= UPDATE =================
    @PutMapping("/update/{contactId}")
    public ResponseEntity<String> updateContact(
            @PathVariable int contactId,
            @RequestBody ActiveContacts updatedContact,
            HttpSession session) {

        User user = (User) session.getAttribute("loggedInUser");

        if (user == null) {
            return ResponseEntity.status(401)
                    .body("Please Login First");
        }

        return ResponseEntity.ok(
                contactService.updateContact(contactId, updatedContact));
    }

    // ================= SEARCH =================
    @GetMapping("/search/{contactName}")
    public ResponseEntity<?> searchContact(
            @PathVariable String contactName,
            HttpSession session) {

        User user = (User) session.getAttribute("loggedInUser");

        if (user == null) {
            return ResponseEntity.status(401)
                    .body("Please Login First");
        }

        List<ActiveContacts> contacts =
                contactService.searchByContactName(contactName);

        return ResponseEntity.ok(contacts);
    }

    // ================= LOGOUT =================
    @PostMapping("/logout")
    public ResponseEntity<String> logoutUser(HttpSession session) {

        session.invalidate();
        return ResponseEntity.ok("Logout Successful");
    }
}