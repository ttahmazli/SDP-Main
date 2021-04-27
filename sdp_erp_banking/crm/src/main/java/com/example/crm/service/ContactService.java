package com.example.crm.service;

import com.example.crm.model.Contact;

import java.util.List;

public interface ContactService {

    List<Contact> getAllContacts();

    void saveContact(Contact contact);

    Contact getContactById(long id);

    void deleteContactById(long id);
}
