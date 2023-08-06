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
import model.Expense;

/**
 * FXML Controller class
 *
 * @author jawhar
 */
public class FinanceDepartmentExpenseController implements Initializable {

    @FXML
    private TableView<Expense> expenseTableView;
    @FXML
    private TableColumn<Expense, String> sectorTableColumn;
    @FXML
    private TableColumn<Expense, String> expenseTableColumn;
    @FXML
    private TableColumn<Expense, String> monthTableColumn;
    @FXML
    private TableColumn<Expense, String> yearTableColumn;
    @FXML
    private TextField yearTextField;
    @FXML
    private TextField monthTextField;
    @FXML
    private TextField expenseTextField;
    @FXML
    private TextField sectorTextField;

    private String sector, expensee, month, year;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //initialize table

        //set up the columns in the table
        sectorTableColumn.setCellValueFactory(new PropertyValueFactory<Expense, String>("sector"));
        expenseTableColumn.setCellValueFactory(new PropertyValueFactory<Expense, String>("expense"));
        monthTableColumn.setCellValueFactory(new PropertyValueFactory<Expense, String>("month"));
        yearTableColumn.setCellValueFactory(new PropertyValueFactory<Expense, String>("year"));

        //load  data from text file
        expenseTableView.setItems(getExpense());
    }    

    private void viewBarChartOnAction(ActionEvent event) throws IOException 
    {
         Parent scene2Parent = FXMLLoader.load(getClass().getResource("executiveCommitteeHomeScene.fxml"));
         Scene scene2 = new Scene(scene2Parent);
         Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
         window.setScene(scene2);
         window.show();
    }

    private ObservableList<Expense> getExpense(ObservableList<Expense> expeseList) {
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        ObservableList<Expense> expenseList = FXCollections.observableArrayList();
       
        //expense
        
         File f = null;
        //FileReader fw = null;
        Scanner sc=null; String str; String[] tokens;
        try {
            f = new File("fcExpense.txt");
            sc = new Scanner(f);
            if(f.exists()){
          
                while(sc.hasNextLine()){
                    str=sc.nextLine();
                    tokens = str.split(",");
                   
                    expenseList.add(new Expense(tokens[0],tokens[1],tokens[2],tokens[3]));
                    
                }
            }
           
        } 
        catch (Exception ex) {
            //Logger.getLogger(MainFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        } 
        finally {
        }        
        
        
        

        return expeseList;
    }

    @FXML
    private void backButtonOnAction(ActionEvent event) throws IOException 
    {
         Parent scene2Parent = FXMLLoader.load(getClass().getResource("financeDepartmentHomeScene.fxml"));
         Scene scene2 = new Scene(scene2Parent);
         Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
         window.setScene(scene2);
         window.show();
    }

    @FXML
    private void viewLineChartButtonOnAction(ActionEvent event) throws IOException 
    {
         Parent scene2Parent = FXMLLoader.load(getClass().getResource("financeDepartmentExpenseLineChart.fxml"));
         Scene scene2 = new Scene(scene2Parent);
         Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
         window.setScene(scene2);
         window.show();
    }

    @FXML
    private void saveButtonOnAction(ActionEvent event, String expense) throws IOException {
        sector = sectorTextField.getText();
        expense = expenseTextField.getText();
        month = monthTextField.getText();
        year = yearTextField.getText();
        
        expenseTableView.getItems().add(new Expense(sector,expense,month,year));
        
        
        
        File f =  null;
        
        FileWriter  fw = null;
        
        //unchecked exception
        
        
        try
        {
            f = new File("expense.txt");
        
        if(f.exists())
        {
            fw = new FileWriter(f,true); //APPEND MODE
        }
        else
        {
            fw = new FileWriter(f); //file creating
        }
        
        //file created
        
        String str = sector+","+expense+","+month+","+year+"\n";
        
       
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

    private ObservableList<Expense> getExpense() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
