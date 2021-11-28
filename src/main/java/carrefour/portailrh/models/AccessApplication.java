package carrefour.portailrh.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
public class AccessApplication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
   // private String magasin;
    private String profil;
    private String date_effect;
    private String date_annulation;
    private String date;
    private String reponse;
    private String status;
    private String pour;
    private String type;
    private String date_validation;
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
    private List<AccessApplicationLigne> applicationns;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    //public String getMagasin() {
       // return magasin;
    //}

    //public void setMagasin(String magasin) {
      //  this.magasin = magasin;
    //}

    public String getProfil() {
        return profil;
    }

    public void setProfil(String profil) {
        this.profil = profil;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getDate_effect() {
        return date_effect;
    }

    public void setDate_effect(String date_effect) {
        this.date_effect = date_effect;
    }

    public String getDate_annulation() {
        return date_annulation;
    }

    public void setDate_annulation(String date_annulation) {
        this.date_annulation = date_annulation;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getReponse() {
        return reponse;
    }

    public void setReponse(String reponse) {
        this.reponse = reponse;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public List<AccessApplicationLigne> getApplicationns() {
        return applicationns;
    }

    public void setApplicationns(List<AccessApplicationLigne> applicationns) {
        this.applicationns = applicationns;
    }

    public void addLigne(AccessApplicationLigne application) {
        if(applicationns == null) {
            applicationns = new ArrayList<>();
        }
        applicationns.add(application);

    }

    public String getDate_validation() {
        return date_validation;
    }

    public void setDate_validation(String date_validation) {
        this.date_validation = date_validation;
    }

    public String getRemarque() {
        return remarque;
    }

    public void setRemarque(String remarque) {
        this.remarque = remarque;
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
