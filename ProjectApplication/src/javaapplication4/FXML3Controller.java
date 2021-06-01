/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication4;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class FXML3Controller implements Initializable {
@FXML
WebView webView ;
@FXML
Pane layer2 ;
 public static WebEngine webEngine  ;
    int lat =0 ;
   int lon =0 ;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     webEngine = webView.getEngine();

     webEngine.load("http://localhost/server/ez.php");
      webEngine.getLoadWorker().stateProperty().addListener((observable, oldValue, newValue) ->
{
 
});

    }

@FXML
   public void refresh() {
         webEngine.load("http://localhost/server/ez.php");
    }    
         @FXML
  private void Slidemenu() {
 
        TranslateTransition openNav=new TranslateTransition(new Duration(350), layer2);
        openNav.setToX(-300);
        TranslateTransition closeNav=new TranslateTransition(new Duration(350), layer2);
            if(layer2.getTranslateX()!=-300){
            
                openNav.play();
   
            }else{
                closeNav.setToX(0);
                closeNav.play();
    
            }
      
    }
          @FXML
  private void btn() {
 load();
        TranslateTransition openNav=new TranslateTransition(new Duration(350), layer2);
        openNav.setToX(-300);
        TranslateTransition closeNav=new TranslateTransition(new Duration(350), layer2);
            if(layer2.getTranslateX()!=-300){
            
                openNav.play();
   
            }else{
                closeNav.setToX(0);
                closeNav.play();
    
            }
      
    }
     @FXML
    private void load() {
        System.out.print("lol");
    Parent root=null;
        try {
            root = FXMLLoader.load(getClass().getResource("SecondMap.fxml"));
        } catch (IOException ex) {
           ex.printStackTrace();
        }
      Scene secene = new Scene(root) ; 
            Stage stage = new Stage() ; 
            stage.setScene(secene);
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.show() ; 
             
 

    }
  public class JavaBridge
{
  
    public  void log(String text)
    {
        
     
    System.out.print(text);
    
    
        
    }
}
  
  
 
  
    }    
    
        
