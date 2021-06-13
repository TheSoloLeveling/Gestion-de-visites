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
public class Guerite extends Compte {
    
    private String date;
    private int cin;
    
    public Guerite(String nom, String prenom, String email, String login, String motDePasse, String date, int cin) {
        super(nom, prenom, email, login, motDePasse);
        this.date = date;
        this.cin = cin;
        
    }

    public String getDate() {
        return date;
    }

    public int getCin() {
        return cin;
    }

    
    
    
    
}
