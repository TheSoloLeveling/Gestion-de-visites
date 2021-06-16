 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication4;

import Utils.Crud;
import com.jfoenix.controls.JFXComboBox;
import com.mysql.cj.xdevapi.Statement;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class FXML3Controller implements Initializable {
@FXML
WebView webView ;
@FXML
Pane layer2 ;
@FXML
Pane layer21 ;
@FXML
Pane layerdelete ;
@FXML
JFXComboBox  jc ;
@FXML
TextField  u1 ;
@FXML
TextField  lb ;
@FXML
TextField  u11 ;
@FXML
TextField  u111 ;
@FXML
Circle  a ;
@FXML
Circle  b ;
@FXML
Circle c;

 public static WebEngine webEngine  ;
    int lat =0 ;
   int lon =0 ;
   
   static String op="" ; 
    static String nn="" ; 
    static String no="" ; 
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        lb.setText(""+Crud.countdemS()) ; 
        
        if(FXML1Controller.profile.equals("ad")){
            a.setVisible(false);
        } else if(FXML1Controller.profile.equals("gr")){
            a.setVisible(false);
             b.setVisible(false);
              c.setVisible(false);
        }
         else if(FXML1Controller.profile.equals("rs")){
            a.setVisible(false);
             b.setVisible(false);
              c.setVisible(false);
        }
        
        
        
      reff() ; 
        
     webEngine = webView.getEngine();

     webEngine.load("http://localhost/server/ez.php");
      webEngine.getLoadWorker().stateProperty().addListener((observable, oldValue, newValue) ->
{
 
});

    }

@FXML
   public void refresh() {
         webEngine.load("http://localhost/server/ez.php");
    }    
         @FXML
  private void Slidemenu() {
 
        TranslateTransition openNav=new TranslateTransition(new Duration(350), layer2);
        openNav.setToX(-300);
        TranslateTransition closeNav=new TranslateTransition(new Duration(350), layer2);
            if(layer2.getTranslateX()!=-300){
            
                openNav.play();
   
            }else{
                closeNav.setToX(0);
                closeNav.play();
    
            }
      
    }
  
          @FXML
  private void Slidemenu1() {
 
        TranslateTransition openNav=new TranslateTransition(new Duration(350), layerdelete);
        openNav.setToX(-600);
        TranslateTransition closeNav=new TranslateTransition(new Duration(350), layerdelete);
            if(layerdelete.getTranslateX()!=-600){
            
                openNav.play();
   
            }else{
                closeNav.setToX(0);
                closeNav.play();
    
            }
      
    }
     @FXML
   private void Slidemenu2() {
 
        TranslateTransition openNav=new TranslateTransition(new Duration(350), layer21);
        openNav.setToX(-950);
        TranslateTransition closeNav=new TranslateTransition(new Duration(350), layer21);
            if(layer21.getTranslateX()!=-950){
            
                openNav.play();
   
            }else{
                closeNav.setToX(0);
                closeNav.play();
    
            }
      
    }
  
          @FXML
  private void btn() {
      op="add" ; 
      nn=u1.getText() ; 
 load();
        TranslateTransition openNav=new TranslateTransition(new Duration(350), layer2);
        openNav.setToX(-300);
        TranslateTransition closeNav=new TranslateTransition(new Duration(350), layer2);
            if(layer2.getTranslateX()!=-300){
            
                openNav.play();
   
            }else{
                closeNav.setToX(0);
                closeNav.play();
    
            }
   reff() ;
    }
  
            @FXML
  private void btn1() {
 String a = jc.getSelectionModel().getSelectedItem().toString() ; 

 String sql="delete from site where name = '"+a+"'" ; 
 Connection cnn = SingletonConnection.getconn() ; 
 try{
     PreparedStatement ps = cnn.prepareStatement(sql) ; 
     ps.executeUpdate() ; 
 }catch(SQLException ex){
     ex.printStackTrace();
 }
     webEngine.load("http://localhost/server/ez.php");  

        TranslateTransition closeNav=new TranslateTransition(new Duration(350), layerdelete);
           
                closeNav.setToX(0);
                closeNav.play();
    
          reff() ;  
      
    }
  
           @FXML
  private void btn2() {
      op="update" ; 
      nn=u11.getText() ; 
      no=u111.getText() ; 
 load();
        
        TranslateTransition closeNav=new TranslateTransition(new Duration(350), layer21);
          
            
               
   
            
                closeNav.setToX(0);
                closeNav.play();
    
            
           
      reff() ; 
    }
  
  
  
  
  
     @FXML
    private void load() {
       
    Parent root=null;
        try {
            root = FXMLLoader.load(getClass().getResource("SecondMap.fxml"));
        } catch (IOException ex) {
           ex.printStackTrace();
        }
      Scene secene = new Scene(root) ; 
            Stage stage = new Stage() ; 
            stage.setScene(secene);
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.show() ; 
             
       

    }
    
     @FXML
    private void reff() {
        if(jc.getItems()==null){
        }
        else{jc.getItems().clear();}
       
     String sql="select name from site " ; 
 Connection cnn = SingletonConnection.getconn() ; 
 try{
     PreparedStatement ps = cnn.prepareStatement(sql) ; 
     ResultSet rs = ps.executeQuery() ; 
     while(rs.next()){
         jc.getItems().add(rs.getString(1)) ; 
     }
 }catch(SQLException ex){
     ex.printStackTrace();
 }
      
    }
    
  public class JavaBridge
{
  
    public  void log(String text)
    {
        
     
    System.out.print(text);
    
    
        
    }
}
  
  
 
  
  

  
  
  
    }    
    
        
