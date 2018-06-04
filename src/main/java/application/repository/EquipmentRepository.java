package application.repository;

import application.domain.Equipment;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EquipmentRepository extends CrudRepository<Equipment,Long> {

    List<Equipment> findByStatus(String status);

}
