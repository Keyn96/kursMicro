package application.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long eveId;
    private String name;
    private Date date;
    private String details;

   /* public Event(String name, Date date, String details) {
        this.name = name;
        this.date = date;
        this.details = details;
    }*/
    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Ticket> tickets;

    public Long getEveId() {
        return eveId;
    }

    public void setEveId(Long eveId) {
        this.eveId = eveId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets() {
        List<Ticket> tickets = new ArrayList<>();
        for(int i = 0; i<10000; i++){
            Ticket ticket = new Ticket();
            ticket.setNumber((long)i);
            ticket.setDate(this.date);
            ticket.setEvent(this);
            ticket.setStatus("Not sale");
            tickets.add(ticket);
            }
    }
}
