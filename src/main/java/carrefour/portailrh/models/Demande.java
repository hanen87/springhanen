package carrefour.portailrh.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Demande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;
    private String reference;
    private String etablissement;
    private String date;
    private String matricule;
    private String date_contrat;


    @ManyToMany
    @JsonProperty
    @Column
    private List<LigneAttestation> lignes;

    public String getEtablissement() {
        return etablissement;
    }

    public void setEtablissement(String etablissement) {
        this.etablissement = etablissement;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


    public void addLigne(LigneAttestation ligne) {
        if(lignes == null) {
            lignes = new ArrayList<>();
        }
        lignes.add(ligne);

    }

    public List<LigneAttestation> getLignes() {
        return lignes;
    }

    public void setLignes(List<LigneAttestation> lignes) {
        this.lignes = lignes;
    }

    public String getDate_contrat() {
        return date_contrat;
    }

    public void setDate_contrat(String date_contrat) {
        this.date_contrat = date_contrat;
    }
}
