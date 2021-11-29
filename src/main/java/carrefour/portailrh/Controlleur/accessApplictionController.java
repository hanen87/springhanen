package carrefour.portailrh.Controlleur;

import carrefour.portailrh.dao.IAccessApplication;
import carrefour.portailrh.dao.IAccessApplicationLigne;
import carrefour.portailrh.dao.IApplication;
import carrefour.portailrh.dao.IUser;
import carrefour.portailrh.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
@RestController
@CrossOrigin("*")
@RequestMapping("/users/accessApplications")
public class accessApplictionController {

    @Autowired
    private IAccessApplication iacces;

;    @Autowired
    private IApplication iapplication;

    @Autowired
    private IAccessApplicationLigne iaccessligneapplication;

    @Autowired
    private IUser iuser;

    @GetMapping("/all")
    public List<AccessApplication> listBordeaux(){
        return iacces.findAll();
    }

    @PostMapping("/save1/{iduser}/{idApplication}")
    public AccessApplication saveBordeaux(@RequestBody AccessApplication demande,
                                          @PathVariable Long iduser,
                                          @PathVariable Long idApplication

    ){

        User user= iuser.findOne(iduser);
        Application app= iapplication.findOne(idApplication);
        demande.setUser(user);
        return iacces.save(demande);
    }

    @PostMapping("/save/{iduser}")
    public AccessApplication saveDemande(@RequestBody AccessApplication d,
                                         @RequestParam List<Long> ids,
                                         @PathVariable Long iduser

    ){
        for(int i=0; i< ids.size(); i++) {
            AccessApplicationLigne applicationligne = iaccessligneapplication.findOne(ids.get(i));
            d.addLigne(applicationligne);
        }
        User user= iuser.findOne(iduser);
        d.setUser(user);

        return iacces.save(d);
    }



    @DeleteMapping("/delete/{Id}")
    public HashMap<String, String> delete(@PathVariable Long Id){
        HashMap msg=new HashMap();
        try{
            iacces.delete(Id);
            msg.put("etat", "demande it deleted");
            return msg;
        }
        catch (Exception e){
            msg.put("etat", "demande it not deleted");
            return msg;
        }
    }

    @PutMapping("/valider/{Id}")
    public AccessApplication valider(@PathVariable Long Id){
        AccessApplication accessApp= iacces.findOne( Id );
        accessApp.setStatus( "validé" );
        Date date= new Date();
        accessApp.setDate_validation( date.toString() );
        return iacces.saveAndFlush(accessApp);
    }


    @PutMapping("/annuler/{Id}")
    public AccessApplication Annuler(@PathVariable Long Id){
        AccessApplication accessApp= iacces.findOne( Id );
        accessApp.setStatus( "annulé" );
        Date date= new Date();
        accessApp.setDate_validation( date.toString() );
        return iacces.saveAndFlush(accessApp);
    }

}
