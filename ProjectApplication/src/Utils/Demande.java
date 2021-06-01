/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

/**
 *
 * @author yassine
 */
public class Demande {
    private String id;
    private String nom;
    private String prenom;
    private String cnie;
    private String date;
    private String time;
    private String entreprise;

    public Demande(String nom, String prenom, String cnie, String date, String time, String entreprise) {
        this.nom = nom;
        this.prenom = prenom;
        this.cnie = cnie;
        this.date = date;
        this.time = time;
        this.entreprise = entreprise;
    }

    public String getId() {
        return id;
    }

    
    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getCnie() {
        return cnie;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }
    
    public String getEntreprise() {
        return entreprise;
    }
    
}






