package edu.mum.controller;

import edu.mum.amqp.TicketServiceImpl;
import edu.mum.dao.FlightRepo;
import edu.mum.dao.MemberRepo;
import edu.mum.dao.TicketRepo;
import edu.mum.entity.Flight;
import edu.mum.entity.Member;
import edu.mum.entity.Ticket;
import edu.mum.entity.TicketModel;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Date;

@RestController
@RequestMapping("/ticket")
public class TicketController {
	
	@Autowired
    TicketRepo tr;
	@Autowired
    FlightRepo fr;
	@Autowired
    MemberRepo mr;

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String createTicket() {

        System.out.println("Mongolia...");
        RestTemplate restTemplate = new RestTemplate();
        String res = restTemplate.postForObject("http://localhost:8081/ea_proj_ticket_war_exploded/ticket/process", new TicketModel(), String.class);
        System.out.println("RESPONSE: "+res);


        return "ok";
    }
    

    @RequestMapping(value = "/process", method = RequestMethod.POST)
    public String processNewTicket(@RequestBody TicketModel t) {


        System.out.println("From Ganbat...................");

        System.out.println("Creating new ticket. FlightId: " + t.getFlightId() + " MemberId: " + t.getMemberId());

        Flight f = fr.findOne(t.getFlightId());
        Member m = mr.findOne(t.getMemberId());

        if(null == f || null == m){
            String errMsg = "ERROR: Flight or Member not found";
            System.out.println(errMsg);
            throw new RuntimeException(errMsg);
            //return errMsg;
        }

        Ticket ticket = new Ticket();
        ticket.setFlight(f);
        ticket.setPassanger(m);
        ticket.setIssuedDate(new Date());
        ticket.setSeatNo(1);
        tr.save(ticket);


        ApplicationContext context = new GenericXmlApplicationContext(
                "classpath:context/ticket-app-context.xml");
        RabbitTemplate topicTemplate = context.getBean("directTemplate", RabbitTemplate.class);
        TicketServiceImpl ticketService = new TicketServiceImpl();
        ticketService.publishTicket(topicTemplate, t);

        System.out.println("Ticket has sent to AMQP.");

        return "success";
    }

}
