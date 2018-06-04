package application.apiInt;

import application.domain.Ticket;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

public interface TicketInt {
    Ticket addTicket(@RequestParam Long number, @RequestParam Date date, Long eveId);
    Ticket selectTicket(@RequestParam Long tickId);
    Ticket updateTicket(@RequestParam Long tickId, @RequestParam Date date);
    List<Ticket> selectListTicket();
    Ticket saleTicket(@RequestParam Long eveId);
}
