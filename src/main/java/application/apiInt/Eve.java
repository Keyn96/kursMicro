package application.apiInt;

import application.domain.Event;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

public interface Eve {

    Event addEvent(@RequestParam String name, @RequestParam String date, @RequestParam  String details)throws ParseException;
    Event selectEvent(@RequestParam Long eveId);
    Event updateEvent(@RequestParam Long eveId, @RequestParam String name, @RequestParam Date date, @RequestParam  String details);
    List<Event> selectListEvent();
    String deleteEvent(@RequestParam Long eveId);
    String saleTicket(@RequestParam Long eveId);
}
