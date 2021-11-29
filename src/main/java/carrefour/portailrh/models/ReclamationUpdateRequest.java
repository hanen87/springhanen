package carrefour.portailrh.models;

public class ReclamationUpdateRequest {

    private String reponse;
    private String date_cloture;
    private String date_effet;

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
}
