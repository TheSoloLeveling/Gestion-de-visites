/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication4;

import Utils.Crud;
import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;
import javafx.animation.TranslateTransition;
import javafx.beans.value.ChangeListener;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Pagination;
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

/**
 * FXML Controller class
 *
 * @author hp
 */


public class HadaController implements Initializable {
 
    
    public static LinkedList<Node> nodes = new LinkedList<>();
    
    @FXML
private VBox pnl_scroll ;
       @FXML
    private Label lbl1;
          @FXML
    private Label lbl2;
           @FXML
    private Label lbl3;
                    @FXML
    private Pane layer2;
                    @FXML
                    Pagination p ;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
       //nodes.removeAll(nodes);
       refreshNodes(); 
       p.setPageFactory(new Callback<Integer, Node>() {
            @Override
            public Node call(Integer index) {

                StackPane page = new StackPane();

                GridPane grid = new GridPane();

                grid.setHgap(20);
                grid.setVgap(20);
                grid.setPadding(new Insets(20, 20, 20, 20));

                int total = Crud.getDemands().size() - 1 ; 
                int rows = 2 ; 
                int cols = 2 ; 

                int offset = rows * cols * index;
                
                
                for (int row = 0; row < rows; row++) {
                    for (int col = 0; col < cols; col++) {
                        
                        offset++;

                        if (offset > total)
                            break;

                        StackPane container = new StackPane();
                        container.setStyle("-fx-background-color:white");

                        GridPane.setRowIndex(container, row);
                        GridPane.setColumnIndex(container, col);
                        container.getChildren().add(nodes.get(offset));
                        GridPane.setHgrow(container, Priority.ALWAYS);
                        GridPane.setVgrow(container, Priority.ALWAYS);

                        grid.getChildren().add(container);
                    }
                     
                }
                StackPane container = new StackPane();
                
                grid.getChildren().add(container);
                page.getChildren().add(grid);

                return page;
            }
        });
    }
    /* @FXML
    private void close() {
        nodes.removeAll(nodes);
    }*/
   private void refreshNodes()
    {
       // pnl_scroll.getChildren().clear();
      
        
        int j = 0;
        for(int i = 0; i<15; i++)
        //{
            try {
                    
                    nodes.add((Node)FXMLLoader.load(getClass().getResource("Item.fxml")));
                    
                    
           //     
            } catch (IOException ex) {
              
            }
           
       // }
    }    
   /*  @FXML
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
    }*/
    
     @FXML
    private void slidemenu() { 
     
        TranslateTransition openNav=new TranslateTransition(new Duration(750), layer2);
        openNav.setToX(-500);
       openNav.play();
        TranslateTransition closeNav=new TranslateTransition(new Duration(750), layer2);
       
            if(layer2.getTranslateX()!=-500){
              
                openNav.play();
       
             
            }else{
             
           
                closeNav.setToX(270);
                closeNav.play();
        
            }
    }
}
