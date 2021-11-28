package carrefour.portailrh.Controlleur;

import carrefour.portailrh.dao.IActif;
import carrefour.portailrh.dao.IBordeaureaux;
import carrefour.portailrh.dao.iType;
import carrefour.portailrh.models.Actif;
import carrefour.portailrh.models.Application;
import carrefour.portailrh.models.Borderaeu;
import carrefour.portailrh.models.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/users/actifs")
public class actifcontroller {


        @Autowired
        private IActif iactif;

        @Autowired
        private iType itype;

        @GetMapping("/all")
        public List<Actif> listBordeaux(){
            return iactif.findAll();
        }

        @PostMapping("/save/{idactif}")
        public Actif saveBordeaux(@RequestBody Actif actif,@PathVariable Long idactif
                                  ){

            Type type= itype.findOne( idactif );
            actif.setCategorie( type );
            return iactif.save(actif);
        }

    @PostMapping("/save1")
    public Actif saveactif(@RequestBody Actif a){
        return iactif.save(a);
    }
}
