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
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class SplashScreenController implements Initializable {

    @FXML
    private StackPane rootPane ;
       @FXML
    private BorderPane hadi ;
     @FXML
    private ImageView img1 ;
    
     Image image = new Image("/icons/gif.gif") ; 
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)  {
    img1.setImage(image);
       new SplashScreen().start() ; 

    }
    
    class SplashScreen extends Thread {
            @Override  
       public void run(){
         try {
            Thread.sleep(1000);
            Platform.runLater(new Runnable() {
                @Override  
       public void run(){
            Parent root = null ;
        try {
             root = FXMLLoader.load (getClass().getResource("FXML.fxml"));
           
            
        } catch (IOException ex) {
            Logger.getLogger(SplashScreenController.class.getName()).log(Level.SEVERE, null, ex);
        }
         Scene secene = new Scene(root) ; 
            Stage stage = new Stage() ; 
            stage.setScene(secene);
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.show() ; 
            rootPane.getScene().getWindow().hide();
       }
          }) ;    
    }   
        
  
     catch (InterruptedException ex) {
            Logger.getLogger(SplashScreenController.class.getName()).log(Level.SEVERE, null, ex);
        }  
    
        
    }
    
    
    }
}
