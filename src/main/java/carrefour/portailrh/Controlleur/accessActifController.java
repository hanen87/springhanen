package carrefour.portailrh.Controlleur;

import carrefour.portailrh.dao.*;
import carrefour.portailrh.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/users/accessActifs")
public class accessActifController {

    @Autowired
    private IAccessActif iacces;

    @Autowired
    private IActif iactif;

    @Autowired
    private IUser iuser;

    @Autowired
    private IActifAccessLigne iaccessligneactif;

    @GetMapping("/all")
    public List<AccesActif> listAccess(){
        return iacces.findAll();
    }


    @PostMapping("/save/{iduser}")
    public AccesActif  save(@RequestBody AccesActif d,
                                         @RequestParam List<Long> ids,  @PathVariable Long iduser

    ){
        for(int i=0; i< ids.size(); i++) {
            ActifAccessLigne applicationligne = iaccessligneactif.findOne(ids.get(i));
            d.addLigne(applicationligne);

        }
        User user= iuser.findOne(iduser);
        d.setUser(user);
        iacces.save(d);
        return iacces.save(d);
    }



}
