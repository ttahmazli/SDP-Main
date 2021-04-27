package com.example.crm.controller;

import com.example.crm.model.Contact;
import com.example.crm.service.ContactService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ContactController {

    @Autowired
    private ContactService contactService;

    @GetMapping("/user/contacts")
    public String viewContactPage(Model model) {
        model.addAttribute("listContacts", contactService.getAllContacts());
        return "contacts";
    }

    @GetMapping("/user/addContact")
    public String showNewContactForm(Model model) {
        Contact contact = new Contact();
        model.addAttribute("contact", contact);
        return "addContact";
    }

    @PostMapping("/user/saveContact")
    public String saveContact(@ModelAttribute("contact") Contact contact) {
        this.contactService.saveContact(contact);
        return "redirect:/user/contacts";
    }

    @GetMapping("/user/editContact/{id}")
    public String showContactUpdateForm(@PathVariable(value = "id") long id, Model model) {
        Contact contact = contactService.getContactById(id);
        model.addAttribute("contact", contact);
        return "editContact";
    }

    @GetMapping("/user/deleteContact/{id}")
    public String deleteContact(@PathVariable(value = "id") long id) {
        this.contactService.deleteContactById(id);
        return "redirect:/user/contacts";
    }
}
