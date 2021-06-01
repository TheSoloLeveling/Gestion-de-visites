package javaapplication4;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class NewClass implements Initializable {

    static String b = "";
    @FXML
    private Label lb;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        lol(b);
  
    }    
         @FXML
  private void Slidemenu() {
 
 
      
    }
  
  public void lol(String a){
      lb.setText(a);
  }
 
}
      