/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication4;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;


public class SuivreController implements Initializable {


    final URL urlGoogleMaps = getClass().getResource("index_1.html");
@FXML
WebView webView ;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
       WebEngine webEngine = webView.getEngine();
     webEngine.load(urlGoogleMaps.toExternalForm());
     
    }    
    
}
