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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author jawhar
 */
public class HRViewLeaveRequestScene2_g3Controller implements Initializable {

    @FXML
    private TextArea messageBodyTextArea;
    @FXML
    private TextField summaryTextField;

    private String name;
    private String summary;
    private String body;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 
    
    public void initData(String name, String summary, String body) 
   {
       summaryTextField.setVisible(true);
       messageBodyTextArea.setVisible(true);
       this.name = name;
        this.summary = summary;
        this.body = body;
       summaryTextField.setText(summary);
       messageBodyTextArea.setText(body);
       
              
   }

    @FXML
    private void rejectButtonOnAction(ActionEvent event) 
    {
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        String str = "";
        str = str + name + "," + summary + "," + body + " (Rejected)"+"\n";
        
        File f = null;
        FileWriter fw = null;
        try {
            f = new File("humResouEmpLeaveRequestApprovalStatus.txt");
            if(f.exists()){
                fw = new FileWriter(f,true);
            }
            else{
                fw = new FileWriter(f);
            }
           
            
            a.setTitle("Approval");
            a.setHeaderText("Rejected");
            a.setContentText("Approval has been rejected");
            a.showAndWait();
            
            fw.write(str);
  
        } catch (IOException ex) {
            System.out.println(ex);
        } finally {
            try {
                if(fw != null){
                    fw.close();
                }
            } catch (IOException ex) {
                System.out.println(ex);
            }
        }
    }

    @FXML
    private void backButtonOnAction(ActionEvent event) throws IOException {
        
         Parent scene2Parent = FXMLLoader.load(getClass().getResource("hRValidateLeaveRequestScene1_g3.fxml"));
         Scene scene2 = new Scene(scene2Parent);
         Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
         window.setScene(scene2);
         window.show();
         
         
    }

    @FXML
    private void approveButtonOnAction(ActionEvent event) 
    {
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        String str = "";
        str +=  name + "," + summary + "," + body + " (Approved)"+"\n";
        System.out.println(name);
        
        File f = null;
        FileWriter fw = null;
        try {
            f = new File("humResouEmpLeaveRequestApprovalStatus.txt");
            if(f.exists()){
                fw = new FileWriter(f,true);
            }
            else{
                fw = new FileWriter(f);
            }
           
            
            a.setTitle("Approval");
            a.setHeaderText("Accepted");
            a.setContentText("Approval has been accepted");
            a.showAndWait();
            
            fw.write(str);
  
        } catch (IOException ex) {
            System.out.println(ex);
        } finally {
            try {
                if(fw != null){
                    fw.close();
                }
            } catch (IOException ex) {
                System.out.println(ex);
            }
        }
    }
    
}
