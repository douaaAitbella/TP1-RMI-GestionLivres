import java.io.Serializable;

public class Livre implements Serializable {

    private int id;
    private String titre;
    private String auteur;
    private double prix;

    public Livre(int id, String titre, String auteur, double prix) {
        this.id = id;
        this.titre = titre;
        this.auteur = auteur;
        this.prix = prix;
    }

    public int getId() {
        return id;
    }

    public String getTitre() {
        return titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public double getPrix() {
        return prix;
    }

    public String toString() {
        return "ID: " + id + " | Titre: " + titre + " | Auteur: " + auteur + " | Prix: " + prix;
    }
}