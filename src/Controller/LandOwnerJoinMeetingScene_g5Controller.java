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
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.LandOwner;

/**
 * FXML Controller class
 *
 * @author jawhar
 */
public class LandOwnerJoinMeetingScene_g5Controller implements Initializable {

    @FXML
    private TextField meetingDateTextField;
    @FXML
    private TextField meetingTimeTextField;
    @FXML
    private TextField meetingLocationTextField;
    @FXML
    private TextField meetingTypeTextField;
    @FXML
    private TextField meetingLinkTextField;
    @FXML
    private TextField setByTextField;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        LandOwner g = new LandOwner();
        g.participateMeeting(meetingDateTextField, meetingTypeTextField, meetingTimeTextField, meetingLocationTextField, meetingLinkTextField, setByTextField);
        
        
    }    

    @FXML
    private void backButtonOnClick(ActionEvent event) throws IOException 
    {
         Parent scene2Parent = FXMLLoader.load(getClass().getResource("landOwnerHomeScene.fxml"));
         Scene scene2 = new Scene(scene2Parent);
         Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
         window.setScene(scene2);
         window.show();
    }
    
}
