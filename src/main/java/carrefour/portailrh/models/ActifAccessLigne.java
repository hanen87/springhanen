package carrefour.portailrh.models;

import javax.persistence.*;

@Entity
public class ActifAccessLigne {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String motif;
    private String status;
    private String date;
    private String categorie;
    private String pour;
    private String type;

    @ManyToOne
    @JoinColumn(name="id_user")
    private User user;

    @ManyToOne
    private Actif actif;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getPour() {
        return pour;
    }

    public void setPour(String pour) {
        this.pour = pour;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Actif getActif() {
        return actif;
    }

    public void setActif(Actif actif) {
        this.actif = actif;
    }
}
