package carrefour.portailrh.dao;

import carrefour.portailrh.models.SousBordereaux;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISousBordeaureu extends JpaRepository<SousBordereaux,Long> {
}
