package carrefour.portailrh.models;

import javax.persistence.*;

@Entity
public class AccessApplicationLigne{

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        //private String magasin;
        private String profil;
        private String date;
        private String reponse;
        private String status;
        private String pour;
        private String type;

        @ManyToOne
        @JoinColumn(name="id_user")
        private User user;

        @ManyToOne
        private Application application;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

   // public String getMagasin() {
    //    return magasin;
   // }

  //  public void setMagasin(String magasin) {
    //    this.magasin = magasin;
   // }

    public String getProfil() {
        return profil;
    }

    public void setProfil(String profil) {
        this.profil = profil;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Application getApplication() {
        return application;
    }

    public void setApplication(Application application) {
        this.application = application;
    }

}
