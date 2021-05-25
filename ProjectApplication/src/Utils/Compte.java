package Utils;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.sql.*;
import javaapplication4.MainController;
import javafx.scene.control.Alert;
import javafx.scene.paint.Color;


/**
 *
 * @author yassine
 */
public class Compte {
    private int id;
    private String nom;
    private String prenom;
    private String email;
    private String login;
    private String motDePasse;

    public Compte(String nom, String prenom, String email, String login, String motDePasse) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.login = login;
        this.motDePasse = motDePasse;
    }
    
    /*public static void RefreshListComptes(String Username, String Password){
        
        MainController.listComptes.removeAll(MainController.listComptes);
        String sql = "SELECT * FROM compte";
        
        Connection conn = null;
        Statement ps = null;
        ResultSet rs = null;
        
        try{
            conn = SingletonConnection.getconn();
            ps = conn.createStatement();
            rs = ps.executeQuery(sql);
            if(!rs.next()){
               int id = rs.getInt(1);
               String nom = rs.getString(2);
               String prenom = rs.getString(3);
               String email = rs.getString(4);
               String login = rs.getString(5);
               String pwd = rs.getString(6);
               
               Compte c = new Compte(id, nom, prenom, email, login, pwd);
               MainController.listComptes.add(c);   
            }
        }catch(Exception e){
            e.printStackTrace();    
        }
        
    }*/

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getEmail() {
        return email;
    }

    public String getLogin() {
        return login;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }
    
    
    
}
