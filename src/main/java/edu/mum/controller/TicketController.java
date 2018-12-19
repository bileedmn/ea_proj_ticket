package edu.mum.controller;

import edu.mum.amqp.TicketServiceImpl;
import edu.mum.dao.TicketCRUD;
import edu.mum.entity.Ticket;

import org.hibernate.engine.spi.PersistenceContext;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ticket")
public class TicketController {
	
	@Autowired
	TicketCRUD t_repo;

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String createTicket() {

        System.out.println("Ticket AMQP...");
        ApplicationContext context = new GenericXmlApplicationContext(
                "classpath:context/ticket-app-context.xml");

        RabbitTemplate topicTemplate = context.getBean("directTemplate", RabbitTemplate.class);
        TicketServiceImpl ticketService = new TicketServiceImpl();
        ticketService.publish(topicTemplate);

        System.out.println("Ticket has sent to AMQP.");

        return "ticketlist";
    }
    

    @RequestMapping(value = "/process", method = RequestMethod.POST)
    public String processNewTicket(@RequestParam Long flightId,
    		@RequestParam String userId) {

        System.out.println("Creating new ticket");
        
        Ticket t = new Ticket();
        t_repo.save(t);
        
        ApplicationContext context = new GenericXmlApplicationContext(
                "classpath:context/ticket-app-context.xml");
        RabbitTemplate topicTemplate = context.getBean("directTemplate", RabbitTemplate.class);
        TicketServiceImpl ticketService = new TicketServiceImpl();
        ticketService.publishTicket(topicTemplate, t);

        System.out.println("Ticket has sent to AMQP.");

        return "success";
    }

}
