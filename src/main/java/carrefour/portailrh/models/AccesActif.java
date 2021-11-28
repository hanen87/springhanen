package carrefour.portailrh.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class AccesActif {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String motif;
    private String status;
    private String date;
    private String categorie;
    private String pour;
    private String type;
    private String remarque;
    private String matricule;
    private String nom;
    private String prenom;
    private String reference;

    @ManyToOne
    @JoinColumn(name="id_user")
    private User user;


    @ManyToMany
    @JsonProperty
    @Column
    private List<ActifAccessLigne> actifs;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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


    public List<ActifAccessLigne> getActifs() {
        return actifs;
    }

    public void setActifs(List<ActifAccessLigne> actifs) {
        this.actifs = actifs;
    }

    public String getRemarque() {
        return remarque;
    }

    public void setRemarque(String remarque) {
        this.remarque = remarque;
    }

    public void addLigne(ActifAccessLigne actif) {
        if(actifs == null) {
            actifs = new ArrayList<>();
        }
        actifs.add(actif);

    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }
}
