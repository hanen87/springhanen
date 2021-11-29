package carrefour.portailrh.dao;

import carrefour.portailrh.models.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface iType extends JpaRepository<Type,Long> {
}
