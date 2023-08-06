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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.LeaveRequest;

/**
 * FXML Controller class
 *
 * @author jawhar
 */
public class HRValidateLeaveRequestScene1_g3Controller implements Initializable {

    @FXML
    private TableView<LeaveRequest> leaveRequestTableView;
    @FXML
    private TableColumn<LeaveRequest, String> nameColumn;
    @FXML
    private TableColumn<LeaveRequest, String> summaryColumn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //initialize table

        //set up the columns in the table
        nameColumn.setCellValueFactory(new PropertyValueFactory<LeaveRequest, String>("name"));
        summaryColumn.setCellValueFactory(new PropertyValueFactory<LeaveRequest, String>("summary"));

        //load  data from text file
        leaveRequestTableView.setItems(getRequests());
    }

    private ObservableList<LeaveRequest> getRequests() {
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        ObservableList<LeaveRequest> leaveRequestList = FXCollections.observableArrayList();

        File f = null;

        Scanner sc = null;
        String str;
        String[] tokens;
        try {
            f = new File("humResEmpLeaveRequests.txt");
            sc = new Scanner(f);
            if (f.exists()) {

                while (sc.hasNextLine()) {
                    str = sc.nextLine();
                    tokens = str.split(",");

                    leaveRequestList.add(new LeaveRequest(tokens[0], tokens[1], tokens[2]));
                }
            }
        } catch (IOException ex) {
            System.out.println(ex);
        } finally {
            sc.close();

        }

        return leaveRequestList;

    }

    @FXML
    private void viewLeaveRequestButtonOnAction(ActionEvent event) throws IOException 
    {
            LeaveRequest lr = leaveRequestTableView.getSelectionModel().getSelectedItem();
        
        
       String name = lr.getName();
       String summary = lr.getSummary();
       String body = lr.getBody();

       
        System.out.println(body);
        
        
        //data passing between 2 scene
        
         FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("hRViewLeaveRequestScene2_g3.fxml"));
        Parent personViewParent = loader.load();
        
        //Parent personViewParent = FXMLLoader.load(getClass().getResource("FXMLScene2.fxml"));
        Scene personViewScene = new Scene(personViewParent);
        
        //access the controller
        HRViewLeaveRequestScene2_g3Controller controller = loader.getController();
        controller.initData(name, summary, body);
        
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(personViewScene);
        window.show();
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

}
