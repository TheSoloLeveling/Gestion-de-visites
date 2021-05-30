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
import java.io.IOException;
import java.util.Random;
import javafx.application.Application;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import java.sql.Statement;
import javafx.scene.input.MouseEvent;

public class TableController implements Initializable {
    @FXML
    private TableView tableView1;
    @FXML
    private TableView tableView2;
    @FXML
    private TableView tableView3;
    @FXML
    private TableView tableView4;
    @FXML
    private TableView tableView5;
    @FXML
    private AnchorPane layer1;
    @FXML
    private Button btnNew;
    @FXML
    private ToggleGroup accounts;
    @FXML
    private ToggleButton UE;
    @FXML
    private ToggleButton guerite;
    @FXML
    private ToggleButton RS;
    @FXML
    private ToggleButton admin;
    @FXML
    private ToggleButton SA;
    @FXML
    private Button refresh;
    @FXML
    private Button btnDel;
    
    //private Button = 
    static Random random = new Random();
    
    
    
    public String getToggleButtonName(){
        if (accounts.getSelectedToggle() == UE)
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
        
    }

    public static class Record {
        private  String value_0;
        private  String value_1;
        private  String value_2;
        private  String value_3;
        private  String value_4;
         private  String value_5;
         private  String value_6;
        
        Record(String v0, String v1, String v2 ,String v3 ,
                String v4, String v5 ,String v6) {
           
            this.value_0 = v0;
            this.value_1 = v1;
            this.value_2= v2;
            this.value_3= v3;
            this.value_4= v4;
            this.value_5 = v5;
            this.value_6 = v6;
        }
        
        Record(String v0, String v1, String v2 ,String v3 ,
                String v4, String v5) {
           
            this.value_0 = v0;
            this.value_1 = v1;
            this.value_2= v2;
            this.value_3= v3;
            this.value_4= v4;
            this.value_5 = v5;
            
        }
        
        Record(String v0, String v1, String v2 ,String v3 ,
                String v4) {
           
            this.value_0 = v0;
            this.value_1 = v1;
            this.value_2= v2;
            this.value_3= v3;
            this.value_4= v4;
            
        }

        public String getValue_0() {
            return value_0;
        }

        public String getValue_1() {
            return value_1;
        }

        public String getValue_2() {
            return value_2;
        }

        public String getValue_3() {
            return value_3;
        }

        public String getValue_4() {
            return value_4;
        }

        public String getValue_5() {
            return value_5;
        }

        public String getValue_6() {
            return value_6;
        }

        public void setValue_0(String value_0) {
            this.value_0 = value_0;
        }

        public void setValue_1(String value_1) {
            this.value_1 = value_1;
        }

        public void setValue_2(String value_2) {
            this.value_2 = value_2;
        }

        public void setValue_3(String value_3) {
            this.value_3 = value_3;
        }

        public void setValue_4(String value_4) {
            this.value_4 = value_4;
        }

        public void setValue_5(String value_5) {
            this.value_5 = value_5;
        }

        public void setValue_6(String value_6) {
            this.value_6 = value_6;
        }
 
    };
    
