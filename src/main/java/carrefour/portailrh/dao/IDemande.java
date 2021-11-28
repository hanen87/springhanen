package carrefour.portailrh.dao;

import carrefour.portailrh.models.Demande;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IDemande extends JpaRepository<Demande,Long>{

//    @Query("select m from Demande m where m.name like :x")
//    List<Demande> chercherDemande(@Param("x") String x);
//
//
//    @Query("select m from Demande m where m.subCategory.id =:x")
//    List<Demande> chercherByCategorie(@Param("x") Long x);
//
//    @Query("select m from Demande m ")
//    Page<Demande> findbypage(Pageable pageable);
}
