package application.apiInt;

import application.domain.FanBlock;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface Fan {
    FanBlock addFan(@RequestParam String name, @RequestParam  String pasprortNumber);
    FanBlock selectFan(@RequestParam Long fanId);
    FanBlock updateFan(@RequestParam Long fanId, @RequestParam String name, @RequestParam  String pasprortNumber);
    List<FanBlock> selectListFan();
    String deleteFan(@RequestParam Long fanId);
}
