/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication4;

import Utils.Compte;
import Utils.Crud;
import Utils.Guerite;
import Utils.SingletonConnection;
import Utils.SuperAdmin;
import Utils.UserEntreprise;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Date;
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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class AddrecController4 implements Initializable {
    @FXML
    private Button cancel;
    @FXML
    private Button add;
    @FXML
    private Button update;
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
    private TextField cin;
    
    public String table;
    public String temp4;
    
    public void getTable(String text, String nom, String prenom, String email, String login, String password, Date date, String cin){
        table = text;
        temp4 = login;
        firstName.setText(nom);
            lastName.setText(prenom);
            this.email.setText(email);
            this.login.setText(login);
            this.password.setText(password);
            this.cin.setText(cin);
        
    }

    
    EventHandler<ActionEvent> addHandler = new EventHandler<ActionEvent>(){
         @Override
         public void handle(ActionEvent t) {
               String a = firstName.getText();
               String b = lastName.getText();
               String c = email.getText();
               String d = login.getText();
               String e = password.getText();
               Date date = new Date(System.currentTimeMillis());
               String g = cin.getText();
               Compte compte = new Guerite(a, b, c, d,e,date,g);
               Crud.addUser(table, compte);
               close();
         }
    };
    EventHandler<ActionEvent> updateHandler = new EventHandler<ActionEvent>(){
         @Override
         public void handle(ActionEvent t) {
               String a = firstName.getText();
               String b = lastName.getText();
               String c = email.getText();
               String d = login.getText();
               String e = password.getText();
               Date date = new Date(System.currentTimeMillis());
               String g = cin.getText();
               Compte compte = new Guerite(a, b, c, d,e,date,g);
               Crud.updateUser(table, temp4, compte);
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
        update.setOnAction(updateHandler);
        
        if (!(TableController.isAdd)){
            update.setVisible(true);
            update.setDisable(false);
            add.setVisible(false);
            add.setDisable(true);

            
        }
        else {
            update.setVisible(false);
            update.setDisable(true);
            add.setVisible(true);
            add.setDisable(false);
        }
    }
    
    
    @FXML
    private void close() {
        cancel.getScene().getWindow().hide();
    }
    
    
}
