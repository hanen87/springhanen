package carrefour.portailrh.models;


import javax.persistence.*;

@Entity
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long   id;
    private String readable;
    private String date;
    private String etat;

    @ManyToOne
    @JoinColumn(name="id_ligne")
    private LigneAttestation ligne;





    public String getReadable() {
        return readable;
    }

    public void setReadable(String readable) {
        this.readable = readable;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LigneAttestation getLigne() {
        return ligne;
    }

    public void setLigne(LigneAttestation ligne) {
        this.ligne = ligne;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }
}
