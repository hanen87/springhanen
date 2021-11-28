package carrefour.portailrh.dao;

import carrefour.portailrh.models.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface INotification extends JpaRepository<Notification,Long> {
}
