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
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import model.LegalAdvisor;

/**
 * FXML Controller class
 *
 * @author jawhar
 */
public class LegalAdvisorSetEmergencyMeetingController implements Initializable {

    @FXML
    private TextField meetingDateTextField;
    @FXML
    private TextField meetingTimeTextField;
    @FXML
    private RadioButton onlineMeetingRadioButton;
    @FXML
    private RadioButton offlineMeetingRadioButton;
    @FXML
    private TextField meetingLinkTextField;
    @FXML
    private TextField meetingLocationTextField;
    @FXML
    private ToggleGroup tg;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ToggleGroup tg = new ToggleGroup();
        onlineMeetingRadioButton.setToggleGroup(tg);
        offlineMeetingRadioButton.setToggleGroup(tg);
    }    

    @FXML
    private void saveButtonOnAction(ActionEvent event) throws IOException {
        String meetingDate, meetingType = null, meetingTime, meetingLocation, meetingLink, meetingSetBy;
        meetingDate = meetingDateTextField.getText();
        meetingTime = meetingTimeTextField.getText();
        meetingLocation = meetingLocationTextField.getText();
        meetingLink = meetingLinkTextField.getText();
        meetingSetBy = "Legal Advisor";
        
        LegalAdvisor h = new LegalAdvisor();
        if(onlineMeetingRadioButton.isSelected())
        {
            meetingType = "Online Meeting";
            h.setEmergencyMeeting(meetingDate, meetingType, meetingTime, meetingLocation, meetingLink, meetingSetBy);
        }
        else
        {
            meetingType = "Offline Meeting";
            h.setEmergencyMeeting(meetingDate, meetingType, meetingTime, meetingLocation, meetingLink, meetingSetBy);
        }
        
    }

    @FXML
    private void backButtonOnAction(ActionEvent event) throws IOException 
    {
          Parent scene2Parent = FXMLLoader.load(getClass().getResource("legalAdvisorHomeScene.fxml"));
         Scene scene2 = new Scene(scene2Parent);
         Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
         window.setScene(scene2);
         window.show();
    }
    
}
