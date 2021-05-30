/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication4;

import Utils.Compte;
import Utils.Crud;
import Utils.ResponsableSite;
import Utils.SingletonConnection;
import Utils.UserEntreprise;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author yassine
 */
public class AddrecControlle5r implements Initializable {

    /**
     * Initializes the controller class.
     */
    
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
    @FXML
    private ChoiceBox site;
    
    public String table;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         add.setOnAction(addHandler);
         populateJCB();
    }   
    
    public void getTable(String text){
        table = text;
        
    }

    
    EventHandler<ActionEvent> addHandler = new EventHandler<ActionEvent>(){
         @Override
         public void handle(ActionEvent t) {
               String a = firstName.getText();
               String b = lastName.getText();
               String c = email.getText();
               String d = login.getText();
               String e = password.getText();
               String f = phoneNumber.getText();
               String value = (String) site.getValue();
               int id = -1;
               Connection conn = null;
                PreparedStatement ps = null;
                ResultSet rs = null;

                try{

                    String sql = "SELECT id FROM site where nom = ?";
                    conn = SingletonConnection.getconn();
                    ps = conn.prepareStatement(sql);
                    ps.setString(1, value);
                    rs = ps.executeQuery();
                    if(rs.next()){
                        id = rs.getInt("id");
                    }                                 
                }catch(Exception ojkn){
                    ojkn.printStackTrace();
                }
                
                
               Compte compte = new ResponsableSite(a, b, c, d, e, f, id);
               Crud.addUser(table, compte);
               close();
         }
    };
   
    public void populateJCB(){
        
                Connection conn = null;
                PreparedStatement ps = null;
                ResultSet rs = null;

                try{

                    String sql = "SELECT nom FROM site";
                    conn = SingletonConnection.getconn();
                    ps = conn.prepareStatement(sql);
                    
                    rs = ps.executeQuery();
                    if(rs.next()){
                        site.getItems().addAll(rs.getString("nom")); 
                    }                                 
                }catch(Exception ojkn){
                    ojkn.printStackTrace();
                }
    }
    
    @FXML
    private void close() {
        cancel.getScene().getWindow().hide();
    }
    
    
}
