package web.costumes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import web.core.CostumeInput;
import web.services.MessageNotifier;

@RestController
public class CostumesController {

    @Autowired
    MessageNotifier messageNotifier;

    @RequestMapping(value = "/costume", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public void insertCostume(@RequestBody CostumeInput input) {
        messageNotifier.notifyCostume(input.toCostume());
    }


}
