package javaapplication4;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

public class Controller implements Initializable {

    @FXML
    private VBox pnItems ;
  
  @FXML 
  private AnchorPane layer1 ; 
   @FXML 
  private Pane layer2 ; 
   @FXML 
  private Pane pane; 
     @FXML 
  private HBox layer3 ; 
   @FXML 
  private TextField sh ;
 @FXML 
  private StackPane lol ;
    

    @Override
    public void initialize(URL location, ResourceBundle resources) {
 dark() ;
        
        Node[] nodes = new Node[10];
        for (int i = 0; i < nodes.length; i++) {
            try {

                final int j = i;
                nodes[i] = FXMLLoader.load(getClass().getResource("kkl.fxml"));

                //give the items some effect

                nodes[i].setOnMouseEntered(event -> {
                    nodes[j].setStyle("-fx-background-color : #795AF3");
                });
                nodes[i].setOnMouseExited(event -> {
                    nodes[j].setStyle("-fx-background-color :  linear-gradient(to right,#795AF3 ,#3929E0)");
                });
                pnItems.getChildren().add(nodes[i]);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


   
     @FXML
     private void dark() {
        
         if(MainController.c%2==0){

        
      layer1.setStyle("#ffff");
      layer2.setStyle("#ffff");
      layer3.setStyle("#ffff");
      pane.setStyle("#ffff");
      lol.setStyle("#ffff");
      MainController.c++ ; 
   
         }
         else{
             MainController.c++ ; 
      layer1.setStyle(" #252645");
      layer2.setStyle(" #252645");
      layer3.setStyle(" #252645"); 
      pane.setStyle(" #252645"); 
      lol.setStyle("#252645");
         }
    }
}
