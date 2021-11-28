package carrefour.portailrh.Controlleur;

import carrefour.portailrh.dao.IDemande;
import carrefour.portailrh.dao.ILigneAttzstation;
import carrefour.portailrh.dao.IUser;
import carrefour.portailrh.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/users/ligneattestation")
public class ligneattestationController {

    @Autowired
    private ILigneAttzstation iligneAttestation;

    @Autowired
    private IUser iuser;

    @GetMapping("/all")
    public List<LigneAttestation> listeDemandes(){
        return iligneAttestation.findAll();
    }

    @PostMapping("/save/{iduser}")
    public LigneAttestation saveDemande(@RequestBody LigneAttestation d, @PathVariable Long iduser){
        User user= iuser.findOne( iduser );
        d.setDemandeur(user );
        return iligneAttestation.save(d);
    }
    @PutMapping("/update/{Id}")
    public LigneAttestation update(@RequestBody LigneAttestation d, @PathVariable Long Id){
        d.setId(Id);
        return iligneAttestation.saveAndFlush(d);
    }

    @DeleteMapping("/delete/{Id}")
    public HashMap<String, String> delete(@PathVariable Long Id){
        HashMap msg=new HashMap();
        try{
            iligneAttestation.delete(Id);
            msg.put("etat", "ligne demandee deleted");
            return msg;
        }
        catch (Exception e){
            msg.put("etat", "ligne demande not deleted");
            return msg;
        }
    }


    @PutMapping("/valider/{Id}/{idvalidateur}")
    public LigneAttestation Valider(@PathVariable Long Id,
                                    @PathVariable Long idvalidateur
                                    ){
        LigneAttestation ligne= iligneAttestation.findOne(Id);
        User user= iuser.findOne( idvalidateur );
        ligne.setValidateur(user );
        Date date = new Date();
        ligne.setDate_validation(date.toString());
        ligne.setStatus("validée");
        return iligneAttestation.saveAndFlush(ligne);
    }

    @PutMapping("/annuler/{Id}/{idvalidateur}")
    public LigneAttestation Annuler(@RequestBody AnnulationDemandeAttestation annulationRequest,
                                    @PathVariable Long idvalidateur,
                                    @PathVariable Long Id){
        LigneAttestation ligne= iligneAttestation.findOne(Id);
        //User user= iuser.findOne( idvalidateur );
       // ligne.setValidateur(user );
        Date date = new Date();
        ligne.setDate_annulation(date.toString());
        ligne.setStatus("rejetée");
        ligne.setCommentaire_annulation( annulationRequest.getCommentaire_annulation() );
        ligne.setMotif_blocage( annulationRequest.getMotif_annulation());

        return iligneAttestation.saveAndFlush(ligne);
    }


    @PutMapping("/initier/{Id}/{idvalidateur}")
    public LigneAttestation Initier(@PathVariable Long idvalidateur, @PathVariable Long Id){
        LigneAttestation ligne= iligneAttestation.findOne(Id);
      
        ligne.setDate_annulation("");
        ligne.setStatus("en instance");
        return iligneAttestation.saveAndFlush(ligne);
    }

    @PutMapping("/envoyer/{Id}/{idvalidateur}")
    public LigneAttestation envoyer(@PathVariable Long idvalidateur, @PathVariable Long Id){
        LigneAttestation ligne= iligneAttestation.findOne(Id);

        ligne.setStatus("envoyé");
        return iligneAttestation.saveAndFlush(ligne);
    }

}
