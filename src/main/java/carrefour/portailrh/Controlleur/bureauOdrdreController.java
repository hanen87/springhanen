package carrefour.portailrh.Controlleur;


import carrefour.portailrh.dao.IApplication;
import carrefour.portailrh.dao.IAuthority;
import carrefour.portailrh.dao.IBordeaureaux;
import carrefour.portailrh.dao.iBureauOrdre;
import carrefour.portailrh.models.*;
import carrefour.portailrh.utils.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/users/bureauorde")
public class bureauOdrdreController {

    @Autowired
    private iBureauOrdre ibureau_ordre;


    @Autowired
    private IAuthority iAuthority;


    @Autowired
    private StorageService storage;

    @GetMapping("/all")
    public List<Bureau_Ordre> listbureau_ordre(){
        return ibureau_ordre.findAll();
    }

    @PostMapping("/save")
    public Bureau_Ordre savebureau_ordre(@RequestBody Bureau_Ordre c){

        return ibureau_ordre.save(c);
    }


   // @RequestMapping("/register")
   // public ResponseEntity<?> register(Bureau_Ordre bo, @RequestParam("file") MultipartFile file )
   //{
    //    Authority authority=new Authority();
    //   authority.setName("BureauOrdre");
    //  iAuthority.save(authority);

    //  bo.setEnabled(true);
    //  bo.setAuthorities(authority);
    //  bo.setPassword(hash(bo.getPassword()));
    //  bo.setProfil( "BureauOrdre" );
    //  storage.store(file);
    // bo.setImage(file.getOriginalFilename());

    // ibureau_ordre.save(bo);

    //  return ResponseEntity.ok(new UserTokenState(null, 0, bo));

    //}

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
