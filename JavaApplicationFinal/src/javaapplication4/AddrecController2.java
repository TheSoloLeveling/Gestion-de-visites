/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication4;

import Utils.Admin;
import Utils.Compte;
import Utils.Crud;
import Utils.ResponsableSite;
import Utils.SingletonConnection;
import Utils.UserEntreprise;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
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
public class AddrecController2 implements Initializable {

    /**
     * Initializes the controller class.
     */
    
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
    private TextField phoneNumber;
    @FXML
    private ChoiceBox site;
    
    
    
    
    public String table;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         add.setOnAction(addHandler);
         update.setOnAction(updateHandler);
         populateJCB();
         
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
    
   
    public String temp1;
    public String temp2;
    public String temp3;
    public String temp4;
    public String temp5;
    public String temp6;
    public String temp7;

    public void getTable(String text, String nom, String prenom, String email, String login, String password, String telephone, String idSite){
        table = text;
        temp4 = login;
        firstName.setText(nom);
            lastName.setText(prenom);
            this.email.setText(email);
            this.login.setText(login);
            this.password.setText(password);
            phoneNumber.setText(telephone);
            
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
                
                
               Compte compte = new Admin(a, b, c, d, e, f, id);
               Crud.addUser(table, compte);
               close();
         }
    };
   
    public void populateJCB(){
        
                Connection conn = null;
                Statement ps = null;
                ResultSet rs = null;

                try{

                    String sql = "SELECT * FROM site";
                    conn = SingletonConnection.getconn();
                    ps = conn.createStatement();
                    
                    rs = ps.executeQuery(sql);
                    while(rs.next()){
                        System.out.println(rs.getString("nom"));
                        site.getItems().addAll(rs.getString("nom")); 
                    }                                 
                }catch(Exception ojkn){
                    ojkn.printStackTrace();
                }
                
    }
    
    public String searchSiteId(String nom){
        
                Connection conn = null;
                PreparedStatement ps = null;
                ResultSet rs = null;

                try{

                    String sql = "SELECT id FROM site where nom = ?";
                    conn = SingletonConnection.getconn();
                    ps = conn.prepareStatement(sql);
                    ps.setString(1, nom);
                    rs = ps.executeQuery();
                    
                    if(rs.next()){
                        return rs.getString("id");
                    }                                 
                }catch(Exception ojkn){
                    ojkn.printStackTrace();
                }
                
                return null;
    }
    
    EventHandler<ActionEvent> updateHandler = new EventHandler<ActionEvent>(){
         @Override
         public void handle(ActionEvent t) {
             String a = firstName.getText();
               String b = lastName.getText();
               String c = email.getText();
               String d = login.getText();
               String e = password.getText();
               String f = phoneNumber.getText();
               String g = site.getValue().toString();
               int h = Integer.parseInt(searchSiteId(g));
              Compte compte = new Admin(a,b,c,d,e,f,h);
              Crud.updateUser(table, temp4, compte);
              close();
         }
             };
    @FXML
    private void close() {
        cancel.getScene().getWindow().hide();
    }
    
    
}
