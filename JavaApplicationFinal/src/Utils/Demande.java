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
    private int etat;

    public Demande(String nom, String prenom, String cnie, Date dateB, Date dateE, String time, String ue, String entreprise, int etat) {
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
    public Demande(String id, String nom, String prenom, String cnie, Date dateB, Date dateE, String time, String ue, String entreprise, int etat) {
        this.id = id;
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
    
    public Demande() {
        
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

    public int isEtat() {
        return etat;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setCnie(String cnie) {
        this.cnie = cnie;
    }

    public void setDateB(Date dateB) {
        this.dateB = dateB;
    }

    public void setDateE(Date dateE) {
        this.dateE = dateE;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setUe(String ue) {
        this.ue = ue;
    }

    public void setEntreprise(String entreprise) {
        this.entreprise = entreprise;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

    @Override
    public String toString() {
        return "Demande{" + "id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", cnie=" + cnie + ", dateB=" + dateB + ", dateE=" + dateE + ", time=" + time + ", ue=" + ue + ", entreprise=" + entreprise + ", etat=" + etat + '}';
    }

    
    
}






