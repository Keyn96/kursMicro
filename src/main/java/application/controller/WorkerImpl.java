package application.controller;

import application.apiInt.WorkerInterface;
import application.domain.Worker;
import application.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(path="/worker")
public class WorkerImpl implements WorkerInterface {

    @Autowired
    private Repository repository;

    @Override
    @PostMapping("/add")
    public Worker addWorker(@RequestParam String name,@RequestParam  int salary,@RequestParam  String contactNumber) {
        Worker worker = new Worker(name, salary,contactNumber, new Date());
        repository.workerRepository.save(worker);
        return worker;
    }

    @Override
    @GetMapping("/select/{worId}")
    public Worker selectWorker(@RequestParam Long worId) {
       Worker worker = repository.workerRepository.findById(worId).get();
       return worker;
    }

    @Override
    @PostMapping("/edit")
    public Worker updateWorker(@RequestParam Long worId,@RequestParam String name,@RequestParam int salary,@RequestParam String contactNumber) {
        Worker worker = repository.workerRepository.findById(worId).get();
        worker.setName(name);
        worker.setSalary(salary);
        worker.setContactNumber(contactNumber);
        repository.workerRepository.save(worker);
        return worker;
    }

    @Override
    @GetMapping("/list")
    public List<Worker> selectListWorker() {
        List<Worker> workerList = (List)repository.workerRepository.findAll();
        return workerList;
    }

    @Override
    @GetMapping("/delete/{worId}")
    public String deleteWorker(Long worId) {
        repository.workerRepository.delete(repository.workerRepository.findById(worId).get());
        return "Worker is delete!";
    }
}
