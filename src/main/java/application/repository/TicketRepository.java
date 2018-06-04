package application.repository;

import application.domain.Event;
import application.domain.Ticket;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TicketRepository extends CrudRepository<Ticket,Long> {

//    @Query("select ticket from Ticket ticket where (:status = null or ticket.status = :status) and (:event = null or project.event = :event)")
//    List<Ticket> findAllByParameters(
//            @Param("status")String status,
//            @Param("event")Event event);
    List<Ticket> findByStatusAndEvent(String status, Event event);

}
