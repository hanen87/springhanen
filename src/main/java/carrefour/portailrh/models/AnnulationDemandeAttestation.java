package carrefour.portailrh.models;

public class AnnulationDemandeAttestation {

    private String motif_annulation;
    private String commentaire_annulation;

    public String getMotif_annulation() {
        return motif_annulation;
    }

    public void setMotif_annulation(String motif_annulation) {
        this.motif_annulation = motif_annulation;
    }

    public String getCommentaire_annulation() {
        return commentaire_annulation;
    }

    public void setCommentaire_annulation(String commentaire_annulation) {
        this.commentaire_annulation = commentaire_annulation;
    }
}
