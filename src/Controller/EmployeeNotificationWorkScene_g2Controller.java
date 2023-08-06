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
import model.Employee;
import model.OngoingWork;
import model.UpcomingWork;

/**
 * FXML Controller class
 *
 * @author jawhar
 */
public class EmployeeNotificationWorkScene_g2Controller implements Initializable {

    @FXML
    private TableView<UpcomingWork> upcomingWorksTableView;
    @FXML
    private TableColumn<UpcomingWork, String> taskUpcomingTableColumn;
    @FXML
    private TableColumn<UpcomingWork, String> dueDateUpcomingTableColumn;
    @FXML
    private TableView<OngoingWork> ongoingWorksTableView;
    @FXML
    private TableColumn<OngoingWork, String> taskOngoingTableColumn;
    @FXML
    private TableColumn<OngoingWork, String> dueDateOngoingTableColumn;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //initialize table

        //set up the columns in the table
        taskUpcomingTableColumn.setCellValueFactory(new PropertyValueFactory<UpcomingWork, String>("task"));
        dueDateUpcomingTableColumn.setCellValueFactory(new PropertyValueFactory<UpcomingWork, String>("dueDate"));
        taskOngoingTableColumn.setCellValueFactory(new PropertyValueFactory<OngoingWork, String>("task"));
        dueDateOngoingTableColumn.setCellValueFactory(new PropertyValueFactory<OngoingWork, String>("dueDate"));

        //load  data from text file
        upcomingWorksTableView.setItems(getUpcomingWorks());
        ongoingWorksTableView.setItems(getOngoingWorks());
        
        upcomingWorksTableView.setFocusTraversable(false);
    }    

    @FXML
    private void backButtonOnAction(ActionEvent event) throws IOException {
        Parent scene2Parent = FXMLLoader.load(getClass().getResource("employeeHomeScene.fxml"));
         Scene scene2 = new Scene(scene2Parent);
         Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
         window.setScene(scene2);
         window.show();
    }

    @FXML
    private void markAsDoneOnAction(ActionEvent event) throws IOException {
        
        
        Employee e = new Employee();
        e.getNotifiedAboutWorks(ongoingWorksTableView);
    }

    private ObservableList<UpcomingWork> getUpcomingWorks() {
       ObservableList<UpcomingWork> upcomingWorkList = FXCollections.observableArrayList();

        File f = null;

        Scanner sc = null;
        String str;
        String[] tokens;
        try {
            f = new File("empUpcomingWorks.txt");
            sc = new Scanner(f);
            if (f.exists()) {

                while (sc.hasNextLine()) {
                    str = sc.nextLine();
                    tokens = str.split(",");

                    upcomingWorkList.add(new UpcomingWork(tokens[0], tokens[1]));
                }
            }
        } catch (IOException ex) {
            System.out.println(ex);
        } finally {
            sc.close();

        }

        return upcomingWorkList;

    }

    private ObservableList<OngoingWork> getOngoingWorks() {
        ObservableList<OngoingWork> ongoingWorkList = FXCollections.observableArrayList();

        File f = null;

        Scanner sc = null;
        String str;
        String[] tokens;
        try {
            f = new File("empOngoingWorks.txt");
            sc = new Scanner(f);
            if (f.exists()) {

                while (sc.hasNextLine()) {
                    str = sc.nextLine();
                    tokens = str.split(",");

                    ongoingWorkList.add(new OngoingWork(tokens[0], tokens[1]));
                }
            }
        } catch (IOException ex) {
            System.out.println(ex);
        } finally {
            sc.close();
        }
        return ongoingWorkList;
    }
}
