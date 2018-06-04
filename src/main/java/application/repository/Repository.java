package application.repository;

import org.springframework.beans.factory.annotation.Autowired;

public class Repository {
    @Autowired
    public EquipmentRepository equipmentRepository;

    @Autowired
    public EventRepository eventRepository;

    @Autowired
    public FanBlockRepository fanBlockRepository;

    @Autowired
    public SouvenirRepository souvenirRepository;

    @Autowired
    public TicketRepository ticketRepository;

    @Autowired
    public WorkerRepository workerRepository;
}
