package application.repository;

import application.domain.Souvenir;
import org.springframework.data.repository.CrudRepository;

public interface SouvenirRepository extends CrudRepository<Souvenir,Long> {

}
