/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.util.Date;

/**
 *
 * @author hp
 */
public class DemandeRef {
    
       public String id;
    public String nom;
    public String prenom;
    public String cnie;
   // public Date date;
    public int time;
    public String entreprise;
      public String etat;

    public DemandeRef() {
            this.id = "";
        this.nom = "";
        this.prenom = "";
        this.cnie = "";
   this.etat="" ;
        this.time =0;
        this.entreprise ="";
    }

    public DemandeRef(String id, String nom, String prenom, String cnie, Date date, int time, String entreprise) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.cnie = cnie;
     //   this.date = date;
        this.time = time;
        this.entreprise = entreprise;
    }

    @Override
    public String toString() {
        return "DemandeRef{" + "id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", cnie=" + cnie + ", time=" + time + ", entreprise=" + entreprise + ", etat=" + etat + '}';
    }

   
    
    
    
}
