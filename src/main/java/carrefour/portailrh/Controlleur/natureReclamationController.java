package carrefour.portailrh.Controlleur;

import carrefour.portailrh.dao.IApplication;
import carrefour.portailrh.dao.IGRH;
import carrefour.portailrh.dao.INatureReclamation;
import carrefour.portailrh.models.Application;
import carrefour.portailrh.models.GRH;
import carrefour.portailrh.models.NatureReclamation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/users/natureReclamtions")
public class natureReclamationController {

    @Autowired
    private INatureReclamation inatureReclamation;

    @Autowired
    private IGRH igrh;

    @GetMapping("/all")
    public List<NatureReclamation> listnatures(){
        return inatureReclamation.findAll();
    }

    @PostMapping("/save")
    public NatureReclamation saveNature(@RequestBody NatureReclamation c){


        //GRH grh= igrh.getOne( iduser );
       // c.setResponsable( grh );
        return inatureReclamation.save(c);
    }
}
