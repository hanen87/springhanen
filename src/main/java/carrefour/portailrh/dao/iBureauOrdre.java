package carrefour.portailrh.dao;

import carrefour.portailrh.models.Bureau_Ordre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface iBureauOrdre extends JpaRepository<Bureau_Ordre,Long>{
}
