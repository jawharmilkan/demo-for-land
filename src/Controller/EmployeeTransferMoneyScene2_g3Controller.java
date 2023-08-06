/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Employee;

/**
 * FXML Controller class
 *
 * @author jawhar
 */
public class EmployeeTransferMoneyScene2_g3Controller implements Initializable {

    @FXML
    private TextField amountTextField;
    @FXML
    private ComboBox monthComboBox;
    @FXML
    private ComboBox transactionMethodComboBox;
    @FXML
    private TextField bonusTextField;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        monthComboBox.getItems().addAll("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December");

        monthComboBox.setValue("January");
        
        transactionMethodComboBox.getItems().addAll("Nagad", "bkash");

        transactionMethodComboBox.setValue("Nagad");
    }    

    @FXML
    private void sendButtonOnAction(ActionEvent event) 
    {
        
        
        
        float amount = Float.parseFloat(amountTextField.getText());
        String month = monthComboBox.getValue().toString();
        String transactionMethod = transactionMethodComboBox.getValue().toString();
        float bonus = Float.parseFloat(bonusTextField.getText());
       
        Employee e = new Employee();
        e.receiveSalary(amount, month, transactionMethod, bonus);
        
        
    }

    @FXML
    private void backButtonOnAction(ActionEvent event) throws IOException {
        Parent scene2Parent = FXMLLoader.load(getClass().getResource("employeeHomeScene.fxml"));
         Scene scene2 = new Scene(scene2Parent);
         Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
         window.setScene(scene2);
         window.show();
    }
}
