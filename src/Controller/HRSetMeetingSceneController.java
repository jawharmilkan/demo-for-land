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
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.ExecutiveCommittee;

/**
 * FXML Controller class
 *
 * @author jawhar
 */
public class HRSetMeetingSceneController implements Initializable {

    @FXML
    private DatePicker meetingDateDatePicker;
    @FXML
    private TextField meetingTimeTextField;
    @FXML
    private TextField meetingLocationTextField;
    @FXML
    private ComboBox meetingTypeComboBox;
    @FXML
    private TextField meetingLinkTextField;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        meetingTypeComboBox.getItems().addAll("Offline Meeting", "Online Meeting");

        meetingTypeComboBox.setValue("Offline Meeting");
    }    

    @FXML
    private void backButtonOnAction(ActionEvent event) throws IOException 
    {
          Parent scene2Parent = FXMLLoader.load(getClass().getResource("hRHomeScene.fxml"));
         Scene scene2 = new Scene(scene2Parent);
         Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
         window.setScene(scene2);
         window.show();
    }

    @FXML
    private void saveButtonOnAction(ActionEvent event) 
    {
        
        
        String meetingDate, meetingType, meetingTime, meetingLocation, meetingLink, meetingSetBy;
        meetingDate = meetingDateDatePicker.getValue().toString();
        meetingType = meetingTypeComboBox.getValue().toString();
        meetingTime = meetingTimeTextField.getText();
        meetingLocation = meetingLocationTextField.getText();
        meetingLink = meetingLinkTextField.getText();
        meetingSetBy = "H.R";
        
        ExecutiveCommittee e = new ExecutiveCommittee();
        e.setUpMeeting(meetingDate, meetingType, meetingTime, meetingLocation, meetingLink, meetingSetBy);
        
    }
    
}
