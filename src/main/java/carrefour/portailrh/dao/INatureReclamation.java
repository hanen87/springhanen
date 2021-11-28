package carrefour.portailrh.dao;

import carrefour.portailrh.models.NatureReclamation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface INatureReclamation extends JpaRepository<NatureReclamation,Long> {
}
