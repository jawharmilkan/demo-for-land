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
import model.Complain;

/**
 * FXML Controller class
 *
 * @author jawhar
 */
public class LegalAdvisorComplainFieldController implements Initializable {

    @FXML
    private TableView<Complain> complainTableView;
    @FXML
    private TableColumn<Complain, String> complainNameTableColumn;
    @FXML
    private TableColumn<Complain, String> complainSummaryTableColumn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //initialize table

        //set up the columns in the table
        complainNameTableColumn.setCellValueFactory(new PropertyValueFactory<Complain, String>("name"));
        complainSummaryTableColumn.setCellValueFactory(new PropertyValueFactory<Complain, String>("summary"));
        

        //load  data from text file
        complainTableView.setItems(getComplain());
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

   private ObservableList<Complain> getComplain() {
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        ObservableList<Complain> complainList = FXCollections.observableArrayList();

        File f = null;

        Scanner sc = null;
        String str;
        String[] tokens;
        try {
            f = new File("execComEmpGmComplains.txt");
            sc = new Scanner(f);
            if (f.exists()) {

                while (sc.hasNextLine()) {
                    str = sc.nextLine();
                    tokens = str.split(",");

                    complainList.add(new Complain(tokens[0], tokens[1]));
                }
            }
        } catch (IOException ex) {
            System.out.println(ex);
        } finally {
            sc.close();

        }

        return complainList;

    }



    
}
