/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication4;


import java.io.IOException;
import java.util.Random;
import javafx.application.Application;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.StageStyle;
import javafx.util.Duration;

public class TableController implements Initializable {
    @FXML
     private TableView tableView ;
    @FXML
     private AnchorPane layer1 ;
    @FXML
    private Button btnNew ;
    
    static Random random = new Random();
    
    static final String Day[] = {
        "Monday",
        "Tuesday",
        "Wednesday",
        "Thursday",
        "Friday"};

    public static class Record {
        private final SimpleIntegerProperty id;
        private final SimpleIntegerProperty value_0;
        private final SimpleIntegerProperty value_1;
        private final SimpleIntegerProperty value_2;
        private final SimpleIntegerProperty value_3;
        private final SimpleIntegerProperty value_4;
        
        Record(int i, int v0, int v1, int v2, int v3, 
                int v4) {
            this.id = new SimpleIntegerProperty(i);
            this.value_0 = new SimpleIntegerProperty(v0);
            this.value_1 = new SimpleIntegerProperty(v1);
            this.value_2 = new SimpleIntegerProperty(v2);
            this.value_3 = new SimpleIntegerProperty(v3);
            this.value_4 = new SimpleIntegerProperty(v4);
        }
        
        public int getId() {
            return id.get();
        }

        public void setId(int v) {
            id.set(v);
        }
        
        public int getValue_0() {
            return value_0.get();
        }

        public void setValue_0(int v) {
            value_0.set(v);
        }
        
        public int getValue_1() {
            return value_1.get();
        }

        public void setValue_1(int v) {
            value_1.set(v);
        }
        
        public int getValue_2() {
            return value_2.get();
        }

        public void setValue_2(int v) {
            value_2.set(v);
        }
        
        public int getValue_3() {
            return value_3.get();
        }

        public void setValue_3(int v) {
            value_3.set(v);
        }
        
        public int getValue_4() {
            return value_4.get();
        }

        public void setValue_4(int v) {
            value_4.set(v);
        }
        
    };
    
    ObservableList<Record> data = FXCollections.observableArrayList();
    int data_nextId = 0;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
            tableView.setEditable(true);
        Callback<TableColumn, TableCell> cellFactory =
                new Callback<TableColumn, TableCell>() {
                    
                    @Override
                    public TableCell call(TableColumn p) {
                        return new EditingCell();
                    }
                };
        
        btnNew.setOnAction(btnNewHandler);
        
        //init table
        //Un-editable column of "id"
        TableColumn col_id = new TableColumn("ID");
        tableView.getColumns().add(col_id);
        col_id.setCellValueFactory(
                    new PropertyValueFactory<Record, String>("id"));
        
        //Editable columns
        for(int i=0; i<Day.length; i++){
            TableColumn col = new TableColumn(Day[i]);
            col.setCellValueFactory(
                    new PropertyValueFactory<Record, String>(
                            "value_" + String.valueOf(i)));
            tableView.getColumns().add(col);
            col.setCellFactory(cellFactory);
        }
        
        //Insert Button
        TableColumn col_action = new TableColumn<>("Action");
        col_action.setSortable(false);
        
        col_action.setCellValueFactory(
                new Callback<TableColumn.CellDataFeatures<Record, Boolean>, 
                ObservableValue<Boolean>>() {

            @Override
            public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<Record, Boolean> p) {
                return new SimpleBooleanProperty(p.getValue() != null);
            }
        });

        col_action.setCellFactory(
                new Callback<TableColumn<Record, Boolean>, TableCell<Record, Boolean>>() {

            @Override
            public TableCell<Record, Boolean> call(TableColumn<Record, Boolean> p) {
                return new ButtonCell(tableView);
            }
        
        });
        tableView.getColumns().add(col_action);
        
        tableView.setItems(data);
        
   
    }

   private class ButtonCell extends TableCell<Record, Boolean> {
        final Button cellButton = new Button("Delete");
        
        ButtonCell(final TableView tblView){
            
            cellButton.setOnAction(new EventHandler<ActionEvent>(){

                @Override
                public void handle(ActionEvent t) {
                    int selectdIndex = getTableRow().getIndex();
                    //delete the selected item in data
                    data.remove(selectdIndex);
                }
            });
        }

        //Display button if the row is not empty
        @Override
        protected void updateItem(Boolean t, boolean empty) {
            super.updateItem(t, empty);
            if(!empty){
                setGraphic(cellButton);
            }
        }
    }
       EventHandler<ActionEvent> btnNewHandler = 
            new EventHandler<ActionEvent>(){

        @Override
        public void handle(ActionEvent t) {
            
            //generate new Record with random number
            Record newRec = new Record(
                    data_nextId,
                    1, 
                    random.nextInt(1), 
                    random.nextInt(1), 
                    random.nextInt(1), 
                    random.nextInt(1));
            data.add(newRec);
            data_nextId++;
            load() ;
        }
    };
         class EditingCell extends TableCell<XYChart.Data, Number> {
         
        private TextField textField;
         
        public EditingCell() {}
         
        @Override
        public void startEdit() {
             
            super.startEdit();
             
            if (textField == null) {
                createTextField();
            }
             
            setGraphic(textField);
            setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
            textField.selectAll();
        }
         
        @Override
        public void cancelEdit() {
            super.cancelEdit();
             
            setText(String.valueOf(getItem()));
            setContentDisplay(ContentDisplay.TEXT_ONLY);
        }
         
        @Override
        public void updateItem(Number item, boolean empty) {
            super.updateItem(item, empty);
             
            if (empty) {
                setText(null);
                setGraphic(null);
            } else {
                if (isEditing()) {
                    if (textField != null) {
                        textField.setText(getString());
                    }
                    setGraphic(textField);
                    setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
                } else {
                    setText(getString());
                    setContentDisplay(ContentDisplay.TEXT_ONLY);
                }
            }
        }
         
        private void createTextField() {
            textField = new TextField(getString());
            textField.setMinWidth(this.getWidth() - this.getGraphicTextGap()*2);
            textField.setOnKeyPressed(new EventHandler<KeyEvent>() {
                 
                @Override
                public void handle(KeyEvent t) {
                    if (t.getCode() == KeyCode.ENTER) {
                        commitEdit(Integer.parseInt(textField.getText()));
                    } else if (t.getCode() == KeyCode.ESCAPE) {
                        cancelEdit();
                    }
                }
            });
        }
         
        private String getString() {
            return getItem() == null ? "" : getItem().toString();
        }
    }
         
         @FXML
    private void load() {
    Parent root=null;
        try {
            root = FXMLLoader.load(getClass().getResource("addrec.fxml"));
        } catch (IOException ex) {
           ex.printStackTrace();
        }
      Scene secene = new Scene(root) ; 
            Stage stage = new Stage() ; 
            stage.setScene(secene);
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.show() ; 
         
  

    }
   
}