package carrefour.portailrh.Controlleur;

import carrefour.portailrh.dao.*;
import carrefour.portailrh.models.*;
import carrefour.portailrh.utils.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin("*")

@RequestMapping("/users/reclamations")
public class reclamationController {

    @Autowired
    private IReclamation ireclamation;

    @Autowired
    private IUser iuser;

    @Autowired
    private StorageService storage;

    @Autowired
    private INatureReclamation inature;

    @Autowired
    private IEtablissement ietablissement;

    @GetMapping("/all")
    public List<Reclamation> listeReclamations(){
        return ireclamation.findAll();
    }

    @PostMapping("/save/{iduser}/{idetablissement}/{idnature}")
    public Reclamation saveReclamation(@RequestBody Reclamation r,
                                       @PathVariable long idnature,
                                       @PathVariable long idetablissement,
                                       @PathVariable long iduser){

        NatureReclamation nature= inature.findOne( idnature );
        User user= iuser.findOne( iduser );
        Etablissemnt etablissemnt= ietablissement.findOne( idetablissement );

        r.setDemandeur( user );
        r.setNature( nature );

       // storage.store(file);
       // r.setImage(file.getOriginalFilename());

        r.setEtablisReclamations(etablissemnt);

        return ireclamation.save(r);
    }


    @PutMapping("/update/{Id}")
    public Reclamation update(@RequestBody Reclamation r, @PathVariable Long Id){
        r.setId(Id);
        return ireclamation.saveAndFlush(r);
    }

    @PutMapping("/traiter/{Id}")
    public Reclamation traiter(@RequestBody ReclamationUpdateRequest reclamation ,@PathVariable Long Id){
        Reclamation r= ireclamation.findOne( Id );
        r.setStatus( "traitée" );
        r.setDate_cloture(reclamation.getDate_cloture());
        r.setDate_effet(reclamation.getDate_effet());
        r.setReponse(reclamation.getReponse());
        return ireclamation.saveAndFlush(r);
    }

    @DeleteMapping("/delete/{Id}")
    public HashMap<String, String> delete(@PathVariable Long Id){
        HashMap msg=new HashMap();
        try{
            ireclamation.delete(Id);
            msg.put("etat", "category deleted");
            return msg;
        }
        catch (Exception e){
            msg.put("etat", "category not deleted");
            return msg;
        }
    }
}
