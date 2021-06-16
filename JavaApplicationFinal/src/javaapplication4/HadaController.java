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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javaapplication4.NewClass.index;
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
      DateFormat format1 = new SimpleDateFormat("yyyy/MM/dd");
        DateFormat format2 = new SimpleDateFormat("HH:mm:ss");
        
    int r =-1  ; 
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
                                 @FXML
                             private Label dayS;
                                  @FXML
                             private Label monthS ;
                                   @FXML
                             private Label yearS;
                                     @FXML
                             private Label dayB;
                                  @FXML
                             private Label mountB ;
                                   @FXML
                             private Label yearB;
                                
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        state.getItems().add("Demand Accepted") ; 
        state.getItems().add("Demand Rejected") ;
        go() ; 
        int count = 0;
        for(int i = 0; i < nodes.length; i++){
            if (nodes[i] != null)
                count ++ ;
        }
        
        int pageCount = count%4;
        if (pageCount == 0)
            pageCount = 1;
        p.setMaxPageIndicatorCount(pageCount);
        p.setPageCount(pageCount);
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
          
   
       TranslateTransition closeNav=new TranslateTransition(new Duration(750), layer2);
         closeNav.setToX(270);
                closeNav.play();
               
        try {
           
      
    //AddingParagraph.creteaPDF(NewClass.g[r].getNom(), NewClass.g[r].getPrenom(), ""+NewClass.g[r].getDateB(), ""+NewClass.g[r].getUe(),""+NewClass.g[r].getEntreprise());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
                
               }
      @FXML
    private void handleButtonActionlbl3() { 
        
       
      String lol ="" ; 
      
       TranslateTransition closeNav=new TranslateTransition(new Duration(750), layer2);
         closeNav.setToX(270);
                closeNav.play();
                try{
                 lol =  state.getSelectionModel().getSelectedItem().toString() ;
                 System.out.println("state eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee: "+lol);
                 System.out.println("id eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee: "+id.getText());
                }catch(Exception e){ e.printStackTrace();}
                if(!lol.equals("")){
                    Crud.updateUser(lol, id.getText());
                  
                    go1() ; 
                }
    }
    
     @FXML
    private void slidemenu1() { 
    
        TranslateTransition openNav=new TranslateTransition(new Duration(750), layer2);
        openNav.setToX(-530);
       
        TranslateTransition closeNav=new TranslateTransition(new Duration(750), layer2);
       
            if(layer2.getTranslateX()!=-530){
                int a =p.getCurrentPageIndex()   ;
                 r = (int) (1+Math.pow(4,a)) ; 
               
                if(r==2){
                r-- ; } if(NewClass.g[r]==null){
                    
                 }else{
               
                id.setText(NewClass.g[r].getId());
                if(NewClass.g[r].isEtat() == 1)
                    jj.setText("Demand Accepted");
                else if (NewClass.g[r].isEtat() == -1)
                    jj.setText("Demand On Hold");
                else
                    jj.setText("Demand Rejected");
                
                ue.setText(NewClass.g[r].getNom());
                entrepriseS.setText(NewClass.g[r].getEntreprise());
                visitor.setText(NewClass.g[r].getPrenom());
                cnieS.setText(NewClass.g[r].getCnie());
                   String date[] = format1.format(NewClass.g[r].getDateB()).split("/");
                   String date1[] = format1.format(NewClass.g[r].getDateE()).split("/");
                 
                 yearB.setText(""+date[0]);
               mountB.setText(date[1]);
                dayB.setText(date[2]);
                
                yearS.setText(date1[0]);
               monthS.setText(date1[1]);
               dayS.setText(date1[2]);
                
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
        openNav.setToX(-530);
       
        TranslateTransition closeNav=new TranslateTransition(new Duration(750), layer2);
       
            if(layer2.getTranslateX()!=-530){
                int a =p.getCurrentPageIndex()   ;
                 r = (int) (2+Math.pow(4,a)) ; 
                if(r==3){
                r-- ; }
                 if(NewClass.g[r]==null){
                     
                 }else if(NewClass.g[r]!=null){
                     id.setText(NewClass.g[r].getId());
               System.out.print(Arrays.toString(NewClass.g))   ;
                if(NewClass.g[r].isEtat() == 1)
                    jj.setText("Demand Accepted");
                else if (NewClass.g[r].isEtat() == -1)
                    jj.setText("Demand On Hold");
                else
                    jj.setText("Demand Rejected");
                
                ue.setText(NewClass.g[r].getNom());
                entrepriseS.setText(NewClass.g[r].getEntreprise());
                visitor.setText(NewClass.g[r].getPrenom());
                cnieS.setText(NewClass.g[r].getCnie());
                  String date[] = format1.format(NewClass.g[r].getDateB()).split("/");
                   String date1[] = format1.format(NewClass.g[r].getDateE()).split("/");
                 
                 yearB.setText(""+date[0]);
               mountB.setText(date[1]);
                dayB.setText(date[2]);
                
                yearS.setText(date1[0]);
               monthS.setText(date1[1]);
               dayS.setText(date1[2]);
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
        openNav.setToX(-530);
      
        TranslateTransition closeNav=new TranslateTransition(new Duration(750), layer2);
       
            if(layer2.getTranslateX()!=-530){
                int a =p.getCurrentPageIndex()   ;
                 r = (int) (3+Math.pow(4,a)) ; 
                if(r==4){
                r-- ; }
                 if(NewClass.g[r]==null){
                     
                 }else{
                     id.setText(NewClass.g[r].getId());
                     System.out.print( r+" " +  NewClass.g[r]) ;
                if(NewClass.g[r].isEtat() == 1)
                    jj.setText("Demand Accepted");
                else if (NewClass.g[r].isEtat() == -1)
                    jj.setText("Demand On Hold");
                else
                    jj.setText("Demand Rejected");
                
                ue.setText(NewClass.g[r].getNom());
                entrepriseS.setText(NewClass.g[r].getEntreprise());
                visitor.setText(NewClass.g[r].getPrenom());
                cnieS.setText(NewClass.g[r].getCnie());
              String date[] = format1.format(NewClass.g[r].getDateB()).split("/");
                   String date1[] = format1.format(NewClass.g[r].getDateE()).split("/");
                 
                 yearB.setText(""+date[0]);
               mountB.setText(date[1]);
                dayB.setText(date[2]);
                
                yearS.setText(date1[0]);
               monthS.setText(date1[1]);
               dayS.setText(date1[2]);
                
                 
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
        openNav.setToX(-530);
      
        TranslateTransition closeNav=new TranslateTransition(new Duration(750), layer2);
       
            if(layer2.getTranslateX()!=-530){
               int a =p.getCurrentPageIndex()  ;
                 r = (int) (4+Math.pow(4,a)) ; 
                if(r==5){
                r-- ; }
                 if(NewClass.g[r]==null){
                     
                 }else{
                     id.setText(NewClass.g[r].getId());
                if(NewClass.g[r].isEtat() == 1)
                    jj.setText("Demand Accepted");
                else if (NewClass.g[r].isEtat() == -1)
                    jj.setText("Demand On Hold");
                else
                    jj.setText("Demand Rejected");
                
                ue.setText(NewClass.g[r].getNom());
                entrepriseS.setText(NewClass.g[r].getEntreprise());
                visitor.setText(NewClass.g[r].getPrenom());
                cnieS.setText(NewClass.g[r].getCnie());
          String date[] = format1.format(NewClass.g[r].getDateB()).split("/");
                   String date1[] = format1.format(NewClass.g[r].getDateE()).split("/");
                 
                 yearB.setText(""+date[0]);
               mountB.setText(date[1]);
                dayB.setText(date[2]);
                
                yearS.setText(date1[0]);
               monthS.setText(date1[1]);
               dayS.setText(date1[2]);
                 
                 
                openNav.play();
                 }
       
             
            }else{
             
           
                closeNav.setToX(270);
                closeNav.play();
        
            }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    @FXML 
    private void go(){
          
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
                                                       NewClass.index=0 ; 
c=0; 
                return page;
            }
        });
    
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
                                                      NewClass.index=0 ; 
c=0; 
                return page;
            }
        });
    }
    
}
