package carrefour.portailrh;

import carrefour.portailrh.dao.IAuthority;
import carrefour.portailrh.dao.IUser;
import carrefour.portailrh.models.Authority;
import carrefour.portailrh.models.User;
import carrefour.portailrh.utils.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
@EnableJpaAuditing
public class PortailrhApplication implements CommandLineRunner {

    @Autowired
    private StorageService storage;

    @Autowired
    private IUser iUser;

    @Autowired
    private IAuthority iAuthority;


    public static void main(String[] args) {
        SpringApplication.run(PortailrhApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        // storage.init();

//       Authority authority=new Authority();
//        authority.setName("Admin");
//        iAuthority.save(authority);
//
//
//        User user = new User();
//        user.setFirstName("hanen");
//        user.setLastName("hnen");
//        user.setUsername("admin");
//        user.setPassword(hash("admin"));
//        user.setEnabled(true);
//        user.setEtablissement( "informatique" );
//        user.setProfil( "ADMIN" );
//        user.setEquipe( "Social" );
//        user.setDate_contrat( "2020-12-02" );
//        user.setAuthorities(authority);
//        iUser.save(user);


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
