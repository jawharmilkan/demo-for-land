/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.File;
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
import model.FinanceDepartment;
import model.Salary;

/**
 * FXML Controller class
 *
 * @author jawhar
 */
public class FinanceDepartmentArrangeSalarieController implements Initializable {

    @FXML
    private TableColumn<Salary, String> salaryTableColumn;
    @FXML
    private TableColumn<Salary, String> employeeNameTableColumn;
    @FXML
    private TableColumn<Salary, String> bonusAmountTableColumn;
    @FXML
    private TableView<Salary> salaryTableView;
    @FXML
    private TextField salaryTextField;
    @FXML
    private TextField bonusTextField;
    @FXML
    private TextField nameTextField;
    
    private String name; 
    private float salary, bonus;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //initialize table

        //set up the columns in the table
        employeeNameTableColumn.setCellValueFactory(new PropertyValueFactory<Salary, String>("name"));
        salaryTableColumn.setCellValueFactory(new PropertyValueFactory<Salary, String>("salary"));
        bonusAmountTableColumn.setCellValueFactory(new PropertyValueFactory<Salary, String>("bonusAmount"));

        //load  data from text file
        salaryTableView.setItems(getSalary());
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
    private void saveButtonOnAction(ActionEvent event) throws IOException {
        name = nameTextField.getText();
        salary = Float.parseFloat(salaryTextField.getText());
        bonus = Float.parseFloat(bonusTextField.getText());
        
        FinanceDepartment f  = new FinanceDepartment();
        
        f.arrangeSalary(salaryTableView,name,salary,bonus);
     
        
    }

    private ObservableList<Salary> getSalary() {
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        ObservableList<Salary> salaryList = FXCollections.observableArrayList();

        //fcSalary.txt
        
        
       
        File f = null;
        //FileReader fw = null;
        Scanner sc; String str; String[] tokens;
        try {
            f = new File("fcSalary.txt");
            sc = new Scanner(f);
            if(f.exists()){
              
                while(sc.hasNextLine()){
                    str=sc.nextLine();
                    tokens = str.split(",");
                    
                    salaryList.add(new Salary(tokens[0],Float.parseFloat(tokens[1]),Float.parseFloat(tokens[2])));
                 
                }
            }
           
        } 
        catch (IOException ex) {
            
        } 
        finally {
        }        
        
        

        return salaryList;
    }
    
}
