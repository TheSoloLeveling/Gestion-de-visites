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
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
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
private DatePicker  datePickerD ;
@FXML
private DatePicker  datePickerE ;
@FXML
private Pane  _12pm ;
@FXML
private Pane  _11am ;
@FXML
private Pane  _10am ;
@FXML
private Pane  _1pm ;
@FXML
private Pane  _2pm ;
@FXML
private Pane  _3pm ;
@FXML
private Pane  _4pm ;
@FXML
private Pane  _5pm ;
@FXML
private Pane  _6pm ;

@FXML
private ToggleGroup date;
@FXML
private Label hr;
@FXML
private Label min;
@FXML
private Rectangle rec;
@FXML
private Rectangle rec1;
@FXML
private Spinner spinner;
@FXML
private Button next;
@FXML
private Label dateBError;
@FXML
private Label dateEError;
@FXML
private Label hrError;
@FXML
private Label minError;
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
        
         SpinnerValueFactory<Integer> valueFactory = //
                new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 59, 0);
         spinner.setValueFactory(valueFactory);
         
        rec.setFill(Color.TRANSPARENT);
        rec1.setFill(Color.TRANSPARENT);
        
        hr.setDisable(true);
        ToggleButton t1 = (ToggleButton)_10am.getChildren().get(1);
        ToggleButton t2 = (ToggleButton)_11am.getChildren().get(1);
        ToggleButton t3 = (ToggleButton)_12pm.getChildren().get(1);
        ToggleButton t4 = (ToggleButton)_1pm.getChildren().get(1);
        ToggleButton t5 = (ToggleButton)_2pm.getChildren().get(1);
        ToggleButton t6 = (ToggleButton)_3pm.getChildren().get(1);
        ToggleButton t7 = (ToggleButton)_4pm.getChildren().get(1);
        ToggleButton t8 = (ToggleButton)_5pm.getChildren().get(1);
        ToggleButton t9 = (ToggleButton)_6pm.getChildren().get(1);
        
        t1.setToggleGroup(date);
        t2.setToggleGroup(date);
        t3.setToggleGroup(date);
        t4.setToggleGroup(date);
        t5.setToggleGroup(date);
        t6.setToggleGroup(date);
        t7.setToggleGroup(date);
        t8.setToggleGroup(date);
        t9.setToggleGroup(date);
        
        t1.setOnAction(buttonHandler1);
        t2.setOnAction(buttonHandler2);
        t3.setOnAction(buttonHandler3);
        t4.setOnAction(buttonHandler4);
        t5.setOnAction(buttonHandler5);
        t6.setOnAction(buttonHandler6);
        t7.setOnAction(buttonHandler7);
        t8.setOnAction(buttonHandler8);
        t9.setOnAction(buttonHandler9);
        
        spinner.getEditor().textProperty().addListener((obs, oldValue, newValue) -> {
            if (!"".equals(newValue)) {
                min.setText(spinner.getValue().toString());    
            } 
        });
        
    }    
        EventHandler<ActionEvent> buttonHandler1 = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            
            _11am.setStyle("-fx-border-color:#1B6CD7;");
            _12pm.setStyle("-fx-border-color:#1B6CD7;");
            _1pm.setStyle("-fx-border-color:#1B6CD7;");
            _2pm.setStyle("-fx-border-color:#1B6CD7;");
            _3pm.setStyle("-fx-border-color:#1B6CD7;");
            _4pm.setStyle("-fx-border-color:#1B6CD7;");
            _5pm.setStyle("-fx-border-color:#1B6CD7;");
            _6pm.setStyle("-fx-border-color:#1B6CD7;");
            
            if(_10am.getStyle() == "-fx-background-color:#1B6CD7;")
                _10am.setStyle("-fx-border-color:#1B6CD7;");
            else
                _10am.setStyle("-fx-background-color:#1B6CD7;");
            
            hr.setText("10");
        }
        };
        
        EventHandler<ActionEvent> buttonHandler2 = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            
            _10am.setStyle("-fx-border-color:#1B6CD7;");
            _12pm.setStyle("-fx-border-color:#1B6CD7;");
            _1pm.setStyle("-fx-border-color:#1B6CD7;");
            _2pm.setStyle("-fx-border-color:#1B6CD7;");
            _3pm.setStyle("-fx-border-color:#1B6CD7;");
            _4pm.setStyle("-fx-border-color:#1B6CD7;");
            _5pm.setStyle("-fx-border-color:#1B6CD7;");
            _6pm.setStyle("-fx-border-color:#1B6CD7;");
            
            if(_11am.getStyle() == "-fx-background-color:#1B6CD7;")
                _11am.setStyle("-fx-border-color:#1B6CD7;");
            else
                _11am.setStyle("-fx-background-color:#1B6CD7;");
            
            hr.setText("11");
        }
        };
        EventHandler<ActionEvent> buttonHandler3 = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            
            _11am.setStyle("-fx-border-color:#1B6CD7;");
            _10am.setStyle("-fx-border-color:#1B6CD7;");
            _1pm.setStyle("-fx-border-color:#1B6CD7;");
            _2pm.setStyle("-fx-border-color:#1B6CD7;");
            _3pm.setStyle("-fx-border-color:#1B6CD7;");
            _4pm.setStyle("-fx-border-color:#1B6CD7;");
            _5pm.setStyle("-fx-border-color:#1B6CD7;");
            _6pm.setStyle("-fx-border-color:#1B6CD7;");
            
            if(_12pm.getStyle() == "-fx-background-color:#1B6CD7;")
                _12pm.setStyle("-fx-border-color:#1B6CD7;");
            else
                _12pm.setStyle("-fx-background-color:#1B6CD7;");
            
            hr.setText("12");
        }
        };
        EventHandler<ActionEvent> buttonHandler4 = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            
            _11am.setStyle("-fx-border-color:#1B6CD7;");
            _12pm.setStyle("-fx-border-color:#1B6CD7;");
            _10am.setStyle("-fx-border-color:#1B6CD7;");
            _2pm.setStyle("-fx-border-color:#1B6CD7;");
            _3pm.setStyle("-fx-border-color:#1B6CD7;");
            _4pm.setStyle("-fx-border-color:#1B6CD7;");
            _5pm.setStyle("-fx-border-color:#1B6CD7;");
            _6pm.setStyle("-fx-border-color:#1B6CD7;");
            
            if(_1pm.getStyle() == "-fx-background-color:#1B6CD7;")
                _1pm.setStyle("-fx-border-color:#1B6CD7;");
            else
                _1pm.setStyle("-fx-background-color:#1B6CD7;");
            
            hr.setText("1");
        }
        };
        EventHandler<ActionEvent> buttonHandler5 = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            
            _11am.setStyle("-fx-border-color:#1B6CD7;");
            _12pm.setStyle("-fx-border-color:#1B6CD7;");
            _1pm.setStyle("-fx-border-color:#1B6CD7;");
            _10am.setStyle("-fx-border-color:#1B6CD7;");
            _3pm.setStyle("-fx-border-color:#1B6CD7;");
            _4pm.setStyle("-fx-border-color:#1B6CD7;");
            _5pm.setStyle("-fx-border-color:#1B6CD7;");
            _6pm.setStyle("-fx-border-color:#1B6CD7;");
            
            if(_2pm.getStyle() == "-fx-background-color:#1B6CD7;")
                _2pm.setStyle("-fx-border-color:#1B6CD7;");
            else
                _2pm.setStyle("-fx-background-color:#1B6CD7;");
            
            hr.setText("2");
        }
        };
        EventHandler<ActionEvent> buttonHandler6 = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            
            _11am.setStyle("-fx-border-color:#1B6CD7;");
            _12pm.setStyle("-fx-border-color:#1B6CD7;");
            _1pm.setStyle("-fx-border-color:#1B6CD7;");
            _2pm.setStyle("-fx-border-color:#1B6CD7;");
            _3pm.setStyle("-fx-border-color:#1B6CD7;");
            _10am.setStyle("-fx-border-color:#1B6CD7;");
            _5pm.setStyle("-fx-border-color:#1B6CD7;");
            _6pm.setStyle("-fx-border-color:#1B6CD7;");
            
            if(_3pm.getStyle() == "-fx-background-color:#1B6CD7;")
                _3pm.setStyle("-fx-border-color:#1B6CD7;");
            else
                _3pm.setStyle("-fx-background-color:#1B6CD7;");
            
            hr.setText("3");
        }
        };
        EventHandler<ActionEvent> buttonHandler7 = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            
            _11am.setStyle("-fx-border-color:#1B6CD7;");
            _12pm.setStyle("-fx-border-color:#1B6CD7;");
            _1pm.setStyle("-fx-border-color:#1B6CD7;");
            _2pm.setStyle("-fx-border-color:#1B6CD7;");
            _3pm.setStyle("-fx-border-color:#1B6CD7;");
            _10am.setStyle("-fx-border-color:#1B6CD7;");
            _5pm.setStyle("-fx-border-color:#1B6CD7;");
            _6pm.setStyle("-fx-border-color:#1B6CD7;");
            
            if(_4pm.getStyle() == "-fx-background-color:#1B6CD7;")
                _4pm.setStyle("-fx-border-color:#1B6CD7;");
            else
                _4pm.setStyle("-fx-background-color:#1B6CD7;");
            
            hr.setText("4");
        }
        };
        EventHandler<ActionEvent> buttonHandler8 = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            
            _11am.setStyle("-fx-border-color:#1B6CD7;");
            _12pm.setStyle("-fx-border-color:#1B6CD7;");
            _1pm.setStyle("-fx-border-color:#1B6CD7;");
            _2pm.setStyle("-fx-border-color:#1B6CD7;");
            _3pm.setStyle("-fx-border-color:#1B6CD7;");
            _4pm.setStyle("-fx-border-color:#1B6CD7;");
            _10am.setStyle("-fx-border-color:#1B6CD7;");
            _6pm.setStyle("-fx-border-color:#1B6CD7;");
            
            if(_5pm.getStyle() == "-fx-background-color:#1B6CD7;")
                _5pm.setStyle("-fx-border-color:#1B6CD7;");
            else
                _5pm.setStyle("-fx-background-color:#1B6CD7;");
            
            hr.setText("5");
        }
        };
        EventHandler<ActionEvent> buttonHandler9 = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            
            _11am.setStyle("-fx-border-color:#1B6CD7;");
            _12pm.setStyle("-fx-border-color:#1B6CD7;");
            _1pm.setStyle("-fx-border-color:#1B6CD7;");
            _2pm.setStyle("-fx-border-color:#1B6CD7;");
            _3pm.setStyle("-fx-border-color:#1B6CD7;");
            _4pm.setStyle("-fx-border-color:#1B6CD7;");
            _5pm.setStyle("-fx-border-color:#1B6CD7;");
            _10am.setStyle("-fx-border-color:#1B6CD7;");
            
            if(_6pm.getStyle() == "-fx-background-color:#1B6CD7;")
                _6pm.setStyle("-fx-border-color:#1B6CD7;");
            else
                _6pm.setStyle("-fx-background-color:#1B6CD7;");
            
            hr.setText("6");
        }
        };
        
    
    @FXML
    private void load() {
        LocalDate dateD = datePickerD.getValue();
        Date beginD = null;
        if(dateD != null){
            beginD = (Date) Date.valueOf(dateD);
        }
    
        LocalDate dateE = datePickerE.getValue();
        Date beginE = null;
        if(dateE != null){
            beginE = (Date) Date.valueOf(dateE);
        }
        String time = hr.getText() + " : " + min.getText();
        //Exceptions
        if(hr.getText() == ""){
            
            time = null;
            hrError.setTextFill(Color.TOMATO);
            hrError.setText("fill in the field");
        }
        else{
            hrError.setTextFill(Color.GREEN);
            hrError.setText("Checked");
        }
        if(min.getText() == ""){
            
            time = null;
            minError.setTextFill(Color.TOMATO);
            minError.setText("fill in the field");
        }
        else{
            minError.setTextFill(Color.GREEN);
            minError.setText("Checked");
        }
        if(dateE == null){
            dateEError.setTextFill(Color.TOMATO);
            dateEError.setText("fill in the field");
        }
        else{
            dateEError.setTextFill(Color.GREEN);
            dateEError.setText("Date valid");
        }
        if(beginD == null){
            dateBError.setTextFill(Color.TOMATO);
            dateBError.setText("fill in the field");
        }
        else{
            dateBError.setTextFill(Color.GREEN);
            dateBError.setText("Date valid");
        }
        if(dateE != null && beginD != null){
        if (beginD.after(beginE) ){
                dateBError.setTextFill(Color.TOMATO);
                dateBError.setText("Date invalid");
                dateEError.setTextFill(Color.TOMATO);
                dateEError.setText("Date invalid");
                dateE = null;
                beginD = null;
            }
            else{
                dateBError.setTextFill(Color.GREEN);
                dateBError.setText("Date valid");
                dateEError.setTextFill(Color.GREEN);
                dateEError.setText("Date valid");
            }
        }
     //   
    if(dateE != null && beginD != null && time != null){
        Parent root=null;
    FXMLLoader loader = new FXMLLoader(getClass().getResource("user2.fxml"));

        try {
            root = loader.load();
            
        } catch (IOException ex) {
           ex.printStackTrace();
        }
        
        User2Controller user2Controller = loader.getController();
        user2Controller.getInfos(beginD, beginE, time);
        
        layer1.getChildren().clear();
        layer1.getChildren().add(root);
    }
 
    }
    
     @FXML
    private void close() {
        cancel.getScene().getWindow().hide();
    }
    
}
                