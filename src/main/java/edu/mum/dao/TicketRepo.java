package edu.mum.dao;

import edu.mum.entity.Ticket;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface TicketRepo extends CrudRepository<Ticket, Long> {

}
