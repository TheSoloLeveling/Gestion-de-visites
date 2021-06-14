/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication4;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import java.io.IOException;
import java.net.URL;
import java.time.Instant;
import java.time.LocalDate;
import java.sql.Date;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author hp
 */


public class UtilisateurController implements Initializable {
@FXML
private AnchorPane  layer1 ;
@FXML
private JFXButton cancel;

@FXML
private DatePicker  datePicker ;
@FXML
private Pane  _12pm ;
@FXML
private Pane  _11pm ;
@FXML
private ToggleGroup date;
@FXML
private Label hr;
@FXML
private JFXTextArea min;
    /**
     * Initializes the controller class.
     */
    /* public String paneName(){
        if (date.getSelectedToggle())
            return "userentreprise";
        else if (accounts.getSelectedToggle() == admin)
            return "admin";
        else if (accounts.getSelectedToggle() == SA)
            return "superadmin";
        else if (accounts.getSelectedToggle() == guerite)
            return "guerite";
        else if (accounts.getSelectedToggle() == RS)
            return "responsablesite";
        else
            return null;
        
    }*/
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
      /*  if(datePicker.getValue() != null){
            LocalDate date = datePicker.getValue();
            Date d = Date.valueOf(date);
        }*/
       
        ToggleButton a = (ToggleButton)_12pm.getChildren().get(1);
        ToggleButton b = (ToggleButton)_11pm.getChildren().get(1);
        
        a.setToggleGroup(date);
        b.setToggleGroup(date);
        
        a.setOnAction(buttonHandler);
        b.setOnAction(buttonHandler1);
        
       /* Timer timer = new Timer();
            timer.schedule(new TimerTask() {
              @Override
              public void run() {
                if(date.getSelectedToggle() != null){
                    hr.setText(date.getSelectedToggle().);
                }
                    
              }
            }, 0, 1);*/
        
        //Time time;
    }    
        EventHandler<ActionEvent> buttonHandler = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            
            _11pm.setStyle("-fx-border-color:#1B6CD7;");
            System.out.println("zaezaeazeaze");
            if(_12pm.getStyle() == "-fx-background-color:#1B6CD7;")
                _12pm.setStyle("-fx-border-color:#1B6CD7;");
            else
                _12pm.setStyle("-fx-background-color:#1B6CD7;");
            
            hr.setText("12");
        }
        };
        
        EventHandler<ActionEvent> buttonHandler1 = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            
            _12pm.setStyle("-fx-border-color:#1B6CD7;");
            if(_11pm.getStyle() == "-fx-background-color:#1B6CD7;")
                _11pm.setStyle("-fx-border-color:#1B6CD7;");
            else
                _11pm.setStyle("-fx-background-color:#1B6CD7;");
            
            hr.setText("11");
        }
        };
    
    @FXML
    private void load() {
    Parent root=null;
        try {
            root = FXMLLoader.load(getClass().getResource("user2.fxml"));
        } catch (IOException ex) {
           ex.printStackTrace();
        }

        layer1.getChildren().clear();
        layer1.getChildren().add(root);
        //layer1.getChildren().
    }
    
     @FXML
    private void close() {
        cancel.getScene().getWindow().hide();
    }
    
}
                