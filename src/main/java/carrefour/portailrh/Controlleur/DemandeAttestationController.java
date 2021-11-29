package carrefour.portailrh.Controlleur;

import carrefour.portailrh.dao.IBordeaureaux;
import carrefour.portailrh.dao.IDemande;
import carrefour.portailrh.dao.ILigneAttzstation;
import carrefour.portailrh.models.Borderaeu;
import carrefour.portailrh.models.Demande;
import carrefour.portailrh.models.LigneAttestation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.stream.IntStream;

@RestController
@CrossOrigin("*")
@RequestMapping("/users/demandeattestations")
public class DemandeAttestationController {

    @Autowired
    private IDemande idemande;

    @Autowired
    private ILigneAttzstation iligneattestation;

    @GetMapping("/all")
    public List<Demande> listeDemandes(){
        return idemande.findAll();
    }

    @PostMapping("/save")
    public Demande saveDemande(@RequestBody Demande d, @RequestParam List<Long> ids){
        for(int i=0; i< ids.size(); i++) {
            LigneAttestation ligne = iligneattestation.findOne(ids.get(i));
            d.addLigne(ligne);
            System.out.println( ligne );

        }
        idemande.save(d);
        return idemande.save(d);
    }

    @PutMapping("/update/{Id}")
    public Demande update(@RequestBody Demande d, @PathVariable Long Id){
        d.setId(Id);
        return idemande.saveAndFlush(d);
    }

    @DeleteMapping("/delete/{Id}")
    public HashMap<String, String> delete(@PathVariable Long Id){
        HashMap msg=new HashMap();
        try{
            idemande.delete(Id);
            msg.put("etat", "demande deleted");
            return msg;
        }
        catch (Exception e){
            msg.put("etat", "demande not deleted");
            return msg;
        }
    }

    @PostMapping("/addtolignes/{id}/{idligne}")
    public ResponseEntity<?> addToLignes(@PathVariable Long id,@PathVariable Long idligne) {
        LigneAttestation ligne = iligneattestation.findOne(idligne);
        Demande demande = idemande.findOne(id);
        demande.addLigne(ligne);
        idemande.save(demande);
        System.out.println( "found ligne"+ligne );
        return ResponseEntity.ok(demande);
    }
}
