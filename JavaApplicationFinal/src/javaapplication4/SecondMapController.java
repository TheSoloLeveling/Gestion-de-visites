package javaapplication4;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import netscape.javascript.JSObject;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import java.sql.*;
import static javaapplication4.FXML3Controller.webEngine;
/**
 * FXML Controller class
 *
 * @author hp
 */
public class SecondMapController implements Initializable {
      public static Double lt ;
  public   static Double ln ;
private final JavaBridge bridge = new JavaBridge();

       final URL urlGoogleMaps = getClass().getResource("lol.html");
@FXML
WebView webView ;
@FXML
Pane layer2 ;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     WebEngine webEngine = webView.getEngine();
     webEngine.load(urlGoogleMaps.toExternalForm());
       webEngine.getLoadWorker().stateProperty().addListener((observable, oldValue, newValue) ->
{
    JSObject window = (JSObject) webEngine.executeScript("window");
    window.setMember("java", bridge);
    webEngine.executeScript("console.log = function(message)\n" +
        "{\n" +
        "    java.log(message);\n" +
        "};");
});
                
            
  
    }  


public class JavaBridge
{
  
    public  void log(String text)
    {
        
       int a=  text.indexOf(",") ;
       
       String lat =text.substring(0, a) ;
       String lan =text.substring(a+1, text.length()) ;
       
        lt = Double.parseDouble(lat) ; 
        ln = Double.parseDouble(lan) ; 
    
    
        
    }
}
     @FXML
   private void  close(){
      String a = FXML3Controller.nn ; 
      String b = FXML3Controller.op ;
       String c = FXML3Controller.no;
      webView.getScene().getWindow().hide();
      if(b.equals("add")){
        String sql="insert into site.site values(?,?,?)" ;
    Connection cnn =SingletonConnection.getconn() ;
    try{
    PreparedStatement ps =cnn.prepareStatement(sql) ; 
    ps.setDouble(1, SecondMapController.lt);
    ps.setDouble(2, SecondMapController.ln);
     ps.setString(3, a);
     FXML3Controller.nn="" ; 
     FXML3Controller.op="" ; 
    ps.executeUpdate() ;
    } catch(Exception ex){
      ex.printStackTrace();
    }
      }
       if(b.equals("update") &&  c.isEmpty()){
           System.out.print(SecondMapController.ln +" "+SecondMapController.ln);
        String sql="update  site  set lat = '"+SecondMapController.ln+"'"+ ", lang='"+SecondMapController.lt+"'"+ " where name ='"+a+"'" ;
    Connection cnn =SingletonConnection.getconn() ;
    try{
    PreparedStatement ps =cnn.prepareStatement(sql) ; 
   
     
     FXML3Controller.nn="" ; 
     FXML3Controller.op="" ;
    ps.executeUpdate() ;
    System.out.print(sql);
    } catch(Exception ex){
      ex.printStackTrace();
    }
      }
        if(b.equals("update") &&  !c.isEmpty()){
        String sql="update  site.site  set lang = ? , lat=? , name=? where name =?" ;
    Connection cnn =SingletonConnection.getconn() ;
    try{
    PreparedStatement ps =cnn.prepareStatement(sql) ; 
    ps.setDouble(1, SecondMapController.lt);
    ps.setDouble(2, SecondMapController.ln);
     ps.setString(3, c);
     ps.setString(4, a);
     FXML3Controller.nn="" ; 
     FXML3Controller.no="" ; 
     FXML3Controller.op="" ;
    ps.executeUpdate() ;
    } catch(Exception ex){
      ex.printStackTrace();
    }
      }
    
     webEngine.load("http://localhost/server/ez.php");  
  }
}


