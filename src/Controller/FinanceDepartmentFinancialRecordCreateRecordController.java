/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Record;

/**
 * FXML Controller class
 *
 * @author jawhar
 */
public class FinanceDepartmentFinancialRecordCreateRecordController implements Initializable {

    @FXML
    private TableView<Record> recordTableView;
    @FXML
    private TableColumn<Record, String> dateTableView;
    @FXML
    private TableColumn<Record, String> descriptionTableView;
    @FXML
    private TableColumn<Record, String> expensesTableView;
    @FXML
    private TextField dateTextField;
    @FXML
    private TextField descriptionTextField;
    @FXML
    private TextField expensesTextField;

    private String date, description, expenses;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         //initialize table

        //set up the columns in the table
        dateTableView.setCellValueFactory(new PropertyValueFactory<Record, String>("date"));
        descriptionTableView.setCellValueFactory(new PropertyValueFactory<Record, String>("description"));
        expensesTableView.setCellValueFactory(new PropertyValueFactory<Record, String>("expenses"));

        //load  data from text file
        recordTableView.setItems(getRecord());
    }    

    @FXML
    private void backButtonOnAction(ActionEvent event) throws IOException {
        
         Parent scene2Parent = FXMLLoader.load(getClass().getResource("financeDepartmentFinancialRecord.fxml"));
         Scene scene2 = new Scene(scene2Parent);
         Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
         window.setScene(scene2);
         window.show();
         
         
    }

    @FXML
    private void saveButtonOnAction(ActionEvent event) throws IOException {
       
  
        
        
        
        date = dateTextField.getText();
        description = descriptionTextField.getText();
        expenses = expensesTextField.getText();
        
        
              
        Record record = new Record(date,
                                       description,
                                       expenses
                                    );
        recordTableView.getItems().add(record);
        
        
        
        File f =  null;
        
        FileWriter  fw = null;
        
        //unchecked exception
        
        
        try
        {
            f = new File("fcRecords.txt");
        
        if(f.exists())
        {
            fw = new FileWriter(f,true); //APPEND MODE
        }
        else
        {
            fw = new FileWriter(f); //file creating
        }
        
        //file created
        
        String str = date+","+description+","+expenses+"\n";
        
       
        fw.write(str);
        
       
        
        }
        catch(Exception e)
        {
            System.out.println("Exception : "+e);
            
        }
        finally
        {
            fw.close();
        }
        
    }

    private ObservableList<Record> getRecord() 
    {
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        ObservableList<Record> recordList = FXCollections.observableArrayList();

         File f = null;
        //FileReader fw = null;
        Scanner sc; String str; String[] tokens;
        try {
            f = new File("fcRecords.txt"); 
            sc = new Scanner(f);
            if(f.exists()){
                //outputTextArea.appendText("Content of Emp.txt:\n");
                while(sc.hasNextLine()){
                    str=sc.nextLine();
                    tokens = str.split(",");
                   
                    recordList.add(new Record(tokens[0],tokens[1],tokens[2]));
                    
                    
                }
            }
            //else 
               // outputTextArea.setText("oops! Emp.txt does not exist...");
        } 
        catch (Exception ex) {
            //Logger.getLogger(MainFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        } 
        finally {
        }        
        
        
        

        return recordList;
        
    }
    
}
