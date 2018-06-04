package application.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tickId;
    private Long number;
    private Date date;
    private String status;

    /*public Ticket( Long number, Date date, Event event) {
        this.number = number;
        this.date = date;
        this.event = event;
        this.status = "Not sale";
    }*/

    @ManyToOne
    @JoinColumn(name = "eveId")
    private Event event;

    public Long getTickId() {
        return tickId;
    }

    public void setTickId(Long tickId) {
        this.tickId = tickId;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
