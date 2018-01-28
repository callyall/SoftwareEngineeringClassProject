package com.softeng.ticket_application.repository;

import com.softeng.ticket_application.model.Ticket;
import com.softeng.ticket_application.model.Gate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 *
 * @author Dionisis Patrikios
 */
@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer> {

    List<Ticket> findAll();
    List<Ticket> findByGate(Gate gate);
    Ticket findById(int id);
}
