package carrefour.portailrh.dao;

import carrefour.portailrh.models.Borderaeu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBordeaureaux extends JpaRepository<Borderaeu,Long> {
}
