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
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import model.FinanceDepartment;

/**
 * FXML Controller class
 *
 * @author jawhar
 */
public class FinanceDepartmentFeesCollectionController implements Initializable {

    @FXML
    private TextArea feesDetailsTextArea;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
    private void sendButtonOnAction(ActionEvent event) throws IOException {
        FinanceDepartment f = new FinanceDepartment();
        String fundDetails = feesDetailsTextArea.getText();
        f.collectFunds(fundDetails);
        
    }
    
}
