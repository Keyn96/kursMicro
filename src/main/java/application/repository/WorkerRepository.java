package application.repository;

import application.domain.Worker;
import org.springframework.data.repository.CrudRepository;

public interface WorkerRepository extends CrudRepository<Worker,Long> {

}
