package application.controller;

import application.apiInt.TicketInt;
import application.domain.Event;
import application.domain.Ticket;
import application.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(path="/ticket")
public class TicketImpl implements TicketInt {

    @Autowired
    private Repository repository;
    @Override
    @PostMapping("/add")
    public Ticket addTicket(@RequestParam Long number, @RequestParam Date date, @RequestParam Long eveId) {
        Ticket ticket = new Ticket();
        ticket.setNumber(number);
        ticket.setDate(date);
        ticket.setEvent(repository.eventRepository.findById(eveId).get());
        ticket.setStatus("Not sale");
        repository.ticketRepository.save(ticket);
        return ticket;
    }

    @Override
    @GetMapping("/select/{tickId}")
    public Ticket selectTicket(@RequestParam Long tickId) {

        Ticket ticket = repository.ticketRepository.findById(tickId).get();
        return ticket;
    }

    @Override
    @PostMapping("/update")
    public Ticket updateTicket(@RequestParam Long tickId, @RequestParam Date date) {
        Ticket ticket = repository.ticketRepository.findById(tickId).get();
        ticket.setDate(date);
        repository.ticketRepository.save(ticket);
        return ticket;
    }

    @Override
    @GetMapping("/list")
    public List<Ticket> selectListTicket() {
        List<Ticket> tickets = (List) repository.ticketRepository.findAll();
        return tickets;
    }

    @Override
    @GetMapping("/saleTicket")
    public Ticket saleTicket(@RequestParam Long eveId) {
        Event event = repository.eventRepository.findById(eveId).get();
        List<Ticket> tickets = (List) repository.ticketRepository.findByStatusAndEvent("Not sale",event);
        Ticket ticket = tickets.get(0);
        ticket.setStatus("Sale");
        repository.ticketRepository.save(ticket);
        return ticket;
    }
}
