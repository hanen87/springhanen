package carrefour.portailrh.dao;

import carrefour.portailrh.models.ActifAccessLigne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IActifAccessLigne extends JpaRepository<ActifAccessLigne,Long> {
}
