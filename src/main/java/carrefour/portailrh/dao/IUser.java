package carrefour.portailrh.dao;

import carrefour.portailrh.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
public interface IUser  extends JpaRepository<User,Long> {

    /*@Query("{'username':?0}")*/
     @Query("select u from  User  u where u.username= :username")
    User findByUsername(@Param("username") String username);


    @Query("select u from  User  u where u.matricule= :matricule")
    User findByUsermatricule(@Param("matricule") String matricule);


}
