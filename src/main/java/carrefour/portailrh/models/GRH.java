package carrefour.portailrh.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.Collection;

@Entity
public class GRH extends User{

    @ManyToOne
    @JoinColumn(name = "id_etablissement")
    private Etablissemnt etablissemnt;


    @OneToMany(mappedBy = "responsable")
    private Collection<Type> types;

}
