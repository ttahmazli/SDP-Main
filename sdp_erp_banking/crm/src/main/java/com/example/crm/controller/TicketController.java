package com.example.crm.controller;

import com.example.crm.model.Ticket;
import com.example.crm.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TicketController {

    @Autowired
    TicketService ticketService;

    @GetMapping("/user")
    public String viewHomePage(Model model) {
        model.addAttribute("listTickets", ticketService.getAllTickets());
        return "user";
    }

    @GetMapping("/admin")
    public String viewHomePageAdmin(Model model) {
        model.addAttribute("listTickets", ticketService.getAllTickets());
        return "admin";
    }

    @GetMapping("/user/addTicket")
    public String showNewTicketForm(Model model) {
        Ticket ticket = new Ticket();
        model.addAttribute("ticket", ticket);
        return "addTicket";
    }

    @PostMapping("/user/saveTicket")
    public String saveTicket(@ModelAttribute("ticket") Ticket ticket) {
        this.ticketService.saveTicket(ticket);
        return "redirect:/user";
    }

    @PostMapping("/admin/saveTicket")
    public String saveTicketAdmin(@ModelAttribute("ticket") Ticket ticket) {
        this.ticketService.saveTicket(ticket);
        return "redirect:/admin";
    }

    @GetMapping("/admin/answerTicket/{id}")
    public String showTicketUpdateForm(@PathVariable(value = "id") long id, Model model) {
        Ticket ticket = ticketService.getTicketById(id);
        model.addAttribute("ticket", ticket);
        return "answerTicket";
    }

    @GetMapping("/user/viewTicket/{id}")
    public String showTicket(@PathVariable(value = "id") long id, Model model) {
        Ticket ticket = ticketService.getTicketById(id);
        model.addAttribute("ticket", ticket);
        return "viewTicket";
    }

    @GetMapping("/user/deleteTicket/{id}")
    public String deleteTicket(@PathVariable(value = "id") long id) {
        this.ticketService.deleteTicketById(id);
        return "redirect:/user";
    }
}
