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
public class Site {
     
     private int id;
     private String nom;
     private String enreptrise;
     private int capacite;

    public Site(String nom, String enreptrise, int capacite) {
        this.nom = nom;
        this.enreptrise = enreptrise;
        this.capacite = capacite;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getEnreptrise() {
        return enreptrise;
    }

    public int getCapacite() {
        return capacite;
    }
    
    
}
