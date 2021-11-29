package carrefour.portailrh.Controlleur;

import carrefour.portailrh.dao.IBordeaureaux;
import carrefour.portailrh.dao.ISousBordeaureu;
import carrefour.portailrh.dao.iBureauOrdre;
import carrefour.portailrh.models.Borderaeu;
import carrefour.portailrh.models.Bureau_Ordre;
import carrefour.portailrh.models.LigneAttestation;
import carrefour.portailrh.models.SousBordereaux;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
@RestController
@CrossOrigin("*")
@RequestMapping("/users/bordereaux")
public class BordeaurController {

    @Autowired
    private IBordeaureaux ibordeau;

    @Autowired
    private ISousBordeaureu isousbordeau;

    @Autowired
    private iBureauOrdre ibureauordre;

    @GetMapping("/all")
    public List<Borderaeu> listBordeaux(){
        return ibordeau.findAll();
    }

    @PostMapping("/save1")
    public Borderaeu saveBordeaux(@RequestBody Borderaeu c){
        return ibordeau.save(c);
    }


    @PostMapping("/save/{idborder}")
    public Borderaeu saveDemande(@RequestBody Borderaeu d,@PathVariable Long idborder, @RequestParam List<Long> ids
    ){
        Bureau_Ordre bo= ibureauordre.findOne( idborder );
        d.setBureau_ordre(bo);
        for(int i=0; i< ids.size(); i++) {
            SousBordereaux sb = isousbordeau.findOne(ids.get(i));
            d.addSousBordeau(sb);

        }
        return ibordeau.save(d);
    }



    @PutMapping("/update/{Id}")
    public Borderaeu update(@RequestBody Borderaeu category, @PathVariable Long Id){
        category.setId(Id);
        return ibordeau.saveAndFlush(category);
    }

    @DeleteMapping("/delete/{Id}")
    public HashMap<String, String> delete(@PathVariable Long Id){
        HashMap msg=new HashMap();
        try{
            ibordeau.delete(Id);
            msg.put("etat", "category deleted");
            return msg;
        }
        catch (Exception e){
            msg.put("etat", "category not deleted");
            return msg;
        }
    }


    @PutMapping("/annuler/{idborderau}")
    public Borderaeu annulerBordeaux(@PathVariable Long idborderau){

        Borderaeu b= ibordeau.findOne(idborderau);
        b.setId(idborderau);
        b.setEtat("Annulé");
       // b.setReference( "" );
        return ibordeau.saveAndFlush(b);
    }



}
