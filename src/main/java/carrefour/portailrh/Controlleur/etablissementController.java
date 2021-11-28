package carrefour.portailrh.Controlleur;

import carrefour.portailrh.dao.IDemande;
import carrefour.portailrh.dao.IEtablissement;
import carrefour.portailrh.models.Demande;
import carrefour.portailrh.models.Etablissemnt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin("*")

@RequestMapping("/users/etablissements")
public class etablissementController {

    @Autowired
    private IEtablissement ietablissement;

    @GetMapping("/all")
    public List<Etablissemnt> listeEtablissements(){
        return ietablissement.findAll();
    }

    @PostMapping("/save")
    public Etablissemnt saveEtablissement(@RequestBody Etablissemnt e){
        return ietablissement.save(e);
    }
    @PutMapping("/update/{Id}")
    public Etablissemnt update(@RequestBody Etablissemnt e, @PathVariable Long Id){
        e.setId(Id);
        return ietablissement.saveAndFlush(e);
    }

    @DeleteMapping("/delete/{Id}")
    public HashMap<String, String> delete(@PathVariable Long Id){
        HashMap msg=new HashMap();
        try{
            ietablissement.delete(Id);
            msg.put("etat", "category deleted");
            return msg;
        }
        catch (Exception e){
            msg.put("etat", "category not deleted");
            return msg;
        }
    }
}
