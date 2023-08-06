/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.SalaryPayment;

/**
 * FXML Controller class
 *
 * @author jawhar
 */
public class EmployeeReceiveSalaryScene1_g3Controller implements Initializable {

    @FXML
    private TableView<SalaryPayment> salaryTableView;
    @FXML
    private TableColumn<SalaryPayment, String> salaryMonthTableColumn;
    @FXML
    private TableColumn<SalaryPayment, String> salaryPaidAmountTableColumn;
    @FXML
    private TableColumn<SalaryPayment, String> salaryBonusTableColumn;
    @FXML
    private TableColumn<SalaryPayment, String> salaryTransactionMethodTableColumn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //initialize table

        //set up the columns in the table
        salaryMonthTableColumn.setCellValueFactory(new PropertyValueFactory<SalaryPayment, String>("month"));
        salaryPaidAmountTableColumn.setCellValueFactory(new PropertyValueFactory<SalaryPayment, String>("paidAmount"));
        salaryBonusTableColumn.setCellValueFactory(new PropertyValueFactory<SalaryPayment, String>("bonus"));
        salaryTransactionMethodTableColumn.setCellValueFactory(new PropertyValueFactory<SalaryPayment, String>("transactionMethod"));

        //load data from text file
        salaryTableView.setItems(getSalaryPayment());
    }    

    @FXML
    private void backButtonOnAction(ActionEvent event) throws IOException 
    {
         Parent scene2Parent = FXMLLoader.load(getClass().getResource("employeeHomeScene.fxml"));
         Scene scene2 = new Scene(scene2Parent);
         Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
         window.setScene(scene2);
         window.show();
    }

    @FXML
    private void transferMoneyButtonOnAction(ActionEvent event) throws IOException 
    {
        Parent scene2Parent = FXMLLoader.load(getClass().getResource("employeeTransferMoneyScene2_g3.fxml"));
         Scene scene2 = new Scene(scene2Parent);
         Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
         window.setScene(scene2);
         window.show();
    }

    private ObservableList<SalaryPayment> getSalaryPayment() {
        ObservableList<SalaryPayment> salaryPaymentList = FXCollections.observableArrayList();

        File f = null;
        FileInputStream fis = null; //ByteStream Class
        DataInputStream dis = null; //DataStream Class
        
        String str="";
        
        try
        {
            f = new File("empMoneyInfo.bin");

            if(f.exists())
            {
                fis = new FileInputStream(f);
                dis = new DataInputStream(fis);
                
                while(true)
                {    
                    //month, amount, bonus, transactionMethod
                    salaryPaymentList.add(new SalaryPayment(dis.readUTF(), Float.toString(dis.readFloat()), Float.toString(dis.readFloat()), dis.readUTF()));
                } 
            }
               
            
        }
        catch(IOException ex)
        {
            System.out.println(ex);
        }
        finally
        {
            try {
                dis.close();
            } catch (IOException ex) 
            {
                System.out.println(ex);   
            }
        }
        
        

        return salaryPaymentList;

    }
    
}
