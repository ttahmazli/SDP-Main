package com.example.crm.service;

import com.example.crm.model.Ticket;

import java.util.List;

public interface TicketService {

    List<Ticket> getAllTickets();

    void saveTicket(Ticket ticket);

    Ticket getTicketById(long id);

    void deleteTicketById(long id);
}
