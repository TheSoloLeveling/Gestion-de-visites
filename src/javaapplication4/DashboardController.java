/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication4;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javaapplication4.Item2Controller.c;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections ;
import static javafx.collections.FXCollections.observableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.chart.PieChart;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;


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
	
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    dark() ;
    load() ; 
        ObservableList<PieChart.Data> Data  = FXCollections.observableArrayList( new PieChart.Data("site", 13) ,new PieChart.Data("site", 25),
                new PieChart.Data("site", 25) , 
                new PieChart.Data("site", 10) ,new PieChart.Data("site", 22)
                ) ;
        pie.setData(Data);
    } 
    
    @FXML
     private AnchorPane layer1 ;
    
      @FXML
     private void dark() {
        
         if(FXML1Controller.c%2==0){
             
       layer1.setStyle(HOVERED_BUTTON_STYLE);    
     
      FXML1Controller.c++ ; 
         }
         else{
           FXML1Controller.  c++ ; 
        
           
             
           layer1.setStyle(HOVERED_BUTTON_STYLE2);    
   
            
         }
    }
           @FXML
  private void load() {
      
     Parent root =null ; 
     
        try { 
            root= FXMLLoader.load(getClass().getResource("scrol.fxml")) ;
        } catch (IOException ex) {
            Logger.getLogger(FXML1Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        
          bor.setCenter(root);
         
         
  } 
}
