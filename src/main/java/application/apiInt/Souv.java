package application.apiInt;

import application.domain.Souvenir;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

public interface Souv {

    Souvenir addSouvenir(@RequestParam String souName, @RequestParam double souPrice, @RequestParam  int souCount);
    Souvenir selectSouvenir (@RequestParam Long souId);
    Souvenir updateSouvenir(@RequestParam Long souId,@RequestParam String souName, @RequestParam double souPrice, @RequestParam  int souCount);
    List<Souvenir> selectListSouvenir();
    Souvenir saleSouvenir(@RequestParam Long souId, @RequestParam int souCount);
}
