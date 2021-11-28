package carrefour.portailrh.dao;

import carrefour.portailrh.models.Reclamation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IReclamation extends JpaRepository<Reclamation,Long> {
}
