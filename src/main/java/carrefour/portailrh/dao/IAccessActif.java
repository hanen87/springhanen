package carrefour.portailrh.dao;

import carrefour.portailrh.models.AccesActif;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAccessActif extends JpaRepository<AccesActif,Long> {
}
