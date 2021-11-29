package carrefour.portailrh.models;

import javax.persistence.*;

@Entity
public class LigneAttestation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;
    private String motif;
    private String date;
    private String commentaire;
    private String status;
    private String reference;
    private String equipe;
    private String etablissement;
    private String matricule;
    private String date_annulation;
    private String commentaire_annulation;
    private String date_validation;
    private String motif_blocage;
    private String date_contrat;
    private String nom;

    @ManyToOne
    @JoinColumn(name="id_validateur")
    private User validateur;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }



    public User getDemandeur() {
        return demandeur;
    }

    public void setDemandeur(User demandeur) {
        this.demandeur = demandeur;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    @ManyToOne
    @JoinColumn(name="id_demandeur")
    private User demandeur;

    public User getValidateur() {
        return validateur;
    }

    public void setValidateur(User validateur) {
        this.validateur = validateur;
    }

    public String getDate_annulation() {
        return date_annulation;
    }

    public void setDate_annulation(String date_annulation) {
        this.date_annulation = date_annulation;
    }

    public String getCommentaire_annulation() {
        return commentaire_annulation;
    }

    public void setCommentaire_annulation(String commentaire_annulation) {
        this.commentaire_annulation = commentaire_annulation;
    }

    public String getDate_validation() {
        return date_validation;
    }

    public void setDate_validation(String date_validation) {
        this.date_validation = date_validation;
    }

    public String getMotif_blocage() {
        return motif_blocage;
    }

    public void setMotif_blocage(String motif_blocage) {
        this.motif_blocage = motif_blocage;
    }

    public String getEquipe() {
        return equipe;
    }

    public void setEquipe(String equipe) {
        this.equipe = equipe;
    }


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

    public String getDate_contrat() {
        return date_contrat;
    }

    public void setDate_contrat(String date_contrat) {
        this.date_contrat = date_contrat;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
