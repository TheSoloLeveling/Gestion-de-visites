/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javaapplication4.TableController;

/**
 *
 * @author yassine
 */
public class Crud {
        
    
    public static void addUser(String table, Compte c){
        
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        if (table.equals("userentreprise")){
            try{
            UserEntreprise u = (UserEntreprise) c;
            String sql = "INSERT INTO " + table +
                                    " VALUES (null, ?, ?, ?, ?, ?, ?, ?); ";
            conn = SingletonConnection.getconn();
            ps = conn.prepareStatement(sql);
            ps.setString(1, u.getNom());
            ps.setString(2, u.getPrenom());
            ps.setString(3, u.getEmail());
            ps.setString(4, u.getLogin());
            ps.setString(5, u.getMotDePasse());
            ps.setString(6, u.getTelephone());
            ps.setBoolean(7, u.isEtat());
            ps.executeUpdate();
                                        
        }catch(Exception e){
            e.printStackTrace();
        }
        }
        
        if (table.equals("superadmin")){
            try{
            SuperAdmin u = (SuperAdmin) c;
            String sql = "INSERT INTO " + table +
                                    " VALUES (null, ?, ?, ?, ?, ?, ?); ";
            conn = SingletonConnection.getconn();
            ps = conn.prepareStatement(sql);
            ps.setString(1, u.getNom());
            ps.setString(2, u.getPrenom());
            ps.setString(3, u.getEmail());
            ps.setString(4, u.getLogin());
            ps.setString(5, u.getMotDePasse());
            ps.setString(6, u.getTelephone());
            ps.executeUpdate();
                                        
        }catch(Exception e){
            e.printStackTrace();
        }   
        }
        
        if (table.equals("responsablesite")){
            try{
            ResponsableSite u = (ResponsableSite) c;
            String sql = "INSERT INTO " + table +
                                    " VALUES (null, ?, ?, ?, ?, ?, ?, ?); ";
            conn = SingletonConnection.getconn();
            ps = conn.prepareStatement(sql);
            ps.setString(1, u.getNom());
            ps.setString(2, u.getPrenom());
            ps.setString(3, u.getEmail());
            ps.setString(4, u.getLogin());
            ps.setString(5, u.getMotDePasse());
            ps.setString(6, u.getTelephone());
            ps.setInt(7, u.getIdSite());
            ps.executeUpdate();
                                        
        }catch(Exception e){
            e.printStackTrace();
        }   
        }
        
        if (table.equals("admin")){
            try{
            Admin u = (Admin) c;
            String sql = "INSERT INTO " + table +
                                    " VALUES (null, ?, ?, ?, ?, ?, ?, ?); ";
            conn = SingletonConnection.getconn();
            ps = conn.prepareStatement(sql);
            ps.setString(1, u.getNom());
            ps.setString(2, u.getPrenom());
            ps.setString(3, u.getEmail());
            ps.setString(4, u.getLogin());
            ps.setString(5, u.getMotDePasse());
            ps.setString(6, u.getTelephone());
            ps.setInt(7, u.getIdSite());
            ps.executeUpdate();
                                        
        }catch(Exception e){
            e.printStackTrace();
        }   
        }
        
        if (table.equals("guerite")){
            try{
            Guerite u = (Guerite) c;
            String sql = "INSERT INTO " + table +
                                    " VALUES (null, ?, ?, ?, ?, ?, ?, ?); ";
            conn = SingletonConnection.getconn();
            ps = conn.prepareStatement(sql);
            ps.setString(1, u.getNom());
            ps.setString(2, u.getPrenom());
            ps.setString(3, u.getEmail());
            ps.setString(4, u.getLogin());
            ps.setString(5, u.getMotDePasse());
            ps.setString(6, u.getDate());
            ps.setInt(7, u.getCin());
            ps.executeUpdate();
                                        
        }catch(Exception e){
            e.printStackTrace();
        }   
        }
    }
    
    public static void removeUser(String table, String login){
        
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try{
        String sql = "DELETE FROM " + table + " WHERE login = ?";
        conn = SingletonConnection.getconn();
        ps = conn.prepareStatement(sql);
        ps.setString(1, login);
        
        ps.executeUpdate();

        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public static void updateUser(String table, String login, Compte c){
        
         Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        if (table.equals("userentreprise")){
            try{
            UserEntreprise u = (UserEntreprise) c;
            String sql = "update " + table +
                    " set nom = ?, prenom = ?, email = ?,"
                    + "login = ?, motDePasse = ?, telephone = ? where login = ?";
            conn = SingletonConnection.getconn();
            ps = conn.prepareStatement(sql);
            ps.setString(1, u.getNom());
            ps.setString(2, u.getPrenom());
            ps.setString(3, u.getEmail());
            ps.setString(4, u.getLogin());
            ps.setString(5, u.getMotDePasse());
            ps.setString(6, u.getTelephone());
            ps.setString(7, login);
            ps.executeUpdate();
                                        
        }catch(Exception e){
            e.printStackTrace();
        }
        }
        
        if (table.equals("admin")){
            try{
            UserEntreprise u = (UserEntreprise) c;
            String sql = "update " + table +
                    " set nom = ?, prenom = ?, email = ?,"
                    + "login = ?, motDePasse = ?, telephone = ? where login = ?";
            conn = SingletonConnection.getconn();
            ps = conn.prepareStatement(sql);
            ps.setString(1, u.getNom());
            ps.setString(2, u.getPrenom());
            ps.setString(3, u.getEmail());
            ps.setString(4, u.getLogin());
            ps.setString(5, u.getMotDePasse());
            ps.setString(6, u.getTelephone());
            ps.setString(7, login);
            ps.executeUpdate();
                                        
        }catch(Exception e){
            e.printStackTrace();
        }
        }
        
        
    }
        
}
