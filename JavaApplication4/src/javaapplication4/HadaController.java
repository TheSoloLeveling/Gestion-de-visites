/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication4;

import Utils.Crud;
import com.jfoenix.controls.JFXComboBox;
import java.io.IOException;
import static java.lang.Math.pow;
import java.net.URL;
import java.util.Arrays;
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
    StackPane page ;
  static  int c =0 ; 
  GridPane grid  ;
  StackPane container ; 
 public static   Node [] nodes=new  Node[30] ;
    @FXML
private VBox pnl_scroll ;
       @FXML
    private Label lbl1;
          @FXML
    private Label lbl2;
                @FXML
    private Label jj;
           @FXML
    private Label lbl3;
               @FXML
    private Label id;
                    @FXML
    private Pane layer2;
                    @FXML
                    Pagination p ;
                    
                    @FXML
                   private Label ue ;
                    @FXML
                      private Label entrepriseS;
                    @FXML
                     private Label duration ;
                    @FXML
                     private Label siteS ;
                    @FXML
                     private Label visitor ;
                    @FXML
                     private Label cnieS ;
                    @FXML
                     private JFXComboBox state ;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        go() ; 
    }
   private void refreshNodes()
    {
        c=0 ; 
       // pnl_scroll.getChildren().clear();
      
   
        
        for(int i = 0; i<15; i++)
        {
            try {
              //   NewClass jt =new NewClass() ;
       // jt.lol(i);
                nodes[i] = (Node)FXMLLoader.load(getClass().getResource("Item.fxml"));
             
             //  pnl_scroll.getChildren().add(nodes[i]);
           //     
            } catch (IOException ex) {
              
            }
           
        }
    }    
     @FXML
    private void handleButtonActionlb1(MouseEvent event) { 
    
       
       
       
    }
      @FXML
    private void handleButtonActionlbl2(MouseEvent event) { 
        lbl1.setStyle("-fx-font-weight: normal");
        lbl2.setStyle("-fx-font-weight: bold");
         lbl3.setStyle("-fx-font-weight: normal");
       refreshNodes();
    }
      @FXML
    private void handleButtonActionlbl3() { 
        
       
      String lol ="" ; 
      
       TranslateTransition closeNav=new TranslateTransition(new Duration(750), layer2);
         closeNav.setToX(270);
                closeNav.play();
                try{
                 lol =  state.getSelectionModel().getSelectedItem().toString() ;
                }catch(Exception e){}
                if(!lol.equals("")){
                    Crud.updateUser(lol, id.getText() );
                  
                    go1() ; 
                    refreshNodes() ;
                }
    }
    
     @FXML
    private void slidemenu1() { 
    
        TranslateTransition openNav=new TranslateTransition(new Duration(750), layer2);
        openNav.setToX(-500);
       
        TranslateTransition closeNav=new TranslateTransition(new Duration(750), layer2);
       
            if(layer2.getTranslateX()!=-500){
                int a =p.getCurrentPageIndex()   ;
                int r = (int) (1+Math.pow(4,a)) ; 
               
                if(r==2){
                r-- ; } if(NewClass.g[r]==null){
                    
                 }else{
               
                id.setText(NewClass.g[r].id);
                jj.setText(NewClass.g[r].etat);
                ue.setText(NewClass.g[r].nom);
                entrepriseS.setText(NewClass.g[r].entreprise);
                visitor.setText(NewClass.g[r].prenom);
                cnieS.setText(NewClass.g[r].cnie);
                
                 if(NewClass.g[r]==null){
                     
                 }
                 
                openNav.play();
                }
             
            }else{
             
           
                closeNav.setToX(270);
                closeNav.play();
        
            }
    }
    
      @FXML
    private void slidemenu2() { 
    
        TranslateTransition openNav=new TranslateTransition(new Duration(750), layer2);
        openNav.setToX(-500);
       
        TranslateTransition closeNav=new TranslateTransition(new Duration(750), layer2);
       
            if(layer2.getTranslateX()!=-500){
                int a =p.getCurrentPageIndex()   ;
                int r = (int) (2+Math.pow(4,a)) ; 
                if(r==3){
                r-- ; }
                 if(NewClass.g[r]==null){
                     
                 }else if(NewClass.g[r]!=null){
               
                jj.setText(NewClass.g[r].etat);
                ue.setText(NewClass.g[r].nom);
                entrepriseS.setText(NewClass.g[r].entreprise);
                visitor.setText(NewClass.g[r].prenom);
                cnieS.setText(NewClass.g[r].cnie);
         System.out.print(NewClass.g[r].etat);
           if(NewClass.g[r]==null){
                     
                 }
                 
                openNav.play();
                 }
             
                

            }else{
             
           
                closeNav.setToX(270);
                closeNav.play();
        
            }
    }
    
      @FXML
    private void slidemenu3() { 
    
        TranslateTransition openNav=new TranslateTransition(new Duration(750), layer2);
        openNav.setToX(-500);
      
        TranslateTransition closeNav=new TranslateTransition(new Duration(750), layer2);
       
            if(layer2.getTranslateX()!=-500){
                int a =p.getCurrentPageIndex()   ;
                int r = (int) (3+Math.pow(4,a)) ; 
                if(r==4){
                r-- ; }
                 if(NewClass.g[r]==null){
                     
                 }else{
                     System.out.print( r+" " +  NewClass.g[r]) ;
                jj.setText(NewClass.g[r].etat);
                ue.setText(NewClass.g[r].nom);
                entrepriseS.setText(NewClass.g[r].entreprise);
                visitor.setText(NewClass.g[r].prenom);
                cnieS.setText(NewClass.g[r].cnie);
         
                
                 
                openNav.play();
                 }
       
             
            }else{
             
           
                closeNav.setToX(270);
                closeNav.play();
        
            }
    }
      @FXML
    private void slidemenu4() { 
    
        TranslateTransition openNav=new TranslateTransition(new Duration(750), layer2);
        openNav.setToX(-500);
      
        TranslateTransition closeNav=new TranslateTransition(new Duration(750), layer2);
       
            if(layer2.getTranslateX()!=-500){
               int a =p.getCurrentPageIndex()  ;
                int r = (int) (4+Math.pow(4,a)) ; 
                if(r==5){
                r-- ; }
                 if(NewClass.g[r]==null){
                     
                 }else{
                jj.setText(NewClass.g[r].etat);
                ue.setText(NewClass.g[r].nom);
                entrepriseS.setText(NewClass.g[r].entreprise);
                visitor.setText(NewClass.g[r].prenom);
                cnieS.setText(NewClass.g[r].cnie);
         
                 
                 
                openNav.play();
                 }
       
             
            }else{
             
           
                closeNav.setToX(270);
                closeNav.play();
        
            }
    }
    
    
    @FXML 
    private void go(){
         state.getItems().add("Demand Accepted") ; 
        state.getItems().add("Demand Rejected") ; 
      refreshNodes() ; 
       p.setPageFactory(new Callback<Integer, Node>() {
            @Override
            public Node call(Integer index) {
                if(page!=null){
                 } 
                 page = new StackPane();

                 grid = new GridPane();

                grid.setHgap(20);
                grid.setVgap(20);
                grid.setPadding(new Insets(20, 20, 20, 20));

                int total = Crud.getDemands().size()-1;  
                int rows = 2 ; 
                int cols = 2 ; 

                int offset = rows * cols * index;
                   
                for (int row = 0; row < rows; row++) {
                    for (int col = 0; col < cols; col++) {

                        offset++;

                        if (offset > total)
                            break;

                        container = new StackPane();
                        if(container!=null){
                            System.out.print("null") ;
                            container.getChildren().removeAll() ; 
                            
                        }
                        container.setStyle("-fx-background-color:white");
                                                                               
                        container.getChildren().add(nodes[offset]);

                        GridPane.setRowIndex(container, row);
                        GridPane.setColumnIndex(container, col);
                        GridPane.setHgrow(container, Priority.ALWAYS);
                        GridPane.setVgrow(container, Priority.ALWAYS);

                        grid.getChildren().add(container);
                    }
                }

                page.getChildren().add(grid);

                return page;
            }
        });
       System.out.print(Arrays.toString(NewClass.g   ));
    }
