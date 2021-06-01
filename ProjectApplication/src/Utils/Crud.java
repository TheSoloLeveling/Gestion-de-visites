/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
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
            Admin u = (Admin) c;
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
    
    public static int getDemandNumber(){
        
         Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int count = 0;
        
       try{
            String sql = "SELECT COUNT(*) as total FROM demande";
            conn = SingletonConnection.getconn();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                count = rs.getInt("total");
            }
                                            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return count;
    }
    
    public static LinkedList<Demande> getDemands(){
        
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        LinkedList<Demande> t = new LinkedList<>();
        
       try{
            String sql = "SELECT * FROM demande";
            conn = SingletonConnection.getconn();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                String a = rs.getString(1);
                String b = rs.getString(2);
                String c = rs.getString(3);
                String d = rs.getString(4);
                String e = rs.getString(5);
                String f = rs.getString(6);
                
                Demande dem = new Demande(a,b,c,d,e,f); 
                t.add(dem);
            }
                                            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return t;
    }
        
}
