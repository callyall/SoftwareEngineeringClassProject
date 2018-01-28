package com.softeng.ticket_application.repository;

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
public interface GateRepository extends JpaRepository<Gate, Integer> {

    List<Gate> findAll();
    Gate findById(int id);

}
