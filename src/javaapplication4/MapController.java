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
import javafx.scene.layout.Pane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class MapController implements Initializable {
     final URL urlGoogleMaps = getClass().getResource("demo.html");
@FXML
WebView webView ;
@FXML
Pane layer2 ;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     WebEngine webEngine = webView.getEngine();
     webEngine.load(urlGoogleMaps.toExternalForm());
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
}
      