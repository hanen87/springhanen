package carrefour.portailrh.models;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Type {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String categorie;
    private String libelle;

    @ManyToOne
    @JoinColumn(name = "id_responsable")
    private GRH responsable;




    @OneToMany(mappedBy = "categorie")
    private Collection<Actif> actifs;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }



    public GRH getResponsable() {
        return responsable;
    }

    public void setResponsable(GRH responsable) {
        this.responsable = responsable;
    }
}
