package carrefour.portailrh.Controlleur;

import carrefour.portailrh.dao.INotification;
import carrefour.portailrh.dao.INotificationreclamation;
import carrefour.portailrh.dao.IReclamation;
import carrefour.portailrh.models.Notification;
import carrefour.portailrh.models.Notificationreclamation;
import carrefour.portailrh.models.Reclamation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/users/notificationreclamation")
public class notificationreclamationController {
    @Autowired
    private IReclamation ireclamation;

    @Autowired
    private INotificationreclamation inotification;

    @PostMapping("/save/{idreclamation}")
    public Notificationreclamation notificationreclamation(@PathVariable Long idreclamation,
                                                           @RequestBody Notificationreclamation notification ) {

        Reclamation reclamation= ireclamation.findOne( idreclamation );
        notification.setReclamation(reclamation);

        return inotification.save(notification);
    }

    @GetMapping("/all")
    public List<Notificationreclamation> getAllnotification() {
        return inotification.findAll();
    }
}
