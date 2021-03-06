/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication4;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import netscape.javascript.JSObject;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class FXML4Controller implements Initializable {
//private final JavaBridge bridge = new JavaBridge();

       final URL urlGoogleMaps = getClass().getResource("calendar.html");
@FXML
private Label lb ; 
@FXML
private JFXButton add ;
@FXML
private JFXButton follow ; 
@FXML 
        private Pane layer4 ;

@FXML 
        private Pane layer2 ;
 @FXML
    private PieChart pie ;


@FXML
WebView webView ;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        follow.setOnAction(followHandler);
        add.setOnAction(addHandler);
        
          ObservableList<PieChart.Data> Data  = FXCollections.observableArrayList( new PieChart.Data("site", 13) ,new PieChart.Data("site", 25),
                new PieChart.Data("site", 25) , 
                new PieChart.Data("site", 10) ,new PieChart.Data("site", 22)
                ) ;
        pie.setData(Data);
         WebEngine webEngine = webView.getEngine();
     webEngine.load(urlGoogleMaps.toExternalForm());
           TranslateTransition openPane=new TranslateTransition(new Duration(1950), layer4);
    TranslateTransition closeNav=new TranslateTransition(new Duration(1950), layer2);
  openPane.setToY(120);
     closeNav.setToX(-270);
      
              closeNav.play() ; 
              openPane.play();
}
    
@FXML

private void slide(){
          TranslateTransition openHadi=new TranslateTransition(new Duration(350), lb);
              openHadi.setToX(-20);
              openHadi.play();
          
          
}

@FXML
private void slide1(){
          TranslateTransition openHadi=new TranslateTransition(new Duration(350), lb);
              openHadi.setToX(20);
              openHadi.play();
          
          
}
       @FXML
    private void close() {
       System.exit(0);
    }
    
    EventHandler<ActionEvent> followHandler = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            Parent root=null;
            FXMLLoader loader = new FXMLLoader(getClass().getResource("table1.fxml"));

            try {
                root = loader.load();

            } catch (IOException ex) {
               ex.printStackTrace();
            }

              Scene secene = new Scene(root) ; 
                    Stage stage = new Stage() ; 
                    stage.setScene(secene);
                    stage.initStyle(StageStyle.TRANSPARENT);
                    stage.show() ; 
            }
    };
    
    EventHandler<ActionEvent> addHandler = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            Parent root=null;
    FXMLLoader loader = new FXMLLoader(getClass().getResource("utilisateur.fxml"));

        try {
            root = loader.load();
            
        } catch (IOException ex) {
           ex.printStackTrace();
        }
        
          Scene secene = new Scene(root) ; 
                Stage stage = new Stage() ; 
                stage.setScene(secene);
                stage.initStyle(StageStyle.TRANSPARENT);
                stage.show() ;   
        }
    };
}
