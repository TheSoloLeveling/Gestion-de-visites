/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication4;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class HadaController implements Initializable {
    @FXML
private VBox pnl_scroll ;
       @FXML
    private Label lbl1;
          @FXML
    private Label lbl2;
           @FXML
    private Label lbl3;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         refreshNodes();  
    }
   private void refreshNodes()
    {
        pnl_scroll.getChildren().clear();
        
        Node [] nodes = new  Node[15];
        
        for(int i = 0; i<10; i++)
        {
            try {
                nodes[i] = (Node)FXMLLoader.load(getClass().getResource("Item.fxml"));
             
               pnl_scroll.getChildren().add(nodes[i]);
                
            } catch (IOException ex) {
              
            }
           
        }
    }    
     @FXML
    private void handleButtonActionlb1(MouseEvent event) { 
    
     
       
        lbl1.setStyle("-fx-font-weight: bold");
        lbl2.setStyle("-fx-font-weight: normal");
        lbl3.setStyle("-fx-font-weight: normal");
       refreshNodes();
    }
      @FXML
    private void handleButtonActionlbl2(MouseEvent event) { 
        lbl1.setStyle("-fx-font-weight: normal");
        lbl2.setStyle("-fx-font-weight: bold");
         lbl3.setStyle("-fx-font-weight: normal");
       refreshNodes();
    }
      @FXML
    private void handleButtonActionlbl3(MouseEvent event) { 
         lbl1.setStyle("-fx-font-weight: normal");
        lbl2.setStyle("-fx-font-weight: normal");
        lbl3.setStyle("-fx-font-weight: bold");
       refreshNodes();
    }
}
