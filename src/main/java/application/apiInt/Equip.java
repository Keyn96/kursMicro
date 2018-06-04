package application.apiInt;

import application.domain.Equipment;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

public interface Equip {

    Equipment addEquip(@RequestParam String name, @RequestParam  String producer, @RequestParam Date date_produce);
    Equipment selectEquip(@RequestParam Long eqpId);
    Equipment updateEquip(@RequestParam Long eqpId, @RequestParam String name, @RequestParam  String producer, @RequestParam Date date_produce);
    List<Equipment> selectListEquip();
    String deleteEquip(@RequestParam Long eqpId);
    List<Equipment> selectListStatusEquip(@RequestParam String status);
    String workEquip(@RequestParam Long eqpId);
}
