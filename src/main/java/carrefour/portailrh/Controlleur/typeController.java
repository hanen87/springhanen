package carrefour.portailrh.Controlleur;

import carrefour.portailrh.dao.IActif;
import carrefour.portailrh.dao.iType;
import carrefour.portailrh.models.Actif;
import carrefour.portailrh.models.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/users/types")
public class typeController {

    @Autowired
    private iType itype;

    @GetMapping("/all")
    public List<Type> listType(){
        return itype.findAll();
    }

    @PostMapping("/save")
    public Type saveType(@RequestBody Type c){
        return itype.save(c);
    }
}
