/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication4;





import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXToggleButton;
import java.io.IOException;
import static java.lang.Thread.sleep;
import java.sql.*;
import javafx.scene.control.Alert;
import javafx.scene.paint.Color;
import javaapplication4.SingletonConnection;


import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.util.Duration;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;



/**
 *
 * @author JISOO
 */
public class MainController implements Initializable {
    
    
    
    
    
    public static int c =0 ; 
    public static int cnt =0 ; 
    
    @FXML
    private JFXButton close;
    
  
    
  @FXML
    private JFXToggleButton dark;
      @FXML
    private Label menu;
    @FXML
    private AnchorPane layer1;
    @FXML
    private Pane layer2;
    @FXML
    private Pane layer3;
    @FXML
    private Button signin;
    @FXML
    private Label l1;
    @FXML
    private Label l2;
    @FXML
    private Label l3;
     @FXML
    private Label l4;
      @FXML
    private Label l5;
       @FXML
    private Label l6;
        @FXML
    private Label l7;
    @FXML
    private Label s1;
    @FXML
    private Label s2;
    @FXML
    private Label s3;
    @FXML
    private Button signup;
    @FXML
    private Label a2;
    @FXML
    private Label b2;
    @FXML
    private Label a1;
    @FXML
    private Label b1;
    @FXML
    private Label n1;
    @FXML
    private Separator n2;
    @FXML
    private Separator n3;
    @FXML
    private Label n4;
    @FXML
    private Label n5;
    @FXML
    private Button request;
    @FXML
    private Button btnsignin;
    @FXML
    private TextField u1;
    @FXML
    private TextField u2;
    @FXML
    private TextField u3;
         @FXML
    private PasswordField p1;
  
    @FXML
    private ImageView loadingImg;
   
       @FXML
    private ImageView img1;
          @FXML
    private ImageView img2;
    @FXML
    private Label lbError;
    
    
    private static final String HOVERED_BUTTON_STYLE = "-fx-background-color:#ffff";
    private static final String HOVERED_BUTTON_STYLE2 = "-fx-background-color: #252645";
    
    public boolean login(){
        String userName = u1.getText();
        String password = p1.getText();
        
        String sql = "SELECT * FROM compte WHERE login = ? and motDePasse = ? ";
        
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try{
            conn = SingletonConnection.getconn();
            ps = conn.prepareStatement(sql);
            ps.setString(1, userName);
            ps.setString(2, password);
            rs = ps.executeQuery();
            if(!rs.next()){
               
                lbError.setTextFill(Color.TOMATO);
                lbError.setText("Username/Password erroné");
                return false;
            }
            else{
                showDialogAuthentification("Login Successuful", null, "Success");
                loadingImg.setVisible(true);
                btnsignin.setDisable(true);
                
                return true;
            }
            
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }
    
    public void showDialogAuthentification(String name, String header, String title){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText(name);
        alert.setHeaderText(header);
        
        
        DialogPane dialogPane = alert.getDialogPane();
        dialogPane.getStylesheets().add(
        getClass().getResource("AlertStyle.css").toExternalForm());
        dialogPane.getStyleClass().add("myDialog");
        
        Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK){
                lbError.setTextFill(Color.GREEN);
                lbError.setText("Authentification ......");
            }
    }
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
   
       a2.setVisible(false);
     
