package carrefour.portailrh.models;

import javax.persistence.*;

@Entity
public class Actif {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "id_type")
    private Type categorie;

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

    public Type getCategorie() {
        return categorie;
    }

    public void setCategorie(Type categorie) {
        this.categorie = categorie;
    }
}
