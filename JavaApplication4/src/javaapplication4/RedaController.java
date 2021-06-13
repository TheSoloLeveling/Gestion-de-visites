/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication4;

import Utils.SingletonConnection;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;

/**
 * FXML Controller class
 *
 * @author hp
 */


public class RedaController implements Initializable {
    @FXML 
      private AnchorPane layer1;

    @FXML
    private Label nbrUsers;
    @FXML
    private Label nbrVisiteurs;
    @FXML
    private Label nbrSites;
    
    static String k ="" ; 
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        String[] accounts1 = {"responsablesite", "userentreprise"};
        nbrUsers.setText(updateRowNumber(accounts1));
        String[] accounts2 = {"site"};
        nbrSites.setText(updateRowNumber(accounts2));
        String[] accounts3 = {"userentreprise"};
        nbrVisiteurs.setText(updateRowNumber(accounts3));
        
    }    
    
         @FXML
  private void loaditem1() {
      
    load("reda") ;
        
  } 
         @FXML
  private void loaditem2() {
         load("Hada") ;
      
        
  } 
         @FXML
  private void loaditem3() {
      
     
         load("MyMom") ;
        
  } 
           @FXML
  private void loaditem4() {
      
     
         load("dashboard") ;
        
  } 
           @FXML
  private void loaditem5() {
      
     
         load("table2") ;
        
  } 
  @FXML
  private void load(String item) {
      
     
     Parent root =null ; 
     
        try { 
            root= FXMLLoader.load(getClass().getResource(item+".fxml")) ;
        } catch (IOException ex) {
            Logger.getLogger(DashController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       
          layer1.getChildren().clear();
          layer1.getChildren().add(root) ;
         
  }
  
  public String updateRowNumber(String[] table){
      
      String sql;
      int count = 0;
      for(int i = 0; i < table.length; i++){
          sql = "SELECT COUNT(*) AS total FROM " + table[i];
        
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try{
            conn = SingletonConnection.getconn();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            if(rs.next()){
                count += rs.getInt("total");
            
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
      }
      return ""+count;
  }
}
