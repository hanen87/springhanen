package carrefour.portailrh.Controlleur;

import carrefour.portailrh.dao.IAuthority;
import carrefour.portailrh.dao.IDemande;
import carrefour.portailrh.dao.IGRH;
import carrefour.portailrh.models.*;
import carrefour.portailrh.utils.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/users/gestionnaires")
public class GrhController {

    @Autowired
    private IGRH igrh;

    @Autowired
    private StorageService storage;

    @Autowired
    private IAuthority iAuthority;

    @GetMapping("/all")
    public List<GRH> listeGrhs(){
        return igrh.findAll();
    }

    @PostMapping("/save")
    public GRH saveDemande(@RequestBody GRH g){
        return igrh.save(g);
    }
    @PutMapping("/update/{Id}")
    public GRH update(@RequestBody GRH g, @PathVariable Long Id){
        g.setId(Id);
        return igrh.saveAndFlush(g);
    }

   // @RequestMapping("/register")
   // public ResponseEntity<?> register(GRH e, @RequestParam("file") MultipartFile file )
   // {
    // Authority authority=new Authority();
    //  authority.setName("GRH");
    //  iAuthority.save(authority);

    //  e.setEnabled(true);
    //  e.setAuthorities(authority);
    //  e.setPassword(hash(e.getPassword()));
    //  e.setProfil( "GRH" );
    //  storage.store(file);
    //  e.setImage(file.getOriginalFilename());

    //  igrh.save(e);

    //  return ResponseEntity.ok(new UserTokenState(null, 0, e));

    // }

    @DeleteMapping("/delete/{Id}")
    public HashMap<String, String> delete(@PathVariable Long Id){
        HashMap msg=new HashMap();
        try{
            igrh.delete(Id);
            msg.put("etat", "GRH deleted");
            return msg;
        }
        catch (Exception e){
            msg.put("etat", "GRH not deleted");
            return msg;
        }
    }

    String hash(String password) {


        String hashedPassword = null;
        int i = 0;
        while (i < 5) {
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            hashedPassword = passwordEncoder.encode(password);
            i++;
        }

        return hashedPassword;
    }
}
