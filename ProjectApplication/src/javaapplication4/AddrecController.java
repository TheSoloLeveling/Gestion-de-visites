/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication4;

import Utils.Compte;
import Utils.SingletonConnection;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javaapplication4.TableController.random;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class AddrecController implements Initializable {
    @FXML
    private Button cancel;
    @FXML
    private Button add;
    @FXML
    private TextField firstName;
    @FXML
    private TextField lastName;
    @FXML
    private TextField email;
    @FXML
    private TextField login;
    @FXML
    private TextField password;
    @FXML
    private TextField phoneNumber;
    
    public String table;
    
    public void getTable(String text){
        table = text;
        firstName.setText(table);
    }

    
    EventHandler<ActionEvent> addHandler = new EventHandler<ActionEvent>(){
         @Override
         public void handle(ActionEvent t) {
               String text = firstName.getText();
                
                close();
         }
    };
   

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        add.setOnAction(addHandler);
        
        
    }   
    
  
    
    
    @FXML
    private void close() {
        cancel.getScene().getWindow().hide();
    }
    
    
}
