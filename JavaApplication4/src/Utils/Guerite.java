/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.sql.Date;

/**
 *
 * @author yassine
 */
public class Guerite extends Compte {
    
    private Date date;
    private String cin;
    
    public Guerite(String nom, String prenom, String email, String login, String motDePasse, Date date, String cin) {
        super(nom, prenom, email, login, motDePasse);
        this.date = date;
        this.cin = cin;
        
    }

    public Date getDate() {
        return date;
    }

    public String getCin() {
        return cin;
    }

    
    
    
    
}
