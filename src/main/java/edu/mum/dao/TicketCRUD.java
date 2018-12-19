package edu.mum.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import edu.mum.entity.Ticket;

@Component
public interface TicketCRUD extends CrudRepository<Ticket, Long> {

}
