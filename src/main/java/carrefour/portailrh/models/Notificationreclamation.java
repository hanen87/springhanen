package carrefour.portailrh.models;

import javax.persistence.*;
@Entity
public class Notificationreclamation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long   id;
    private String readable;
    private String date;




    @ManyToOne
    @JoinColumn(name="id_reclamation")
    private Reclamation reclamation;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getReadable() {
        return readable;
    }

    public void setReadable(String readable) {
        this.readable = readable;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }



    public Reclamation getReclamation() {
        return reclamation;
    }

    public void setReclamation(Reclamation reclamation) {
        this.reclamation = reclamation;
    }
}
