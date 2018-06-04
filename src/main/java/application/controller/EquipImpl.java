package application.controller;

import application.apiInt.Equip;
import application.domain.Equipment;
import application.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import javax.jws.WebService;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(path="/equip")
public class EquipImpl implements Equip {

    @Autowired
    private Repository repository;

    @Override
    @PostMapping("/add")
    public Equipment addEquip(@RequestParam String name, @RequestParam String producer, @RequestParam Date date_produce) {
        Equipment equipment = new Equipment(name, producer, date_produce);
        repository.equipmentRepository.save(equipment);
        return equipment;
    }

    @Override
    @GetMapping("/select/{eqpId}")
    public Equipment selectEquip(@RequestParam Long eqpId) {
        Equipment equipment = repository.equipmentRepository.findById(eqpId).get();
        return equipment;
    }

    @Override
    @PostMapping("/update")
    public Equipment updateEquip(@RequestParam Long eqpId, @RequestParam String name, @RequestParam String producer,@RequestParam Date date_produce) {
        Equipment equipment = repository.equipmentRepository.findById(eqpId).get();
        equipment.setName(name);
        equipment.setProducer(producer);
        equipment.setDate_produce(date_produce);
        repository.equipmentRepository.save(equipment);
        return equipment;
    }

    @Override
    @GetMapping("/list")
    public List<Equipment> selectListEquip() {
        List<Equipment> equipmentList = (List) repository.equipmentRepository.findAll();
        return equipmentList;
    }

    @Override
    @GetMapping("/delete/{eqpId}")
    public String deleteEquip(Long eqpId) {
        repository.equipmentRepository.delete(repository.equipmentRepository.findById(eqpId).get());
        return "Equipment is delete!";
    }

    @Override
    @GetMapping("/equipStatus")
    public List<Equipment> selectListStatusEquip(String status) {
        List<Equipment> equipmentList = repository.equipmentRepository.findByStatus(status);
        return equipmentList;
    }

    @Override
    @GetMapping("/workequip")
    public String workEquip(Long eqpId) {
        Equipment equipment = repository.equipmentRepository.findById(eqpId).get();
        equipment.setStatus("Work!");
        return "Status is work!";
    }
}
