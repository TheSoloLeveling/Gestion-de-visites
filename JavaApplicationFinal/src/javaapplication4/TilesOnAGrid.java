package javaapplication4;

import java.io.IOException;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Pagination;
import javafx.scene.control.Spinner;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Callback;


 


public class TilesOnAGrid extends Application {

    Pagination pagination = new Pagination();

    Spinner<Integer> totalSpinner = new Spinner<Integer>(0, 30, 12);
    Spinner<Integer> rowSpinner = new Spinner<Integer>(1, 5, 2);
    Spinner<Integer> colSpinner = new Spinner<Integer>(1, 5, 2);
    private Node[] nodes;

    @Override
    public void start(Stage primaryStage) throws Exception {
refreshNodes() ;
        BorderPane root = new BorderPane();

        pagination.setPageFactory(new Callback<Integer, Node>() {
            @Override
            public Node call(Integer index) {

                StackPane page = new StackPane();

                GridPane grid = new GridPane();

                grid.setHgap(10);
                grid.setVgap(10);
                grid.setPadding(new Insets(0, 10, 0, 10));

                int total = totalSpinner.getValue();
                int rows = rowSpinner.getValue();
                int cols = colSpinner.getValue();

                int offset = rows * cols * index;

                for (int row = 0; row < rows; row++) {
                    for (int col = 0; col < cols; col++) {

                        offset++;

                        if (offset > total)
                            break;

                        StackPane container = new StackPane();
                        container.setStyle("-fx-background-color:lightgrey");

                        

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

        totalSpinner.valueProperty().addListener((ChangeListener<Number>) (observable, oldValue, newValue) -> layoutItems());
        rowSpinner.valueProperty().addListener((ChangeListener<Number>) (observable, oldValue, newValue) -> layoutItems());
        colSpinner.valueProperty().addListener((ChangeListener<Number>) (observable, oldValue, newValue) -> layoutItems());

        HBox toolbar = new HBox();
        toolbar.setPadding(new Insets(5,5,5,5));
        toolbar.setSpacing(5);
        toolbar.getChildren().addAll(new Label("Total"), totalSpinner, new Label("Columns"), colSpinner, new Label("Rows"), rowSpinner);

        root.setTop(toolbar);
        root.setCenter(pagination);

        Scene scene = new Scene(root, 800, 600);

        primaryStage.setScene(scene);
        primaryStage.show();

        layoutItems();

    }

    private void layoutItems() {

        int total = totalSpinner.getValue();
        int rows = rowSpinner.getValue();
        int cols = colSpinner.getValue();

        int pages = (int) Math.ceil(total / (double) (rows * cols));

        pagination.setPageCount(pages);
    }

    public static void main(String[] args) {
        launch(args);
    }
     private void refreshNodes()
    {
       // pnl_scroll.getChildren().clear();
        
        nodes = new  Node[15];
        
        for(int i = 0; i<10; i++)
        {
            try {
                nodes[i] = (Node)FXMLLoader.load(getClass().getResource("Item.fxml"));
             
            //   pnl_scroll.getChildren().add(nodes[i]);
                
            } catch (IOException ex) {
              
            }
           
        }
    }  
}