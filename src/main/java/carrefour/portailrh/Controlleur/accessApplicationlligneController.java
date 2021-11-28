package carrefour.portailrh.Controlleur;

import carrefour.portailrh.dao.*;
import carrefour.portailrh.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;


@CrossOrigin("*")
@RequestMapping("/users/accessligneapplication")
@RestController
public class accessApplicationlligneController {

    @Autowired
    private IAccessApplicationLigne iacces;

    @Autowired
    private IUser iuser;

    @Autowired
    private IApplication iapplication;

    @GetMapping("/all")
    public List<AccessApplicationLigne> listAccess(){
        return iacces.findAll();
    }

    @PostMapping("/save/{iduser}/{idApplication}")
    public AccessApplicationLigne saveBordeau(@RequestBody AccessApplicationLigne demande,
                                   @PathVariable Long iduser,
                                   @PathVariable Long idApplication

    ){

        User user= iuser.findOne(iduser);
        Application app= iapplication.findOne(idApplication);
        demande.setUser(user);
        demande.setApplication(app);
        return iacces.save(demande);
    }



    @DeleteMapping("/delete/{Id}")
    public HashMap<String, String> delete(@PathVariable Long Id){
        HashMap msg=new HashMap();
        try{
            iacces.delete(Id);
            msg.put("etat", "ligne demandee application is deleted");
            return msg;
        }
        catch (Exception e){
            msg.put("etat", "ligne demande  application is not deleted");
            return msg;
        }
    }
}
