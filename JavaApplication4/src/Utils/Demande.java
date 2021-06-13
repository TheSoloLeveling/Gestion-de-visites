/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;
import java.util.Date;
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
    private Date date;
    private int time;
    private String entreprise;
    private String etat;

    public Demande(String id, String nom, String prenom, String cnie, Date date, int time, String entreprise , String etat) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.cnie = cnie;
        this.date = date;
        this.time = time;
        this.entreprise = entreprise;
        this.etat=etat; 
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
       public String getEtat() {
        return etat;
    }

    public Date getDate() {
        return date;
    }

    public int getTime() {
        return time;
    }
    
    public String getEntreprise() {
        return entreprise;
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

    public void setDate(Date date) {
        this.date = date;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public void setEntreprise(String entreprise) {
        this.entreprise = entreprise;
    }

    @Override
    public String toString() {
        return "Demande{" + "id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", cnie=" + cnie + ", date=" + date + ", time=" + time + ", entreprise=" + entreprise + '}';
    }

 
}






