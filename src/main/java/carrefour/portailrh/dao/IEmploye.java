package carrefour.portailrh.dao;

import carrefour.portailrh.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmploye extends JpaRepository<Employee,Long> {
}
