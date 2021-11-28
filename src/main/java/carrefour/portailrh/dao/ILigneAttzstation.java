package carrefour.portailrh.dao;

import carrefour.portailrh.models.LigneAttestation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILigneAttzstation extends JpaRepository<LigneAttestation,Long> {

}
