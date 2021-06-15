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
public class UserEntreprise extends Compte{
    
    private String telephone;
    private boolean etat;
    
    public UserEntreprise(String nom, String prenom, String email, String login, String motDePasse, String telephone, boolean etat) {
        super(nom, prenom, email, login, motDePasse);
        this.telephone = telephone;
        this.etat = etat;
    }

    public String getTelephone() {
        return telephone;
    }

    public boolean isEtat() {
        return etat;
    }
    
    
}
