package com.example.crm.service;

import com.example.crm.model.Contact;
import com.example.crm.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ContactServiceImp implements ContactService{

    @Autowired
    ContactRepository contactRepository;

    @Override
    public List<Contact> getAllContacts() {

        return contactRepository.findAll();
    }

    @Override
    public void saveContact(Contact contact) {
        this.contactRepository.save(contact);
    }

    @Override
    public Contact getContactById(long id) {
        Optional<Contact> optional = this.contactRepository.findById(id);
        Contact contact = null;
        if (optional.isPresent()) {
            contact = optional.get();
        } else {
            throw new RuntimeException("Contact couldn't be found with give ID: " + id);
        }

        return contact;
    }

    @Override
    public void deleteContactById(long id) {
        this.contactRepository.deleteById(id);
    }
}

