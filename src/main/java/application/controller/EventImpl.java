package application.controller;

import application.apiInt.Eve;
import application.domain.Ticket;
import application.domain.Event;
import application.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import sun.plugin2.message.EventMessage;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(path="/event")
public class EventImpl implements Eve {

    @Autowired
    private Repository repository;

    @Override
    @PostMapping("/add")
    public Event addEvent(@RequestParam String name, @RequestParam String sdate, @RequestParam String details) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-DD");
        Date date = sdf.parse(sdate);
        Event event = new Event();
        event.setName(name);
        event.setDate(date);
        event.setDetails(details);
        event.setTickets();
        repository.eventRepository.save(event);
        return event;
    }

    @Override
    @GetMapping("/select/{eveId}")
    public Event selectEvent(@RequestParam Long eveId) {
        Event event = repository.eventRepository.findById(eveId).get();
        return event;
    }

    @Override
    @PostMapping("/update")
    public Event updateEvent(@RequestParam Long eveId, @RequestParam String name, @RequestParam Date date, @RequestParam String details) {
        Event event = repository.eventRepository.findById(eveId).get();
        event.setName(name);
        event.setDate(date);
        event.setDetails(details);
        repository.eventRepository.save(event);
        return event;
    }

    @Override
    @GetMapping("/list")
    public List<Event> selectListEvent() {
        List<Event> eventList = (List) repository.eventRepository.findAll();
        return eventList;
    }

    @Override
    @GetMapping("/delete/{eveId}")
    public String deleteEvent(@RequestParam Long eveId) {
        repository.eventRepository.delete(repository.eventRepository.findById(eveId).get());
        return "Event is delete!";
    }

    @Override
    @GetMapping("/saleTicket")
    public String saleTicket(@RequestParam Long eveId) {
        return "redirect:/ticket/saleTicket/{"+eveId+"}";
    }
}
