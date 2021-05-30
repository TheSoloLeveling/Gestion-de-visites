/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication4;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXToggleButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class DashController implements Initializable {

    @FXML
    private JFXButton bt1;
          @FXML
    private JFXButton bt2;
             @FXML
    private JFXButton bt3;
                @FXML
    private JFXButton bt4;
                      @FXML
    private JFXButton bt5;
    
    public static int c =0 ; 
    public static int cnt =0 ; 
       private static final String HOVERED_BUTTON_STYLE = "-fx-background-color:#ffff";
    private static final String HOVERED_BUTTON_STYLE2 = "-fx-background-color: #252645";
     @FXML
    private Label name;
    @FXML
    private JFXButton close;
     @FXML
    private Pane pane;
     @FXML
    private JFXButton close2;
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
    private Pane layer4;
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
    private Label item1;
    @FXML
    private Label item2;
    @FXML
    private Label item3;
    @FXML
    private Label item4;
    @FXML
    private Label item5;
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
    private BorderPane Hadi ;
       @FXML
    private ImageView im1;
          @FXML
    private ImageView im2;
        @FXML
    private ImageView im3;
        @FXML
    private ImageView im4;
        @FXML
    private ImageView im5;
    
    @FXML
    private JFXButton disconnect;
    
   private Image img1 = new Image("/icons/projects.png") ;    
   private Image img2 =new Image("/icons/reliabilty.png") ;   ;    
   private Image img3=new Image("/icons/icons8_Share_64px.png") ;    
   private Image img4=new Image("/icons/icons8_Workflow_64px.png") ;  
   private Image img5=new Image("/icons/icons8_Handshake_64px.png") ;  
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        disconnect.setOnAction(disconnectHandler);
        name.setText(MainController.actualAccount.getNom());
         load("reda") ;
        dark() ; 
        bt1.setText("");
         bt2.setText("");
          bt3.setText("");
           bt4.setText("");
          bt5.setText("");
           bt1.setDisable(true);
         bt2.setDisable(true);
          bt3.setDisable(true);
           bt4.setDisable(true);
          bt5.setDisable(true);
      
    
        TranslateTransition openPane=new TranslateTransition(new Duration(1950), layer4);
    TranslateTransition closeNav=new TranslateTransition(new Duration(1950), layer2);
  openPane.setToY(120);
     closeNav.setToX(-270);
      
              closeNav.play() ; 
              openPane.play();
          
    }    
    
       @FXML
  private void Slidemenu() {
      TranslateTransition openHadi=new TranslateTransition(new Duration(350), Hadi.getCenter());
      TranslateTransition closeHadi=new TranslateTransition(new Duration(350), Hadi.getCenter());
      TranslateTransition openMenu=new TranslateTransition(new Duration(350), menu);
      TranslateTransition closeMenu=new TranslateTransition(new Duration(350), menu);
        TranslateTransition openNav=new TranslateTransition(new Duration(350), layer2);
        openNav.setToX(0);
       openHadi.setToX(90);
        TranslateTransition closeNav=new TranslateTransition(new Duration(350), layer2);
       openMenu.setToX(0);
            if(layer2.getTranslateX()!=0){
                layer2.setStyle("-fx-background-color: linear-gradient(to left,#795AF3 ,#3929E0)");
                openNav.play();
                openHadi.play(); ;
                openMenu.play();
                 bt1.setText("Demand List");
         bt2.setText("Demand Management");
          bt3.setText("  Site Management");
           bt4.setText("Charl List");
          bt5.setText("   Quick accept");
              bt1.setDisable(false);
         bt2.setDisable(false);
          bt3.setDisable(false);
           bt4.setDisable(false);
          bt5.setDisable(false);
            }else{
                 layer2.setStyle("-fx-background-color: linear-gradient(to right,#795AF3 ,#3929E0)");
                closeMenu.setToX(0);
                closeNav.setToX(-270);
                closeHadi.setToX(0);
                closeNav.play();
                closeMenu.play();
                closeHadi.play();;
                    bt1.setText("");
         bt2.setText("");
          bt3.setText("");
           bt4.setText("");
          bt5.setText("");
             bt1.setDisable(true);
         bt2.setDisable(true);
          bt3.setDisable(true);
           bt4.setDisable(true);
          bt5.setDisable(true);
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
        
         if(MainController.c%2==0){

       layer3.setStyle(HOVERED_BUTTON_STYLE);    
      layer1.setStyle(HOVERED_BUTTON_STYLE);
      
      MainController.c++ ; 
         a2.setVisible(false);
      a1.setVisible(true);
         }
         else{
         
             MainController.c++ ; 
         a1.setVisible(false);
              a2.setVisible(true);
     
           
           layer3.setStyle(HOVERED_BUTTON_STYLE2);    
      layer1.setStyle(HOVERED_BUTTON_STYLE2);
            
         }
    }
         @FXML
    private Label lbl1;
          @FXML
    private Label lbl2;
           @FXML
    private Label lbl3;
               @FXML
    private ScrollPane sep;
    
      @FXML
    private VBox pnl_scroll;
       @FXML
    private HBox kulchi;
     
    @FXML
    private void handleButtonActionlb1(MouseEvent event) { 
    
         TranslateTransition sepT=new TranslateTransition(new Duration(350), sep);
         sepT.setToX(120);
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
     private void darkitem2() {
        
         if(MainController.c%2==0){
System.out.print(Hadi.getChildren().get(0) )  ;
      layer1.setStyle(HOVERED_BUTTON_STYLE);
      MainController.c++ ; 
     
         }
         else{
        
             MainController.c++ ; 
     
     
        
            
         }
    }
    
     
       @FXML
  private void lb1() {
      
  }
  
       @FXML
  private void lb2() {
       
  }
       @FXML
  private void lb3() {
       
  }
        @FXML
  private void lb4() {
     
  }
        @FXML
  private void lb5() {
    
  }
  
         @FXML
  private void loaditem1() {
      
    load("reda") ;
        
  } 
         @FXML
  private void loaditem2() {
         load("Hada") ;
      
        
  } 
         @FXML
  private void loaditem3() {
      
     
         load("MyMom") ;
        
  } 
           @FXML
  private void loaditem4() {
      
     
         load("dashboard") ;
        
  } 
           @FXML
  private void loaditem5() {
      
     
         load("table2") ;
        
  } 

  
        @FXML
  private void load(String item) {
      
     Parent root =null ; 
     
        try { 
            root= FXMLLoader.load(getClass().getResource(item+".fxml")) ;
        } catch (IOException ex) {
            Logger.getLogger(DashController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
           Hadi.setCenter(root);
            
         
  }
  
    @FXML
    private void close() {
        System.exit(0);
    }
    
    EventHandler<ActionEvent> disconnectHandler = 
            new EventHandler<ActionEvent>(){

        @Override
        public void handle(ActionEvent t) {
            Parent root = null ;
        try {
             root = FXMLLoader.load (getClass().getResource("FXML.fxml"));
           
            
        } catch (IOException ex) {
            Logger.getLogger(SplashScreenController.class.getName()).log(Level.SEVERE, null, ex);
        }
         Scene secene = new Scene(root) ;
         MainController.actualAccount = null;
         
            Stage stage = new Stage() ; 
            stage.setScene(secene);
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.show() ; 
            disconnect.getScene().getWindow().hide();
        }
            };
}
