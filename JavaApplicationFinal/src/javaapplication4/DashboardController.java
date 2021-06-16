/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication4;

import Utils.Admin;
import Utils.Crud;
import Utils.Guerite;
import Utils.ResponsableSite;
import Utils.SingletonConnection;
import Utils.SuperAdmin;
import Utils.UserEntreprise;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javaapplication4.Item2Controller.c;
import static javaapplication4.MainController.actualAccount;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections ;
import static javafx.collections.FXCollections.observableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;


/**
 * FXML Controller class
 *
 * @author hp
 */
public class DashboardController implements Initializable {
      private static final String HOVERED_BUTTON_STYLE = "#ffff";
    private static final String HOVERED_BUTTON_STYLE2 = "#252645";
    @FXML
    private PieChart pie ;
    @FXML
    private BorderPane bor ; 
     @FXML
    private AnchorPane AnchorPane ; 
     @FXML 
     private Label totaldem ; 
     @FXML 
     private Label totaldemA ; 
     @FXML 
     private Label totaldemR ; 
     @FXML 
     private Label tu ; 
     @FXML 
     private Label ts ; 
     @FXML 
     private Label tv ; 
     
	int a=0 ; 
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          a = Crud.countG()+Crud.countad()+Crud.countrs()+Crud.countus()+Crud.countsup() ;
    tu.setText(""+a);
    int b =Crud.countdemA() ; 
    totaldemA.setText(""+b);
    int b1 =Crud.countdemR() ; 
    totaldemR.setText(""+b1);
    int c = Crud.countdemS() ; 
    ts.setText(""+c);
    tv.setText(""+b);
      totaldem.setText(""+(b+b1));
        
    dark() ;
    load() ; 
    
    double a1 = (double)Crud.countG()/a*100 ; 
    double a2=(double)Crud.countad()/a*100 ; 
    double a3= (double) Crud.countrs()/a*100 ; 
    double a4= (double) Crud.countsup()/a*100 ; 
    double a5=(double) Crud.countus()/a*100 ; 
    System.out.print( "fcrgfrgtrt:"+  ( (double) Crud.countG()/a));
      ObservableList<PieChart.Data> Data  = FXCollections.observableArrayList( new PieChart.Data("geurite",a1 ) ,new PieChart.Data("admin", a2),
                new PieChart.Data("responsablesite", a3) , 
                new PieChart.Data("superadmin", a4) ,new PieChart.Data("user", a5)
                ) ;
        pie.setData(Data);
    } 
    
    public void siteStats(){
       
        /*String sql = "SELECT * FROM re WHERE login = ? and motDePasse = ? ";
        
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try{
            conn = SingletonConnection.getconn();
            ps = conn.prepareStatement(sql);
            ps.setString(1, userName);
            ps.setString(2, password);
            rs = ps.executeQuery();
           
                
        }catch(Exception e){
            e.printStackTrace();
        }*/
        
    }
    @FXML
     private AnchorPane layer1 ;
    
      @FXML
     private void dark() {
        
         if(DashController.c%2==0){
             
       layer1.setStyle(HOVERED_BUTTON_STYLE);    
     
      DashController.c++ ; 
         }
         else{
           DashController.  c++ ; 
        
           
             
           layer1.setStyle(HOVERED_BUTTON_STYLE2);    
   
            
         }
    }
           @FXML
  private void load() {
      
     Parent root =null ; 
     
        try { 
            root= FXMLLoader.load(getClass().getResource("scrol.fxml")) ;
        } catch (IOException ex) {
            Logger.getLogger(DashController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
          bor.setCenter(root);
         
         
  } 
}
