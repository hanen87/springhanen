package carrefour.portailrh.models;

import javax.persistence.*;

@Entity
public class uniteOrganisationnelle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "id_etablissement")
    private Etablissemnt etablissementUnite;
}
