/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication4;

import Utils.Crud;
import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class Scrol3Controller implements Initializable {

    @FXML 
    Pane pane ;
      @FXML
    private Button button;
    @FXML
    private AnchorPane anchorRoot;
    @FXML
    private StackPane parentContainer;
        @FXML
    private Label helper;
         @FXML
    private Label a;
          @FXML
    private Label b;
            @FXML
    private Label c;
              @FXML
    private Label d;
        
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     String etat="" ; 
        DateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        Calendar calendar = Calendar.getInstance();
         String date[] = format.format(Crud.getDemands().get(0).getDateB()).split("/");
       String date2[] = format.format(Crud.getDemands().get(0).getDateE()).split("/");
        if(Crud.getDemands().get(2).isEtat()==-1)
            etat="Demand On hold" ;
         if(Crud.getDemands().get(2).isEtat()==0)
            etat="Demand Rejected" ;
          if(Crud.getDemands().get(2).isEtat()==1)
            etat="Demand Accepted" ;
        a.setText(""+etat);
         b.setText(Crud.getDemands().get(2).getNom());
          c.setText(Crud.getDemands().get(2).getCnie());
         d.setText(Crud.getDemands().get(2).getUe());
        
        
        
    }    
@FXML
    private void load() {
    Parent root=null;
        try {
            root = FXMLLoader.load(getClass().getResource("scrol.fxml"));
        } catch (IOException ex) {
           ex.printStackTrace();
        }

  
   Scene scene = helper.getScene();
        root.translateYProperty().set(scene.getHeight());

        parentContainer.getChildren().add(root);
             Timeline timeline = new Timeline();
        KeyValue kv = new KeyValue(root.translateYProperty(), 0, Interpolator.EASE_IN);
        KeyFrame kf = new KeyFrame(Duration.seconds(3), kv);
        timeline.getKeyFrames().add(kf);
        timeline.setOnFinished(t -> {
            parentContainer.getChildren().remove(anchorRoot);
        });
        timeline.play();
    }
   
    
    }
    

