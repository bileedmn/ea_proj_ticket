package edu.mum.amqp;

import org.springframework.amqp.rabbit.core.RabbitTemplate;

public interface TicketService {
    void publish(RabbitTemplate rabbitTemplate);
}
