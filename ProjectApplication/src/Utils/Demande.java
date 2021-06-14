/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;
import java.sql.Date;
import java.time.LocalTime;
import java.text.DateFormat;
import java.sql.Time;
/**
 *
 * @author yassine
 */
public class Demande {
    private String id;
    private String nom;
    private String prenom;
    private String cnie;
    private Date dateB;
    private Date dateE;
    private String time;
    private String ue;
    private String entreprise;
    private boolean etat;

    public Demande(String nom, String prenom, String cnie, Date dateB, Date dateE, String time, String ue, String entreprise, boolean etat) {
        this.nom = nom;
        this.prenom = prenom;
        this.cnie = cnie;
        this.dateB = dateB;
        this.dateE = dateE;
        this.time = time;
        this.ue = ue;
        this.entreprise = entreprise;
        this.etat = etat;
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

    public Date getDateB() {
        return dateB;
    }
    
    public Date getDateE() {
        return dateE;
    }

    public String getTime() {
        return time;
    }
    
    public String getEntreprise() {
        return entreprise;
    }

    public String getUe() {
        return ue;
    }

    public boolean isEtat() {
        return etat;
    }

    
}






