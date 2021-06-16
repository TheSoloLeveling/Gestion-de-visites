/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication4;

import Utils.Crud;
import com.jfoenix.controls.JFXComboBox;
import java.sql.PreparedStatement;
import java.io.IOException;
import static java.lang.Math.pow;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Arrays;
import java.sql.Date;
import java.util.ResourceBundle;
import static javaapplication4.NewClass.index;
import javafx.animation.TranslateTransition;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;             
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Pagination;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.util.Callback;
import javafx.util.Duration;

public class TableController1 implements Initializable {

    @FXML
    private TableView tableView;
    
    ObservableList<Record> data = FXCollections.observableArrayList();
     
    public static class Record {
        private  String value_0;
        private  String value_1;
        private  String value_2;
        private  String value_3;
        private  String value_4;
         private  String value_5;
         private  String value_6;
         private  String value_7;
         private  String value_8;
         
        Record() {
          
        }
        Record(String v0, String v1, String v2 ,String v3 ,
                String v4, String v5 ,String v6, String v7, String v8) {
           
            this.value_0 = v0;
            this.value_1 = v1;
            this.value_2= v2;
            this.value_3= v3;
            this.value_4= v4;
            this.value_5 = v5;
            this.value_6 = v6;
            this.value_7 = v7;
            this.value_8 = v8;
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
        
        public String getValue_7() {
            return value_7;
        }
        
        public String getValue_8() {
            return value_8;
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
        
        public void setValue_7(String value_7) {
            this.value_7 = value_7;
        }
        
        public void setValue_8(String value_8) {
            this.value_8= value_8;
        }
 
    };
    
 
    
 
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
    
       @Override
    public void initialize(URL url, ResourceBundle rb) {
        tableView.setVisible(false);
            String[] header1 = {"nom", "prenom", "cnie", "beginDate", "endDate", "time", "userEntreprise", "entreprise", "etat"};
            createTable(header1, tableView, data);
            
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try{
        String sql = "SELECT * FROM demande natural join userentreprise where login = ?";
        conn = Utils.SingletonConnection.getconn();
        ps = conn.prepareStatement(sql);
        ps.setString(1, MainController.actualAccount.getLogin());
        rs = ps.executeQuery();
        
        while(rs.next()){
            String a = rs.getString(1);
                String b = rs.getString(2);
                String c = rs.getString(3);
                String d = rs.getString(4);
                Date e = rs.getDate(5);
                Date f = rs.getDate(6);
                
                String ee = e.toString();
                String ff = f.toString();
                String g =  rs.getString(7);
                String h = rs.getString(8);
                String i = rs.getString(9);
                String j = rs.getString(10);
                String jj = "" + j;
                
            Record newRec = new Record(b,c,d,ee,ff,g,h,i,j);
            data.add(newRec);

        }
            rs.close();
            ps.close();                             
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
}