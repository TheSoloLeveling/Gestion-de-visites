package javaapplication4;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Utils.Crud;
import Utils.Demande;
import Utils.DemandeRef;
import Utils.SingletonConnection;
import com.jfoenix.controls.JFXComboBox;
import java.sql.Statement;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.ResourceBundle;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author hp
 */

public class NewClass implements Initializable {

    
    static DemandeRef[] g= new DemandeRef[1000] ; 
    
    @FXML
    private Label id;
     @FXML
    private Label jj;
    @FXML
    private Label nom;
    @FXML
    private Label prenom;
    @FXML
    private Label cnie;
    @FXML
    private Label year;
    @FXML
    private Label month;
    @FXML
    private Label day;
    @FXML
    private Label time;
    @FXML
    private Label entreprise;
    @FXML
    private Label dayM;
    @FXML
    private Label monthM;
    @FXML
    private Label yearM;
    @FXML
    private Label site;
    
    

    public static int index = 0;
    
   
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
         
        
        id.setText(Crud.getDemands().get(index).getId());
        entreprise.setText(Crud.getDemands().get(index).getEntreprise());
        
        DateFormat format1 = new SimpleDateFormat("yyyy/MM/dd");
        DateFormat format2 = new SimpleDateFormat("HH:mm:ss");
        
        
        String date[] = format1.format(Crud.getDemands().get(index).getDate()).split("/");
        String time1 = String.valueOf(Crud.getDemands().get(index).getTime());
        time.setText(time1);
        year.setText(date[0]);
        month.setText(date[1]);
        day.setText(date[2]);
        jj.setText(Crud.getDemands().get(index).getEtat() );
        nom.setText(Crud.getDemands().get(index).getNom());
        prenom.setText(Crud.getDemands().get(index).getPrenom());
        site.setText(searchSite(Crud.getDemands().get(index).getEntreprise()));
       
       // g[HadaController.c].setCnie(Crud.getDemands().get(index).getCnie() );
        //g[HadaController.c].setDate(Crud.getDemands().get(index).getDate());
        //g[HadaController.c].setEntreprise(Crud.getDemands().get(index).getEntreprise());
        // g[HadaController.c].setId(Crud.getDemands().get(index).getId());
         g[HadaController.c] = new DemandeRef() ; 
         g[HadaController.c].cnie = Crud.getDemands().get(index).getCnie() ;
            g[HadaController.c].entreprise = entreprise.getText() ;
             g[HadaController.c].id = id.getText() ;
                g[HadaController.c].nom = nom.getText() ;
                  g[HadaController.c].prenom = prenom.getText() ;
                    g[HadaController.c].etat = Crud.getDemands().get(index).getEtat() ;
       System.out.println(Arrays.toString(NewClass.g   ));

          // g[HadaController.c].setTime(Crud.getDemands().get(index).getTime());
                  HadaController.c+=1 ;
                   index++;
        //DateFormat format = Crud.getDemands().get(index).getDate();

    }   
    
    public void getActualDate(){
        
        DateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Calendar calendar = Calendar.getInstance();
        
        String[] t1 = format.format(calendar.getTime()).split(" ");
        String[] date = t1[0].split("/");
        String[] time = t1[0].split(":");
        yearM.setText(date[0]);
        monthM.setText(date[1]);
        dayM.setText(date[2]);
    }
    
    public String searchSite(String entreprise){
        Connection conn = null;
        Statement ps = null;
        ResultSet rs = null;
        
        
       try{
            String sql = "SELECT * FROM site where entreprise ='"+ entreprise +"'";
            conn = SingletonConnection.getconn();
            ps = conn.createStatement();
            
            rs = ps.executeQuery(sql);
            
            while (rs.next()){
                return rs.getString("nom");
            }
                                            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return "null";
    }
         @FXML
  private void Slidemenu() {
 
 
      
    }
  
  
}
      