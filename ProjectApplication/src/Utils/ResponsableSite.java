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
public class ResponsableSite extends Compte {
    
    private String telephone;
    
    
    public ResponsableSite(String nom, String prenom, String email, String login, String motDePasse, String telephone) {
        super(nom, prenom, email, login, motDePasse);
        this.telephone = telephone;
        
    }

    public String getTelephone() {
        return telephone;
    }
    
    
}
