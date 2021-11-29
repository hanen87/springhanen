package carrefour.portailrh.Controlleur;

import carrefour.portailrh.dao.IAccessActif;
import carrefour.portailrh.dao.IActif;
import carrefour.portailrh.dao.IActifAccessLigne;
import carrefour.portailrh.dao.IUser;
import carrefour.portailrh.models.AccesActif;
import carrefour.portailrh.models.Actif;
import carrefour.portailrh.models.ActifAccessLigne;
import carrefour.portailrh.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@CrossOrigin("*")
@RequestMapping("/users/accessactifligne")
public class AccessActifLigneController {

    @Autowired
    private IActifAccessLigne iacces;

    @Autowired
    private IActif iactif;

    @Autowired
    private IUser iuser;

    @GetMapping("/all")
    public List<ActifAccessLigne> listAccess(){
        return iacces.findAll();
    }

    @PostMapping("/save/{iduser}/{idActif}")
    public ActifAccessLigne save(@RequestBody ActifAccessLigne demande,
                                   @PathVariable Long iduser,
                                   @PathVariable Long idActif

    ){

        User user= iuser.findOne(iduser);
        Actif actif= iactif.findOne(idActif);
        demande.setUser(user);
        demande.setActif(actif);
        return iacces.save(demande);
    }

}
