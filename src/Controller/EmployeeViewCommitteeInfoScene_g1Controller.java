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
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.CommitteeInfo;

/**
 * FXML Controller class
 *
 * @author jawhar
 */
public class EmployeeViewCommitteeInfoScene_g1Controller implements Initializable {

    @FXML
    private TableView<CommitteeInfo> committeeTableView;
    @FXML
    private TableColumn<CommitteeInfo, String> idTableColumn;
    @FXML
    private TableColumn<CommitteeInfo, String> nameTableColumn;
    @FXML
    private TableColumn<CommitteeInfo, String> phoneNumberTableColumn;
    @FXML
    private TableColumn<CommitteeInfo, String> emaliAddressTableColumn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //initialize table

        //set up the columns in the table
        idTableColumn.setCellValueFactory(new PropertyValueFactory<CommitteeInfo, String>("id"));
        nameTableColumn.setCellValueFactory(new PropertyValueFactory<CommitteeInfo, String>("name"));
        emaliAddressTableColumn.setCellValueFactory(new PropertyValueFactory<CommitteeInfo, String>("address"));
        phoneNumberTableColumn.setCellValueFactory(new PropertyValueFactory<CommitteeInfo, String>("phoneNumber"));

        //load data from binary file
        committeeTableView.setItems(getCommitteeInfo());
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

    private ObservableList<CommitteeInfo> getCommitteeInfo() {
        Alert a = new Alert(Alert.AlertType.INFORMATION);
       ObservableList<CommitteeInfo> committeeInfoList = FXCollections.observableArrayList();

        File f = null;
        FileInputStream fis = null; //ByteStream Class
        DataInputStream dis = null; //DataStream Class
        
        String str="";
        
        try
        {
            f = new File("accountCommitteeUserInfoExecComEmp.bin");
            
            if(!f.exists())
            {
                a.setTitle("Alert");
                a.setHeaderText("Issue found");
                a.setContentText("accountUserInfo.bin file doesn't exist");
                a.showAndWait();
            }
            else
            {
                fis = new FileInputStream(f);
                dis = new DataInputStream(fis);
                String[] tokens;
                
                while(true)
                {
                    
                    //id, name, emailaddress, phoneNumber
                    committeeInfoList.add(new CommitteeInfo(dis.readUTF(),dis.readUTF(), dis.readUTF(), dis.readUTF()));
                }  
            }   
        }
        catch(IOException ex)
        {
            
        }
        finally
        {
            try {
                dis.close();
            } catch (IOException ex) {
                System.out.println(ex);
            }
        }
        
        return committeeInfoList;
        
    }
    
}
