package edu.mum.amqp;

import edu.mum.entity.Ticket;
import org.springframework.amqp.rabbit.core.RabbitTemplate;


public class TicketServiceImpl implements TicketService {

    public void publish(RabbitTemplate rabbitTemplate) {

        //TODO Set ticket properties
        Ticket t = new Ticket();

        System.out.println("Sending...");
        rabbitTemplate.convertAndSend("ticket.key", t);

        System.out.println("Sent.");
    }

    public void publishTicket(RabbitTemplate rabbitTemplate, Ticket t) {

        System.out.println("Sending...");
        rabbitTemplate.convertAndSend("ticket.key", t);

        System.out.println("Sent.");
    }
}
