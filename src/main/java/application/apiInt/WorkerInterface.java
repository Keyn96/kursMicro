package application.apiInt;

import application.domain.Worker;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface WorkerInterface {
    Worker addWorker(@RequestParam String name, @RequestParam  int salary, @RequestParam  String contactNumber);
    Worker selectWorker(@RequestParam Long worId);
    Worker updateWorker(@RequestParam Long worId, @RequestParam String name, @RequestParam  int salary, @RequestParam  String contactNumber);
    List<Worker> selectListWorker();
    String deleteWorker(@RequestParam Long worId);
}
