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
    private int idSite;
    
    
    public ResponsableSite(String nom, String prenom, String email, String login, String motDePasse, String telephone, int idSite) {
        super(nom, prenom, email, login, motDePasse);
        this.telephone = telephone;
        this.idSite = idSite;
        
    }

    public String getTelephone() {
        return telephone;
    }

    public int getIdSite() {
        return idSite;
    }
    
    
}
