package javaapplication4;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author JISOO
 */
public class Mainn extends Application {
    
    /**
     *
     * @param stage
     * @throws Exception
     */
    @Override
    public void start(Stage stage) throws Exception {
    
        
        Parent root = FXMLLoader.load (getClass().getResource("FXML4.fxml"));
        Scene scene = new Scene(root);
        stage.initStyle(StageStyle.TRANSPARENT);
        
        stage.setScene(scene);
        
        stage.show();

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
