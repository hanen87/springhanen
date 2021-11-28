package carrefour.portailrh.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Etablissemnt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @JsonIgnore
    public Collection<GRH> getGrhs() {
        return grhs;
    }

    public void setGrhs(Collection<GRH> grhs) {
        this.grhs = grhs;
    }

    @JsonIgnore
    public Collection<Reclamation> getReclamations() {
        return reclamations;
    }

    public void setReclamations(Collection<Reclamation> reclamations) {
        this.reclamations = reclamations;
    }

    @JsonIgnore
    public Collection<uniteOrganisationnelle> getUnites() {
        return unites;
    }

    public void setUnites(Collection<uniteOrganisationnelle> unites) {
        this.unites = unites;
    }

    @OneToMany(mappedBy = "etablissemnt")
    private Collection<GRH> grhs;

    @OneToMany(mappedBy = "etablissement")
    private Collection<User> users;


    @OneToMany(mappedBy = "etablisReclamations")
    private Collection<Reclamation> reclamations;


    @OneToMany(mappedBy = "etablissementUnite")
    private Collection<uniteOrganisationnelle> unites;
}
