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
import model.EmployeePayment;
import model.FinanceDepartment;

/**
 * FXML Controller class
 *
 * @author jawhar
 */
public class FinanceDepartmentPaymentsDueController implements Initializable {

    @FXML
    private TableView<EmployeePayment> paymentTableView;
    @FXML
    private TableColumn<EmployeePayment, String> employeeNameTableColumn;
    @FXML
    private TableColumn<EmployeePayment, String> paymentStatusTableColumn;
    @FXML
    private TextField employeeNameTextField;
    @FXML
    private TextField paymentStatusTextField;

    private String empName, paymentStatus;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         //initialize table

        //set up the columns in the table
        employeeNameTableColumn.setCellValueFactory(new PropertyValueFactory<EmployeePayment, String>("employeeName"));
        paymentStatusTableColumn.setCellValueFactory(new PropertyValueFactory<EmployeePayment, String>("paymentStatus"));
        
        //load  data from text file
        paymentTableView.setItems(getDuePayment());
    }   
    
    private ObservableList<EmployeePayment> getDuePayment() {
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        ObservableList<EmployeePayment> duePaymentList = FXCollections.observableArrayList();

        //duePayment
           File f = null;
        //FileReader fw = null;
        Scanner sc=null; String str; String[] tokens;
        try {
            f = new File("fcDuePayment.txt");
            sc = new Scanner(f);
            if(f.exists()){
              
                while(sc.hasNextLine()){
                    str=sc.nextLine();
                    tokens = str.split(",");
                     
                    duePaymentList.add(new EmployeePayment(tokens[0],tokens[1]));
                    
                }
            }
          
        } 
        catch (Exception ex) {
          //  Logger.getLogger(MainFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        } 
        finally {
        }
        
        
        
        
        
        return duePaymentList;
    }

    @FXML
    private void backButtonOnAction(ActionEvent event) throws IOException {
        
         Parent scene2Parent = FXMLLoader.load(getClass().getResource("financeDepartmentHomeScene.fxml"));
         Scene scene2 = new Scene(scene2Parent);
         Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
         window.setScene(scene2);
         window.show();
         
         
    }

    @FXML
    private void saveButtonOnAction(ActionEvent event) throws IOException {
        empName = employeeNameTextField.getText();
        paymentStatus = paymentStatusTextField.getText();
        
        FinanceDepartment f = new FinanceDepartment();
        f.paymentsDue(paymentTableView, empName, paymentStatus);
        
    }

 
    
}
