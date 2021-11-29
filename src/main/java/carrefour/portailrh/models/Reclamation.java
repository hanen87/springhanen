package carrefour.portailrh.models;

import javax.persistence.*;

@Entity
public class Reclamation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String contenu;
    private String date;
    private String matricule;
    private String reponse;
    private String date_cloture;
    private String date_effet;
    private String status;
    private String reference;
    private String nom;
    private String prenom;

   // private String image;

    @ManyToOne
    @JoinColumn(name = "id_etablissement")
    private Etablissemnt etablisReclamations;

    @ManyToOne
    @JoinColumn(name = "id_demandeur")
    private User demandeur;

    @ManyToOne
    @JoinColumn(name = "id_nature")
    private NatureReclamation nature;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReponse() {
        return reponse;
    }

    public void setReponse(String reponse) {
        this.reponse = reponse;
    }

    public String getDate_cloture() {
        return date_cloture;
    }

    public void setDate_cloture(String date_cloture) {
        this.date_cloture = date_cloture;
    }

    public String getDate_effet() {
        return date_effet;
    }

    public void setDate_effet(String date_effet) {
        this.date_effet = date_effet;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public Etablissemnt getEtablisReclamations() {
        return etablisReclamations;
    }

    public void setEtablisReclamations(Etablissemnt etablisReclamations) {
        this.etablisReclamations = etablisReclamations;
    }

    public User getDemandeur() {
        return demandeur;
    }

    public void setDemandeur(User demandeur) {
        this.demandeur = demandeur;
    }

    public NatureReclamation getNature() {
        return nature;
    }

    public void setNature(NatureReclamation nature) {
        this.nature = nature;
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

   // public String getImage() {
        //return image;
   // }

  //  public void setImage(String image) {
      //  this.image = image;
   // }

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
}
