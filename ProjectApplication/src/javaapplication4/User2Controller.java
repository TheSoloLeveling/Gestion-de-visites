/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication4;

import Utils.Crud;
import Utils.Demande;
import Utils.EmailValidation;
import Utils.MailUtil;
import com.jfoenix.controls.JFXTextArea;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.layout.AnchorPane;
import java.sql.Date;
import javafx.scene.paint.Color;
/**
 * FXML Controller class
 *
 * @author hp
 */
public class User2Controller implements Initializable {

    
    @FXML
   private Label dB;
    @FXML
   private Label dE;
    @FXML
   private Label t; 
    @FXML
   private AnchorPane layer1 ;
    @FXML
   private JFXTextArea driverName;
    @FXML
   private JFXTextArea cnie;
    @FXML
     private JFXTextArea ue;
    @FXML
     private JFXTextArea driverSecond;
    @FXML
     private JFXTextArea email;
    @FXML
     private JFXTextArea company;
    @FXML
     private Spinner numberP;
    
    @FXML
     private Button finish;
    @FXML
     private Label fNameError;
    @FXML
     private Label sNameError;
    @FXML
     private Label cnieError;
    @FXML
     private Label emailError;
    @FXML
     private Label ueError;
       @FXML
     private Label companyError;
    
    /**
     * Initializes the controller class.
     */
    
    public void getInfos(Date begingD, Date beingE, String time){
        
        dB.setText(begingD.toString());
        dE.setText(beingE.toString());
        t.setText(time);
        
 
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        finish.setOnAction(a);
        
        
        SpinnerValueFactory<Integer> valueFactory = //
                new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 4, 1);
         
        numberP.setValueFactory(valueFactory);
       
    }    
    
    private EventHandler<ActionEvent> a = new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent e){
                int j1 = 0;
                int j2 = 0;
            String en = company.getText(); 
            String nom = driverName.getText();
            String prenom = driverSecond.getText();
            String userE = ue.getText();
            String cn = cnie.getText();
            String em = email.getText();
            
            int p = Integer.parseInt(numberP.getValue().toString());
           
            Date dateB = Date.valueOf(dB.getText());

            Date dateE = Date.valueOf(dE.getText());
            
            //Exceptions
            
            for(int i = 0; i < Crud.getSites().size(); i++){
                if(Crud.getSites().get(i).getEnreptrise().equals(en)){
                    j1 = 1;
                    break;
                }
            }
            
            if(en.trim().isEmpty()){
                en = null;
                companyError.setTextFill(Color.TOMATO);
                companyError.setText("fill in the field");
            }
            else{
                companyError.setTextFill(Color.GREEN);
                companyError.setText("Checked");
                if(j1 == 0){
                    en = null;
                    companyError.setTextFill(Color.TOMATO);
                    companyError.setText("Unavailable company user");
                }   
            }
            if(nom.trim().isEmpty()){
                nom = null;
                fNameError.setTextFill(Color.TOMATO);
                fNameError.setText("fill in the field");
            }
            else{
                fNameError.setTextFill(Color.GREEN);
                fNameError.setText("Checked");
            }
            if(prenom.trim().isEmpty()){
                prenom = null;
                sNameError.setTextFill(Color.TOMATO);
                sNameError.setText("fill in the field");
            }
            else{
                sNameError.setTextFill(Color.GREEN);
                sNameError.setText("Checked");
            }
            
            String pattern = "^[A-Z]{2}[0-9]{6}$";
            if(cn.trim().isEmpty()){
                cn = null;
                cnieError.setTextFill(Color.TOMATO);
                cnieError.setText("fill in the field");
            }
            else{
                cnieError.setTextFill(Color.GREEN);
                cnieError.setText("Checked");
                if (!cn.matches(pattern)){
                    cn = null;
                    cnieError.setTextFill(Color.TOMATO);
                    cnieError.setText("CNIE invalid(ex: AS123456)");
                } 
            }       
            
            if(em.trim().isEmpty()){
                em = null;
                emailError.setTextFill(Color.TOMATO);
                emailError.setText("fill in the field");
            }
            else{
                emailError.setTextFill(Color.GREEN);
                emailError.setText("Checked");
                if(!EmailValidation.isValidEmail(em)){
                    em = null;
                    emailError.setTextFill(Color.TOMATO);
                    emailError.setText("Invalid email (ex: exemple@site.com)");
                }
            }
            
            for(int i = 0; i < Crud.getUsers("userentreprise").size(); i++){
                String user = Crud.getUsers("userentreprise").get(i).getNom()
                        + " " + Crud.getUsers("userentreprise").get(i).getPrenom();
                if( user.equals(userE)){
                    j2 = 1;
                    break;
                }
            }
            
            if(userE.trim().isEmpty()){
                userE = null;
                ueError.setTextFill(Color.TOMATO);
                ueError.setText("fill in the field");
            }
            else{
                ueError.setTextFill(Color.GREEN);
                ueError.setText("Checked");
                if(j2 == 0){
                    userE = null;
                    ueError.setTextFill(Color.TOMATO);
                    ueError.setText("Unavailable company user");
                }  
            }
            
            if(nom != null && prenom != null && userE != null && cn != null && em != null && en != null){
                
                Demande d = new Demande(nom, prenom, cn, dateB, dateE, t.getText(), userE, en, false);
                Crud.addDemand(d);
                System.out.println("DEMAND CREATED");
                try {
                    /*for(int i = 0; i < Crud.getUsers("guerite").size(); i++){
                        MailUtil.customMessage = MailUtil.ueMessage(d);
                        MailUtil.sendMail(Crud.getUsers("guerite").get(i).getEmail());
                        MailUtil.sendMail(Crud.getUsers("responsableSite").get(i).getEmail());
                    }
                    */
                } catch (Exception ex) {
                    Logger.getLogger(User2Controller.class.getName()).log(Level.SEVERE, null, ex);
                }
                           
            
                Parent root=null;
                    try {
                        root = FXMLLoader.load(getClass().getResource("utilisateur.fxml"));

                    } catch (IOException ex) {
                       ex.printStackTrace();
                    }

                    layer1.getChildren().clear();
                    layer1.getChildren().add(root);
            }
        }
                
            
        };
    
   
     @FXML
    private void finish() {
        
    
    }
}
