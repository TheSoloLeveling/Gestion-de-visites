/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.sql.Date;
import java.util.LinkedList;
import javaapplication4.TableController;
import java.sql.Time;

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
            ps.setDate(6, u.getDate());
            ps.setString(7, u.getCin());
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
                    + "login = ?, motDePasse = ?, telephone = ?, idSite = ? where login = ?";
            conn = SingletonConnection.getconn();
            ps = conn.prepareStatement(sql);
            ps.setString(1, u.getNom());
            ps.setString(2, u.getPrenom());
            ps.setString(3, u.getEmail());
            ps.setString(4, u.getLogin());
            ps.setString(5, u.getMotDePasse());
            ps.setString(6, u.getTelephone());
            ps.setInt(7, u.getIdSite());
            ps.setString(8, login);
            ps.executeUpdate();
                                        
        }catch(Exception e){
            e.printStackTrace();
        }           
        }
        
        if (table.equals("superadmin")){
            try{
            SuperAdmin u = (SuperAdmin) c;
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
        
        if (table.equals("guerite")){
            try{
            Guerite u = (Guerite) c;
            String sql = "update " + table +
                    " set nom = ?, prenom = ?, email = ?,"
                    + "login = ?, motDePasse = ?, CIN = ? where login = ?";
            conn = SingletonConnection.getconn();
            ps = conn.prepareStatement(sql);
            ps.setString(1, u.getNom());
            ps.setString(2, u.getPrenom());
            ps.setString(3, u.getEmail());
            ps.setString(4, u.getLogin());
            ps.setString(5, u.getMotDePasse());
            ps.setString(6, u.getCin());
            ps.setString(7, login);
            ps.executeUpdate();
                                        
        }catch(Exception e){
            e.printStackTrace();
        }
        }
        
        if (table.equals("responsablesite")){
            try{
            ResponsableSite u = (ResponsableSite) c;
            String sql = "update " + table +
                    " set nom = ?, prenom = ?, email = ?,"
                    + "login = ?, motDePasse = ?, telephone = ?, idSite = ? where login = ?";
            conn = SingletonConnection.getconn();
            ps = conn.prepareStatement(sql);
            ps.setString(1, u.getNom());
            ps.setString(2, u.getPrenom());
            ps.setString(3, u.getEmail());
            ps.setString(4, u.getLogin());
            ps.setString(5, u.getMotDePasse());
            ps.setString(6, u.getTelephone());
            ps.setInt(7, u.getIdSite());
            ps.setString(8, login);
            ps.executeUpdate();
                                        
        }catch(Exception e){
            e.printStackTrace();
        }           
        }
    }
    
    public static LinkedList<Compte> getUsers(String table){
        LinkedList<Compte> c = new LinkedList<Compte>();
        System.out.println(table);
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
       if(table == "guerite"){
           try{
            String sql = "SELECT * FROM guerite";
            conn = SingletonConnection.getconn();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                String id = rs.getString(1);
                String nom = rs.getString(2);
                String prenom = rs.getString(3);
                String email = rs.getString(4);
                String login =  rs.getString(5);
                String password = rs.getString(6);
                Date date = rs.getDate(7);
                String a = rs.getString(8);
                Guerite gu = new Guerite(nom, prenom, email, login, password, date, a);
                c.add(gu);     
            }
                                            
        }catch(Exception e){
            e.printStackTrace();
        }
        
       }
       
       if(table.equals("responsablesite")){
           System.out.println("traite base donne");
           try{
            String sql = "SELECT * FROM responsablesite";
            conn = SingletonConnection.getconn();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                System.out.println("trouveeeeeeeeeeeeeeeeeee");
                String id = rs.getString(1);
                String nom = rs.getString(2);
                String prenom = rs.getString(3);
                String email = rs.getString(4);
                String login =  rs.getString(5);
                String password = rs.getString(6);
                String telephone = rs.getString(7);
                int a = rs.getInt(8);
                ResponsableSite gu = new ResponsableSite(nom, prenom, email, login, password, telephone, a);
                c.add(gu);     
            }
                                            
        }catch(Exception e){
            e.printStackTrace();
        }
        
       }
       
       if(table == "userentreprise"){
           try{
            String sql = "SELECT * FROM userentreprise";
            conn = SingletonConnection.getconn();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                String id = rs.getString(1);
                String nom = rs.getString(2);
                String prenom = rs.getString(3);
                String email = rs.getString(4);
                String login =  rs.getString(5);
                String password = rs.getString(6);
                String telephone = rs.getString(7);
                boolean etat = rs.getBoolean(8);
                UserEntreprise gu = new UserEntreprise(nom, prenom, email, login, password, telephone, etat);
                c.add(gu);     
            }
                                            
        }catch(Exception e){
            e.printStackTrace();
        }
        
       }
       
       if(table == "superadmin"){
           try{
            String sql = "SELECT * FROM superadmin";
            conn = SingletonConnection.getconn();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                String id = rs.getString(1);
                String nom = rs.getString(2);
                String prenom = rs.getString(3);
                String email = rs.getString(4);
                String login =  rs.getString(5);
                String password = rs.getString(6);
                String telephone = rs.getString(7);
                
                SuperAdmin gu = new SuperAdmin(nom, prenom, email, login, password, telephone);
                c.add(gu);     
            }
                                            
        }catch(Exception e){
            e.printStackTrace();
        }
        
       }
       
       if(table == "admin"){
           try{
            String sql = "SELECT * FROM admin";
            conn = SingletonConnection.getconn();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                String id = rs.getString(1);
                String nom = rs.getString(2);
                String prenom = rs.getString(3);
                String email = rs.getString(4);
                String login =  rs.getString(5);
                String password = rs.getString(6);
                String telephone = rs.getString(7);
                int site = rs.getInt(8);
                Admin gu = new Admin(nom, prenom, email, login, password, telephone, site);
                c.add(gu);     
            }
                                            
        }catch(Exception e){
            e.printStackTrace();
        }
        
       }
       
        return c;
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
                Date e = rs.getDate(5);
                Date f = rs.getDate(6);
                
                String g =  rs.getString(7);
                String h = rs.getString(8);
                String i = rs.getString(9);
                int j = rs.getInt(10);
                
                Demande dem = new Demande(a,b,c,d,e,f,g,h,i,j); 
                t.add(dem);
            }
                                            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return t;
    }
    
     public static LinkedList<Site> getSites(){
         Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        LinkedList<Site> t = new LinkedList<>();
        
       try{
            String sql = "SELECT * FROM site";
            conn = SingletonConnection.getconn();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                String a = rs.getString(1);
                String b = rs.getString(2);
                String c = rs.getString(3);
                int d = rs.getInt(4);
                
                Site s = new Site(b,c,d);
                t.add(s);
            }
                                            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return t;
     }
    
    public static void addDemand(Demande d){
        
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try{
        
        String sql = "INSERT INTO demande" +
                                " VALUES (null, ?, ?, ?, ?, ?, ?, ?, ?, ?); ";
        conn = SingletonConnection.getconn();
        ps = conn.prepareStatement(sql);
        ps.setString(1, d.getNom());
        ps.setString(2, d.getPrenom());
        ps.setString(3, d.getCnie());
        ps.setDate(4, d.getDateB());
        ps.setDate(5, d.getDateE());
        ps.setString(6, d.getTime());
        ps.setString(7, d.getUe());
        ps.setString(8, d.getEntreprise());
        ps.setInt(9, d.isEtat());
        ps.executeUpdate();
                                        
        }catch(Exception e){
            e.printStackTrace();
        }
              
    }
    public static void updateUser(String etat , String id ){
        int a = -1;
        if (etat.equals("Demand Accepted"))
            a = 1;
        else if (etat.equals("Demand Rejected"))
            a = 0;
             System.out.println("jbjbjbjhbjhbjhbjh    "+id) ;
             String sql = "update demande set etat=? where id = "+id ; 
       Connection       conn = SingletonConnection.getconn();
       try{
           PreparedStatement ps = conn.prepareStatement(sql) ; 
           ps.setInt(1, a);
           //ps.setString(2, 14);
           ps.executeUpdate() ; 
       } catch(Exception ex){
           ex.printStackTrace();
       }
       
              
             
             
         }
    
    public static int countG(){
        int a =0 ; 
        String sql="select count(*) from guerite" ; 
        Connection cnn = SingletonConnection.getconn() ; 
        try{
            PreparedStatement ps = cnn.prepareStatement(sql) ; 
            ResultSet rs = ps.executeQuery() ; 
            rs.next() ;
            a=rs.getInt(1) ; 
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        
        
        return a ; 
    }
     public static int countsup(){
        int a =0 ; 
        String sql="select count(*) from superadmin" ; 
        Connection cnn = SingletonConnection.getconn() ; 
        try{
            PreparedStatement ps = cnn.prepareStatement(sql) ; 
            ResultSet rs = ps.executeQuery() ; 
            rs.next() ;
            a=rs.getInt(1) ; 
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        
        
        return a ; 
    }
      public static int countad(){
        int a =0 ; 
        String sql="select count(*) from admin" ; 
        Connection cnn = SingletonConnection.getconn() ; 
        try{
            PreparedStatement ps = cnn.prepareStatement(sql) ; 
            ResultSet rs = ps.executeQuery() ; 
            rs.next() ;
            a=rs.getInt(1) ; 
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        
        
        return a ; 
    }
       public static int countrs(){
        int a =0 ; 
        String sql="select count(*) from responsablesite" ; 
        Connection cnn = SingletonConnection.getconn() ; 
        try{
            PreparedStatement ps = cnn.prepareStatement(sql) ; 
            ResultSet rs = ps.executeQuery() ; 
            rs.next() ;
            a=rs.getInt(1) ; 
            
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        
        
        return a ; 
    }
        public static int countus(){
        int a =0 ; 
        String sql="select count(*) from userentreprise" ; 
        Connection cnn = SingletonConnection.getconn() ; 
        try{
            PreparedStatement ps = cnn.prepareStatement(sql) ; 
            ResultSet rs = ps.executeQuery() ; 
            rs.next() ;
            a=rs.getInt(1) ; 
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        
        
        return a ; 
    }
        
          public static int countdem(){
        int a =0 ; 
        String sql="select count(*) from demande" ; 
        Connection cnn = SingletonConnection.getconn() ; 
        try{
            PreparedStatement ps = cnn.prepareStatement(sql) ; 
            ResultSet rs = ps.executeQuery() ; 
            rs.next() ;
            a=rs.getInt(1) ; 
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        
        
        return a ; 
    }
          
           public static int countdemA(){
        int a =0 ; 
        String sql="select count(*) from demande where etat=1" ; 
        Connection cnn = SingletonConnection.getconn() ; 
        try{
            PreparedStatement ps = cnn.prepareStatement(sql) ; 
            ResultSet rs = ps.executeQuery() ; 
            rs.next() ;
            a=rs.getInt(1) ; 
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        
        
        return a ; 
    }
             public static int countdemR(){
        int a =0 ; 
        String sql="select count(*) from demande where etat=0" ; 
        Connection cnn = SingletonConnection.getconn() ; 
        try{
            PreparedStatement ps = cnn.prepareStatement(sql) ; 
            ResultSet rs = ps.executeQuery() ; 
            rs.next() ;
            a=rs.getInt(1) ; 
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        
        
        return a ; 
    }
                  public static int countdemS(){
        int a =0 ; 
        String sql="select count(*) from site.site" ; 
        Connection cnn = SingletonConnection.getconn() ; 
        try{
            PreparedStatement ps = cnn.prepareStatement(sql) ; 
            ResultSet rs = ps.executeQuery() ; 
            rs.next() ;
            a=rs.getInt(1) ; 
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        
        
        return a ; 
    }
    
    
    
        
}
