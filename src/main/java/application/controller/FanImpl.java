package application.controller;

import application.apiInt.Fan;
import application.domain.FanBlock;
import application.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path="/fan")
public class FanImpl implements Fan {

    @Autowired
    private Repository repository;
    @Override
    @PostMapping("/add")
    public FanBlock addFan(@RequestParam String name, @RequestParam String pasprortNumber) {
        FanBlock fan = new FanBlock();
        fan.setName(name);
        fan.setPasprortNumber(pasprortNumber);
        repository.fanBlockRepository.save(fan);
        return fan;
    }

    @Override
    @GetMapping("/select/{fanId}")
    public FanBlock selectFan(@RequestParam Long fanId) {
        FanBlock fan = repository.fanBlockRepository.findById(fanId).get();
        return fan;
    }

    @Override
    @PostMapping("/update")
    public FanBlock updateFan(@RequestParam Long fanId, @RequestParam String name, @RequestParam String pasprortNumber) {
        FanBlock fan = repository.fanBlockRepository.findById(fanId).get();
        fan.setName(name);
        fan.setPasprortNumber(pasprortNumber);
        repository.fanBlockRepository.save(fan);
        return fan;
    }

    @Override
    @GetMapping("/list")
    public List<FanBlock> selectListFan() {
        List<FanBlock> fans = (List)repository.fanBlockRepository.findAll();
        return fans;
    }

    @Override
    @GetMapping("/delete/{fanId}")
    public String deleteFan(@RequestParam Long fanId) {
        repository.fanBlockRepository.delete(repository.fanBlockRepository.findById(fanId).get());
        return "Fan is delete";
    }
}
