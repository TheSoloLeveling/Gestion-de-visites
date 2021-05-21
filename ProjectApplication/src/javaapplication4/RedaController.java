/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication4;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class RedaController implements Initializable {
@FXML 
  private AnchorPane layer1;
    static String k ="" ; 
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
}
