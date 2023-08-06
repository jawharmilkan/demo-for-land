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
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Complain;
import model.Owner;

/**
 * FXML Controller class
 *
 * @author jawhar
 */
public class LandOwnerComplainScene_g3Controller implements Initializable {

    @FXML
    private TableView<Owner> complaintsTableView;
    @FXML
    private TableColumn<Owner, String> idTableColumn;
    @FXML
    private TableColumn<Owner, String> nameTableColumn;
    @FXML
    private TextArea complainTextBox;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //initialize table

        //set up the columns in the table
        idTableColumn.setCellValueFactory(new PropertyValueFactory<Owner, String>("id"));
        nameTableColumn.setCellValueFactory(new PropertyValueFactory<Owner, String>("name"));

        //load  data from text file
        complaintsTableView.setItems(getComplaints());
    }    

    @FXML
    private void sendButtonOnAction(ActionEvent event) throws IOException 
    {
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        
        File f =  null;
        
        FileWriter  fw = null;
        
        
        //unchecked exception
        
        try
        {
            f = new File("execComEmpGmComplaints.txt");
        
        if(f.exists())
        {
            fw = new FileWriter(f,true); //APPEND MODE
        }
        else
        {
            fw = new FileWriter(f); //file creating
        }
        
        //file created
        
        
         Owner m =  complaintsTableView.getSelectionModel().getSelectedItem();
        
       
        String str = m.getName() + "," + complainTextBox.getText()+ "\n";
        fw.write(str); 

        a.setTitle("Complaint");
        a.setHeaderText("Send successfull");
        a.setContentText("Complaint has been filed successfully");
        a.showAndWait();
       
        
        
        }
        catch(IOException e)
        {
            System.out.println("Exception : "+e);
            
        }
        finally
        {
            fw.close();
        }
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
    
    private ObservableList<Owner> getComplaints() {
        ObservableList<Owner> memberList = FXCollections.observableArrayList();

        File f = null;

        Scanner sc = null;
        String str;
        String[] tokens;
        try {
            f = new File("empGmInfo.txt");
            sc = new Scanner(f);
            if (f.exists()) {

                while (sc.hasNextLine()) {
                    str = sc.nextLine();
                    tokens = str.split(",");

                    memberList.add(new Owner(tokens[0], tokens[1]));
                }
            }
        } catch (IOException ex) {
            System.out.println(ex);
        } finally {
            sc.close();

        }

        return memberList;
    }
}
