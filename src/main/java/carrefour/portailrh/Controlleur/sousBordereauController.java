package carrefour.portailrh.Controlleur;

import carrefour.portailrh.dao.IDemande;
import carrefour.portailrh.dao.ILigneAttzstation;
import carrefour.portailrh.dao.ISousBordeaureu;
import carrefour.portailrh.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/users/sousbordereaux")
public class sousBordereauController {

    @Autowired
    private ISousBordeaureu isousbordeau;

    @Autowired
    private ILigneAttzstation iligneattestation;

    @GetMapping("/all")
    public List<SousBordereaux> listeDemandes(){
        return isousbordeau.findAll();
    }


    @PostMapping("/save")
    public SousBordereaux saveDemande(@RequestBody SousBordereaux d, @RequestParam List<Long> ids
    ){
        for(int i=0; i< ids.size(); i++) {
            LigneAttestation ligne = iligneattestation.findOne(ids.get(i));
            d.addLigne(ligne);

        }
        return isousbordeau.save(d);
    }

    @PutMapping("/update/{Id}")
    public SousBordereaux update(@RequestBody SousBordereaux d, @PathVariable Long Id){
        d.setId(Id);
        return isousbordeau.saveAndFlush(d);
    }

    @DeleteMapping("/delete/{Id}")
    public HashMap<String, String> delete(@PathVariable Long Id){
        HashMap msg=new HashMap();
        try{
            isousbordeau.delete(Id);
            msg.put("etat", "category deleted");
            return msg;
        }
        catch (Exception e){
            msg.put("etat", "category not deleted");
            return msg;
        }
    }

    @PutMapping("/annuler/{idsousborderau}")
    public SousBordereaux saveBordeaux(@PathVariable Long idsousborderau){

        SousBordereaux sb= isousbordeau.findOne(idsousborderau);
        sb.setId(idsousborderau);
        sb.setEtat( "Annulé" );
       // sb.setReference( "" );
        return isousbordeau.saveAndFlush(sb);
    }

    @PutMapping("/generer/{idsousborderau}")
    public SousBordereaux genererBordeaux(@PathVariable Long idsousborderau){

        SousBordereaux sb= isousbordeau.findOne(idsousborderau);
        sb.setId(idsousborderau);
        sb.setEtat("générer");
        // b.setReference( "" );
        return isousbordeau.saveAndFlush(sb);
    }

}