@FXML 
    private void go1() {
         state.getItems().add("Demand Accepted") ; 
        state.getItems().add("Demand Rejected") ; 
      refreshNodes() ; 
       p.setPageFactory(new Callback<Integer, Node>() {
            @Override
            public Node call(Integer index) {
                if(page!=null){
                 } 
                 page = new StackPane();

                 grid = new GridPane();

                grid.setHgap(20);
                grid.setVgap(20);
                grid.setPadding(new Insets(20, 20, 20, 20));

                int total = Crud.getDemands().size()-1;  
                int rows = 2 ; 
                int cols = 2 ; 

                int offset = rows * cols * index;
                   
                for (int row = 0; row < rows; row++) {
                    for (int col = 0; col < cols; col++) {

                        offset++;

                        if (offset > total)
                            break;

                        container = new StackPane();
                        if(container!=null){
                            System.out.print("null") ;
                            container.getChildren().removeAll() ; 
                            
                        }
                        container.setStyle("-fx-background-color:white");
                                                                               
                        container.getChildren().add(nodes[offset]);

                        GridPane.setRowIndex(container, row);
                        GridPane.setColumnIndex(container, col);
                        GridPane.setHgrow(container, Priority.ALWAYS);
                        GridPane.setVgrow(container, Priority.ALWAYS);

                        grid.getChildren().add(container);
                    }
                }

                page.getChildren().add(grid);

                return page;
            }
        });
    }
    
}
