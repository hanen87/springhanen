package carrefour.portailrh.models;

import javax.persistence.*;

@Entity
public class NatureReclamation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long   id;
    private String nature;

    @ManyToOne
    @JoinColumn(name = "id_responsable")
    private GRH responsable;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNature() {
        return nature;
    }

    public void setNature(String nature) {
        this.nature = nature;
    }

    public GRH getResponsable() {
        return responsable;
    }

    public void setResponsable(GRH responsable) {
        this.responsable = responsable;
    }
}
