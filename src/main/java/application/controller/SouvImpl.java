package application.controller;

import application.apiInt.Souv;
import application.domain.Souvenir;
import application.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path="/souv")
public class SouvImpl implements Souv {

    @Autowired
    private Repository repository;
    @Override
    @PostMapping("/add")
    public Souvenir addSouvenir(@RequestParam String souName, @RequestParam double souPrice, @RequestParam int souCount) {
        Souvenir souvenir = new Souvenir();
        souvenir.setSouName(souName);
        souvenir.setSouPrice(souPrice);
        souvenir.setSouCount(souCount);
        repository.souvenirRepository.save(souvenir);
        return souvenir;
    }

    @Override
    @GetMapping("/select/{souId}")
    public Souvenir selectSouvenir(@RequestParam Long souId) {
        Souvenir souvenir = repository.souvenirRepository.findById(souId).get();
        return souvenir;
    }

    @Override
    @PostMapping("/update")
    public Souvenir updateSouvenir(@RequestParam Long souId,  @RequestParam String souName, @RequestParam double souPrice, @RequestParam int souCount) {
        Souvenir souvenir = repository.souvenirRepository.findById(souId).get();
        souvenir.setSouName(souName);
        souvenir.setSouPrice(souPrice);
        souvenir.setSouCount(souCount);
        repository.souvenirRepository.save(souvenir);
        return null;
    }

    @Override
    @GetMapping("/list")
    public List<Souvenir> selectListSouvenir() {
        List<Souvenir> souvenirs = (List) repository.souvenirRepository.findAll();
        return souvenirs;
    }

    @Override
    @GetMapping("/saleSouv")
    public Souvenir saleSouvenir(@RequestParam Long souId, @RequestParam int souCount) {
        Souvenir souvenir = repository.souvenirRepository.findById(souId).get();
        souvenir.setSouCount(souvenir.getSouCount()-souCount);
        repository.souvenirRepository.save(souvenir);
        return souvenir;
    }
}
