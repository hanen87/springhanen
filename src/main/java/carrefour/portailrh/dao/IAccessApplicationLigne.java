package carrefour.portailrh.dao;

import carrefour.portailrh.models.AccessApplicationLigne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAccessApplicationLigne extends JpaRepository<AccessApplicationLigne,Long> {

}
