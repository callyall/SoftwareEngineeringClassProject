package com.softeng.ticket_application.service;

import com.softeng.ticket_application.model.Ticket;
import com.softeng.ticket_application.repository.GateRepository;
import com.softeng.ticket_application.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 *
 * @author Sideris Argiris
 */
@Service
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;
    @Autowired
    private GateRepository gateRepository;

    public TicketService() {
        // Default constructor
    }

    public List<Ticket> getAll(){
        return ticketRepository.findAll();
    }

    public Ticket save(final Ticket ticket){
        return ticketRepository.save(ticket);
    }

    public Ticket save(final Ticket ticket,final int id){
        ticket.setGate(gateRepository.findById(id));
        return ticketRepository.save(ticket);
    }

    public Ticket findById(final int id){
        return ticketRepository.findById(id);
    }

    public void delete(final int id){
        ticketRepository.delete(id);
    }

}
