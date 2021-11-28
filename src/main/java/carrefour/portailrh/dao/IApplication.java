package carrefour.portailrh.dao;

import carrefour.portailrh.models.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IApplication extends JpaRepository<Application,Long> {
}