     menu.setVisible(false);
     
    }    
    
       @FXML
    private void close() {
       System.exit(0);
    }
    
        @FXML
    private void hover() {
       btnsignin.setScaleX(1.1);
       btnsignin.setScaleY(1.1);
       
    }
     @FXML
     private void rhover() {
       btnsignin.setScaleX(1);
       btnsignin.setScaleY(1);
       
    }
      @FXML
      private void hoverP() {
       close.setScaleX(1.3);
       close.setScaleY(1.3);
        close.setScaleZ(1.3);
       
    }
     @FXML
     private void rhoverP() {
       close.setScaleX(1);
       close.setScaleY(1);
       
    }
       @FXML
     private void dark() {
        
         if(c%2==0){
             
       layer3.setStyle(HOVERED_BUTTON_STYLE2);    
      layer1.setStyle(HOVERED_BUTTON_STYLE2);
      a1.setVisible(false);
      a2.setVisible(true);
      c++ ; 
         }
         else{
             c++ ; 
        
           
              a1.setVisible(true);
      a2.setVisible(false);
           layer3.setStyle(HOVERED_BUTTON_STYLE);    
      layer1.setStyle(HOVERED_BUTTON_STYLE);
            
         }
    }

    @FXML
    private void btn() throws InterruptedException  {
         
        if(login()){
            new Dash().start();
        } 
}

        
     
    
    
   
    @FXML
  private void Slidemenu() {
      
      TranslateTransition openMenu=new TranslateTransition(new Duration(350), menu);
      TranslateTransition closeMenu=new TranslateTransition(new Duration(350), menu);
        TranslateTransition openNav=new TranslateTransition(new Duration(350), layer2);
        openNav.setToX(-150);
        TranslateTransition closeNav=new TranslateTransition(new Duration(350), layer2);
       openMenu.setToX(-130);
            if(layer2.getTranslateX()!=-150){
                openNav.play();
                openMenu.play();
                 
            }else{
                closeMenu.setToX(0);
                closeNav.setToX(-285);
                closeNav.play();
                closeMenu.play();

            }
      
    }
    
       @FXML
    private void hoverM() {
       menu.setScaleX(1.3);
       menu.setScaleY(1.3);
       
    }
     @FXML
     private void rhoverM() {
       menu.setScaleX(1);
       menu.setScaleY(1);
       
    }
  @FXML
     private void btnrequest(){
         if(cnt%2==0){
             u1.setText("") ;
         u1.setPromptText("ID");
         n5.setText("Give us  your ID");
         n2.setVisible(false);
         n1.setVisible(false);
         n3.setVisible(false);
         n4.setVisible(false);
         btnsignin.setVisible(false);
         p1.setVisible(false);
         
          request.setLayoutY(250);
         TranslateTransition layer2T=new TranslateTransition(new Duration(350), layer2);
         TranslateTransition layer3T=new TranslateTransition(new Duration(350), layer3);
         layer2T.setToX(483);
         layer3T.setToX(-350);
         layer2T.play();
         layer3T.play();
     close.setLayoutX(800);
         cnt++ ; 
     }
         else{
               close.setLayoutX(450);
            u1.setText("") ;
                  u1.setPromptText("UserName");
         n5.setText("Welcome Back");
         n2.setVisible(true);
         n1.setVisible(true);
         n3.setVisible(true);
         n4.setVisible(true);
         btnsignin.setVisible(true);
         p1.setVisible(true);
          close.setVisible(true);
          request.setLayoutY(370);
         TranslateTransition layer2T=new TranslateTransition(new Duration(350), layer2);
         TranslateTransition layer3T=new TranslateTransition(new Duration(350), layer3);
         layer2T.setToX(0);
         layer3T.setToX(0);
         layer2T.play();
         layer3T.play();
   
         cnt++ ;
             }
             
         }
     
         class Dash extends Thread {
            @Override  
       public void run(){
                try {
                    Thread.sleep(3000);
                    menu.setVisible(true);
                    u1.setVisible(false);
                    p1.setVisible(false);
                    l1.setVisible(false);  
                    l2.setVisible(false); 
                    l3.setVisible(false); 
                    l4.setVisible(false); 
                    n1.setVisible(false);
                    n2.setVisible(false);
                    n3.setVisible(false);
                    n4.setVisible(false);
                    n5.setVisible(false);
                    btnsignin.setVisible(false);
                    request.setVisible(false);
                } catch (InterruptedException ex) {
                    Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
                }
            Platform.runLater(new Runnable() {
                @Override  
       public void run(){
            Parent root = null ;
        try {
             root = FXMLLoader.load (getClass().getResource("all.fxml"));
           
            
        } catch (IOException ex) {
            Logger.getLogger(SplashScreenController.class.getName()).log(Level.SEVERE, null, ex);
        }
         Scene secene = new Scene(root) ; 
            Stage stage = new Stage() ; 
            stage.setScene(secene);
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.show() ; 
            close.getScene().getWindow().hide();
       }
          }) ;    
       
        
  
     
    
        
    }
    
    
    }
     
     }
   





