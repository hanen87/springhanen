package carrefour.portailrh.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Borderaeu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String Etablissement;
    private String date_validation;
    private String reference;
    private String equipe;
    private String observation;
    private String date_courrier;
    private String etat;

    @ManyToOne
    @JoinColumn(name="id_bureau_ordre")
    private Bureau_Ordre bureau_ordre;


    @ManyToMany
    @JsonProperty
    @Column
    private List<SousBordereaux> sousbordeaur;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEtablissement() {
        return Etablissement;
    }

    public void setEtablissement(String etablissement) {
        Etablissement = etablissement;
    }

    public String getDate_validation() {
        return date_validation;
    }

    public void setDate_validation(String date_validation) {
        this.date_validation = date_validation;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getEquipe() {
        return equipe;
    }

    public void setEquipe(String equipe) {
        this.equipe = equipe;
    }

    public void addSousBordeau(SousBordereaux sb) {
        if(sousbordeaur == null) {
            sousbordeaur = new ArrayList<>();
        }
        sousbordeaur.add(sb);

    }

    public Bureau_Ordre getBureau_ordre() {
        return bureau_ordre;
    }

    public void setBureau_ordre(Bureau_Ordre bureau_ordre) {
        this.bureau_ordre = bureau_ordre;
    }

    public List<SousBordereaux> getSousbordeaur() {
        return sousbordeaur;
    }

    public void setSousbordeaur(List<SousBordereaux> sousbordeaur) {
        this.sousbordeaur = sousbordeaur;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public String getDate_courrier() {
        return date_courrier;
    }

    public void setDate_courrier(String date_courrier) {
        this.date_courrier = date_courrier;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }
}
