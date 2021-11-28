package carrefour.portailrh.dao;

import carrefour.portailrh.models.AccessApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

@Repository
public interface IAccessApplication extends JpaRepository<AccessApplication,Long>{
}
