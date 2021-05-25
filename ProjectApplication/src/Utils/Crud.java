/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
            int r = ps.executeUpdate();
                                        
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
            int r = ps.executeUpdate();
                                        
        }catch(Exception e){
            e.printStackTrace();
        }
        }
        
    }
}
