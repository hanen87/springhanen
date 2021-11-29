package carrefour.portailrh.dao;

import carrefour.portailrh.models.Etablissemnt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEtablissement extends JpaRepository<Etablissemnt,Long> {
}
