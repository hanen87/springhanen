package carrefour.portailrh.Controlleur;

import carrefour.portailrh.dao.IAuthority;
import carrefour.portailrh.dao.IDemande;
import carrefour.portailrh.dao.IEmploye;
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
@RequestMapping("/users/employes")
public class employeController {

    @Autowired
    private IEmploye iemploye;

    @Autowired
    private StorageService storage;

    @Autowired
    private IAuthority iAuthority;

    @GetMapping("/all")
    public List<Employee> listeEmployees(){
        return iemploye.findAll();
    }

    @PostMapping("/save")
    public Employee saveEmploye(@RequestBody Employee e){
        return iemploye.save(e);
    }
    @PutMapping("/update/{Id}")
    public Employee update(@RequestBody Employee e, @PathVariable Long Id){
        e.setId(Id);
        return iemploye.saveAndFlush(e);
    }

    @DeleteMapping("/delete/{Id}")
    public HashMap<String, String> delete(@PathVariable Long Id){
        HashMap msg=new HashMap();
        try{
            iemploye.delete(Id);
            msg.put("etat", "category deleted");
            return msg;
        }
        catch (Exception e){
            msg.put("etat", "category not deleted");
            return msg;
        }
    }

    //@RequestMapping("/register")
   // public ResponseEntity<?> register(Employee e, @RequestParam("file") MultipartFile file )
   // {
    //    Authority authority=new Authority();
     //   authority.setName("Employee");
      //  iAuthority.save(authority);

      //  e.setEnabled(true);
      //  e.setAuthorities(authority);
      //  e.setPassword(hash(e.getPassword()));
       // storage.store(file);
      //  e.setImage(file.getOriginalFilename());

       // iemploye.save(e);

      //  return ResponseEntity.ok(new UserTokenState(null, 0, e));

   // }

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
