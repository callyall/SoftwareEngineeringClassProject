package com.softeng.ticket_application.service;

import com.softeng.ticket_application.model.Event;
import com.softeng.ticket_application.model.Gate;
import com.softeng.ticket_application.model.SimpleGate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 *
 *
 * @author Sideris Argiris
 */
@Service
public class StatisticsService {

    public StatisticsService() {
        // Default constructor
    }

    public List<SimpleGate> getSimpleGates(final Event event){
        final List<SimpleGate> simpleGates = new ArrayList<SimpleGate>();
        final List<Gate> gates = event.getGates();
        gates.forEach((g)->{
            final SimpleGate simpleGate = new SimpleGate();
            simpleGate.setId(g.getId());
            simpleGate.setName(g.getName());
            simpleGate.setCapacity(g.getCapacity());
            simpleGate.setOccupied(g.getTickets().size());
            simpleGates.add(simpleGate);
        });
        return simpleGates;
    }

}

