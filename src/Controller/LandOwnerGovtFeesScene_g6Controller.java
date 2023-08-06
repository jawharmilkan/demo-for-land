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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Fees;
import model.LandOwner;

/**
 * FXML Controller class
 *
 * @author jawhar
 */
public class LandOwnerGovtFeesScene_g6Controller implements Initializable {

    @FXML
    private TableView<Fees> fundsTableView;
    @FXML
    private TableColumn<Fees, String> dateTableColumn;
    @FXML
    private TableColumn<Fees, String> nameTableColumn;
    @FXML
    private TableColumn<Fees, String> subjectTableColumn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //initialize table

        //set up the columns in the table
        dateTableColumn.setCellValueFactory(new PropertyValueFactory<Fees, String>("date"));
        nameTableColumn.setCellValueFactory(new PropertyValueFactory<Fees, String>("name"));
        subjectTableColumn.setCellValueFactory(new PropertyValueFactory<Fees, String>("subject"));

        //load  data from text file
        fundsTableView.setItems(getFunds());
    }    

    @FXML
    private void sendMoneyOnClick(ActionEvent event) throws IOException {
        LandOwner g = new LandOwner();
        g.provideFunds(fundsTableView);
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

    private ObservableList<Fees> getFunds() {
        ObservableList<Fees> fundList = FXCollections.observableArrayList();

        File f = null;

        Scanner sc = null;
        String str;
        String[] tokens;
        try {
            f = new File("gmFunds.txt");
            sc = new Scanner(f);
            if (f.exists()) {

                while (sc.hasNextLine()) {
                    str = sc.nextLine();
                    tokens = str.split(",");

                    fundList.add(new Fees(tokens[0], tokens[1], tokens[2]));
                }
            }
        } catch (IOException ex) {
            System.out.println(ex);
        } finally {
            sc.close();

        }

        return fundList;

    }
    
}
