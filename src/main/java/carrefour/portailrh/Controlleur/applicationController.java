package carrefour.portailrh.Controlleur;


import carrefour.portailrh.dao.IActif;
import carrefour.portailrh.dao.IApplication;
import carrefour.portailrh.models.Actif;
import carrefour.portailrh.models.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/users/applications")
public class applicationController {

    @Autowired
    private IApplication iapplication;

    @GetMapping("/all")
    public List<Application> listBordeaux(){
        return iapplication.findAll();
    }

    @PostMapping("/save")
    public Application saveBordeaux(@RequestBody Application c){
        return iapplication.save(c);
    }
}
