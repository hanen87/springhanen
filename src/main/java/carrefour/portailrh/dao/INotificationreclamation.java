package carrefour.portailrh.dao;

import carrefour.portailrh.models.Notification;
import carrefour.portailrh.models.Notificationreclamation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface INotificationreclamation  extends JpaRepository<Notificationreclamation,Long> {
}
