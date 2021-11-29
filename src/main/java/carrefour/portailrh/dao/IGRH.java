package carrefour.portailrh.dao;

import carrefour.portailrh.models.GRH;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IGRH  extends JpaRepository<GRH,Long>{
}
