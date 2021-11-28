package carrefour.portailrh.Controlleur;

import carrefour.portailrh.dao.ILigneAttzstation;
import carrefour.portailrh.dao.INotification;
import carrefour.portailrh.dao.IReclamation;
import carrefour.portailrh.dao.IUser;
import carrefour.portailrh.models.LigneAttestation;
import carrefour.portailrh.models.Notification;
import carrefour.portailrh.models.Reclamation;
import carrefour.portailrh.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/users/notifications")
public class NotificationController {
    @Autowired
    private INotification inotification;

    @Autowired
    private ILigneAttzstation iligneAttestation;



    @Autowired
    private IUser iUser;

    ArrayList liste = new ArrayList();


    @PostMapping("/save/{idligne}")
    public Notification notification(@PathVariable Long idligne,
                                     @RequestBody Notification notification ) {

        LigneAttestation ligne= iligneAttestation.findOne( idligne );
        notification.setLigne( ligne );
        notification.setEtat(("Annulation"));
        return inotification.save(notification);
    }

    @PostMapping("/save1/{idligne}")
    public Notification notification1(@PathVariable Long idligne,
                                     @RequestBody Notification notification ) {

        LigneAttestation ligne= iligneAttestation.findOne( idligne );
        notification.setLigne( ligne );
        notification.setEtat("Validation");
        return inotification.save(notification);
    }



    @GetMapping("/all")
    public List<Notification> getAllnotification() {
        return inotification.findAll();
    }
}