    ObservableList<Record> data1 = FXCollections.observableArrayList();
    ObservableList<Record> data2 = FXCollections.observableArrayList();
    ObservableList<Record> data3 = FXCollections.observableArrayList();
    ObservableList<Record> data4 = FXCollections.observableArrayList();
    ObservableList<Record> data5 = FXCollections.observableArrayList();
    
    
    public void createTable(String[] headers, TableView table, ObservableList<Record> data){
       
        //Editable columns
        for(int i=0; i<headers.length; i++){
            TableColumn col = new TableColumn(headers[i]);
            col.setCellValueFactory(
                    new PropertyValueFactory<Record, String>(
                            "value_" + String.valueOf(i)));
            table.getColumns().add(col);
        }
            
        table.setItems(data);
    }

    
    public void refreshUser(){
        
        Connection conn = null;
        Statement ps = null;
        ResultSet rs = null;
            
        data1.removeAll(data1);
        data2.removeAll(data2);
        data3.removeAll(data3);
        data4.removeAll(data4);
        data5.removeAll(data5);

      
        try{
        String sql = "SELECT * FROM guerite";
        conn = SingletonConnection.getconn();
        ps = conn.createStatement();
        rs = ps.executeQuery(sql);

        while(rs.next()){
            String id = rs.getString(1);
            String nom = rs.getString(2);
            String prenom = rs.getString(3);
            String email = rs.getString(4);
            String login = rs.getString(5);
            String pass = rs.getString(6);     
            String dateCreation = rs.getString(7);
            String cin = rs.getString(8);
            Record newRec = new Record(nom, prenom, email, login, pass, dateCreation, cin);
            data4.add(newRec);

        }
            rs.close();
            ps.close();                             
        }catch(Exception e){
            e.printStackTrace();
        }
        
        try{
        String sql = "SELECT * FROM userentreprise";
        conn = SingletonConnection.getconn();
        ps = conn.createStatement();
        rs = ps.executeQuery(sql);

        while(rs.next()){
            String id = rs.getString(1);
            String nom = rs.getString(2);
            String prenom = rs.getString(3);
            String email = rs.getString(4);
            String login = rs.getString(5);
            String pass = rs.getString(6);     
            String telephone= rs.getString(7);
            String etat = rs.getString(8);
            Record newRec = new Record(nom, prenom, email, login, pass, telephone, etat);
            data1.add(newRec);

        }
            rs.close();
            ps.close();                             
        }catch(Exception e){
            e.printStackTrace();
        }
        
         try{
        String sql = "SELECT * FROM admin";
        conn = SingletonConnection.getconn();
        ps = conn.createStatement();
        rs = ps.executeQuery(sql);

        while(rs.next()){
            String id = rs.getString(1);
            String nom = rs.getString(2);
            String prenom = rs.getString(3);
            String email = rs.getString(4);
            String login = rs.getString(5);
            String pass = rs.getString(6);     
            String telephone= rs.getString(7);
            String idSite = rs.getString(8);
            Record newRec = new Record(nom, prenom, email, login, pass, telephone, idSite);
            data2.add(newRec);

        }
            rs.close();
            ps.close();                             
        }catch(Exception e){
            e.printStackTrace();
        }
         
          try{
        String sql = "SELECT * FROM responsablesite";
        conn = SingletonConnection.getconn();
        ps = conn.createStatement();
        rs = ps.executeQuery(sql);

        while(rs.next()){
            String id = rs.getString(1);
            String nom = rs.getString(2);
            String prenom = rs.getString(3);
            String email = rs.getString(4);
            String login = rs.getString(5);
            String pass = rs.getString(6);     
            String telephone= rs.getString(7);
            String idSite = rs.getString(8);
            Record newRec = new Record(nom, prenom, email, login, pass, telephone, idSite);
            data5.add(newRec);

        }
            rs.close();
            ps.close();                             
        }catch(Exception e){
            e.printStackTrace();
        }
          
         try{
        String sql = "SELECT * FROM superadmin";
        conn = SingletonConnection.getconn();
        ps = conn.createStatement();
        rs = ps.executeQuery(sql);

        while(rs.next()){
            String id = rs.getString(1);
            String nom = rs.getString(2);
            String prenom = rs.getString(3);
            String email = rs.getString(4);
            String login = rs.getString(5);
            String pass = rs.getString(6);     
            String telephone= rs.getString(7);
            
            Record newRec = new Record(nom, prenom, email, login, pass, telephone);
            data3.add(newRec);

        }
            rs.close();
            ps.close();                             
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
    }
    
    
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
            tableView1.setEditable(true);
            
            UE.setToggleGroup(accounts);
            RS.setToggleGroup(accounts);
            guerite.setToggleGroup(accounts);
            SA.setToggleGroup(accounts);
            admin.setToggleGroup(accounts);
            btnNew.setOnAction(btnNewHandler);
            refresh.setOnAction(refreshHandler);
            btnDel.setOnAction(deleteHandler);
                    
            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
              @Override
              public void run() {
                if(accounts.getSelectedToggle() != null){
                    btnNew.setDisable(false);
                    refresh.setDisable(false);
                    btnDel.setDisable(false);
                }
              }
            }, 0, 1);
            
            btnNew.setDisable(true);
            refresh.setDisable(true);
            btnDel.setDisable(true);
            
            tableView1.setVisible(false);
            String[] header1 = {"nom", "prenom", "email", "login", "motDePasse", "telephone", "etat"};
            createTable(header1, tableView1, data1);
            tableView2.setVisible(false);
            String[] header2 = {"nom", "prenom", "email", "login", "motDePasse", "telephone"};
            createTable(header2, tableView2, data2);
            tableView3.setVisible(false);
            String[] header3 = {"nom", "prenom", "email", "login", "motDePasse", "telephone"};
            createTable(header3, tableView3, data3);
            tableView4.setVisible(false);
            String[] header4 = {"nom", "prenom", "email", "login", "motDePasse", "Date de création", "CIN"};
            createTable(header4, tableView4, data4);
            tableView5.setVisible(false);
            String[] header5 = {"nom", "prenom", "email", "login", "motDePasse", "telephone", "Site"};
            createTable(header5, tableView5, data5);
           
            
            accounts.selectedToggleProperty().addListener(
                (observable, oldToggle, newToggle) -> {
                    if (newToggle == UE) {
                        tableView1.setVisible(true);
                        tableView2.setVisible(false);
                        tableView3.setVisible(false);
                        tableView4.setVisible(false);
                        tableView5.setVisible(false);
                    }
                    else if(newToggle == admin){
                        tableView1.setVisible(false);
                        tableView2.setVisible(true);
                        tableView3.setVisible(false);
                        tableView4.setVisible(false);
                        tableView5.setVisible(false);
                    }
                    else if(newToggle == SA){
                        tableView1.setVisible(false);
                        tableView2.setVisible(false);
                        tableView3.setVisible(true);
                        tableView4.setVisible(false);
                        tableView5.setVisible(false);
                    }
                    else if(newToggle == guerite){
                        tableView1.setVisible(false);
                        tableView2.setVisible(false);
                        tableView3.setVisible(false);
                        tableView4.setVisible(true);
                        tableView5.setVisible(false);
                    }
                    else if(newToggle == RS){
                        tableView1.setVisible(false);
                        tableView2.setVisible(false);
                        tableView3.setVisible(false);
                        tableView4.setVisible(false);
                        tableView5.setVisible(true);
                    }
                    else{
                        tableView1.setVisible(false);
                        tableView2.setVisible(false);
                        tableView3.setVisible(false);
                        tableView4.setVisible(false);
                        tableView5.setVisible(false);
                        btnNew.setDisable(true);
                        refresh.setDisable(true);
                        btnDel.setDisable(true);
                    }
                }
            );
            
            refreshUser();
    }
    
    
    EventHandler<ActionEvent> refreshHandler = 
            new EventHandler<ActionEvent>(){

        @Override
        public void handle(ActionEvent t) {
            
           refreshUser();
            
        }
            };
    
    EventHandler<ActionEvent> deleteHandler = 
            new EventHandler<ActionEvent>(){

        @Override
        public void handle(ActionEvent t) {
                if (accounts.getSelectedToggle() == UE){
                    Record record = (Record) tableView1.getSelectionModel().getSelectedItem();
                    if (record != null){  
                        data1.remove(record);
                        Crud.removeUser("userentreprise", record.getValue_3());
                    }   
                }
                else if (accounts.getSelectedToggle() == admin){
                    Record record = (Record) tableView2.getSelectionModel().getSelectedItem();
                    if (record != null){  
                        data2.remove(record);
                        Crud.removeUser("admin", record.getValue_3());
                    }   
                }
                else if (accounts.getSelectedToggle() == SA){
                    Record record = (Record) tableView3.getSelectionModel().getSelectedItem();
                    if (record != null){  
                        data3.remove(record);
                        Crud.removeUser("superadmin", record.getValue_3());
                    }   
                }
                else if (accounts.getSelectedToggle() == guerite){
                    Record record = (Record) tableView4.getSelectionModel().getSelectedItem();
                    if (record != null){  
                        data4.remove(record);
                        Crud.removeUser("guerite", record.getValue_3());
                    }   
                } 
                else if (accounts.getSelectedToggle() == RS){
                    Record record = (Record) tableView5.getSelectionModel().getSelectedItem();
                    if (record != null){  
                        data5.remove(record);
                        Crud.removeUser("responsablesite", record.getValue_3());
                    }   
                }
        
            }
    
        };
    
    public ObservableList<Record> checkVisibleTable(){
        if (accounts.getSelectedToggle() == UE)
            return data1;
        else if (accounts.getSelectedToggle() == admin)
            return data2;
        else if (accounts.getSelectedToggle() == SA)
            return data3;
        else if (accounts.getSelectedToggle() == guerite)
            return data4;
        else if (accounts.getSelectedToggle() == RS)
            return data5;
        else
            return null;
    }
   
       EventHandler<ActionEvent> btnNewHandler = 
            new EventHandler<ActionEvent>(){

        @Override
        public void handle(ActionEvent t) {
            
            load() ;
        }
    };
        
    private Stage stage;
    private Scene scene;
    private Parent root;  
         @FXML
    private void load() {
    
        String text = getToggleButtonName();
        FXMLLoader loader = null;
        if (text.equals("userentreprise"))
            loader = new FXMLLoader(getClass().getResource("addrec1.fxml"));
        else if (text.equals("amdin"))
            loader = new FXMLLoader(getClass().getResource("addrec2.fxml"));
        else if (text.equals("superadmin"))
            loader = new FXMLLoader(getClass().getResource("addrec3.fxml"));
        else if (text.equals("guerite"))
            loader = new FXMLLoader(getClass().getResource("addrec4.fxml"));
        else if (text.equals("responsablesite"))
            loader = new FXMLLoader(getClass().getResource("addrec5.fxml"));
        try {
            root = loader.load();
        } catch (IOException ex) {
            Logger.getLogger(TableController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if (text.equals("userentreprise")){
            AddrecController1 addrecController1 = loader.getController();
            addrecController1.getTable(text);
        }
        else if (text.equals("amdin"))
            loader = new FXMLLoader(getClass().getResource("addrec2.fxml"));
        else if (text.equals("superadmin"))
            loader = new FXMLLoader(getClass().getResource("addrec3.fxml"));
        else if (text.equals("guerite"))
            loader = new FXMLLoader(getClass().getResource("addrec4.fxml"));
        
        else if (text.equals("responsablesite")){
            AddrecControlle5r addrecController5 = loader.getController();
            addrecController5.getTable(text);
        }

        stage = new Stage();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
}