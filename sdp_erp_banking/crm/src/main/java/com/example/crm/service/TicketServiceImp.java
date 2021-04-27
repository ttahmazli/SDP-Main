package com.example.crm.service;

import com.example.crm.model.Contact;
import com.example.crm.model.Ticket;
import com.example.crm.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketServiceImp implements TicketService{

    @Autowired
    TicketRepository ticketRepository;
    @Override

    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    @Override
    public void saveTicket(Ticket ticket) {
        this.ticketRepository.save(ticket);
    }

    @Override
    public Ticket getTicketById(long id) {
        Optional<Ticket> optional = this.ticketRepository.findById(id);
        Ticket ticket = null;
        if (optional.isPresent()) {
            ticket = optional.get();
        } else {
            throw new RuntimeException("Ticket couldn't be found with give ID: " + id);
        }
        return ticket;
    }

    @Override
    public void deleteTicketById(long id) {
        this.ticketRepository.deleteById(id);
    }
}
