/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

/**
 *
 * @author jawhar
 */
public abstract class User {
    protected String username, password, userType;
    
    public boolean authenticateUser(String username, String password, String userType) {
        // Read user information from the text file
        try (BufferedReader br = new BufferedReader(new FileReader("userAccounts.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] userInfo = line.split(",");
                if (username.equals(userInfo[0].trim()) && password.equals(userInfo[1].trim())
                        && userType.equals(userInfo[2].trim())) {
                    return true; // Authentication successful
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false; // Authentication failed
    }
    
    private void setUserScene(String type, ActionEvent event) throws IOException 
    {
        if (type.equals("Land Owner")) 
        {
            Parent userSceneParent = FXMLLoader.load(getClass().getResource("landOwnerHomeScene.fxml"));
            Scene scene2 = new Scene(userSceneParent);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

            window.setScene(scene2);
            window.show();
        } 
        else if (type.equals("Employee")) 
        {
            Parent userSceneParent = FXMLLoader.load(getClass().getResource("employeeHomeScene.fxml"));
            Scene scene2 = new Scene(userSceneParent);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

            window.setScene(scene2);
            window.show();
        } 
        else if (type.equals("H.R")) 
        {
            Parent userSceneParent = FXMLLoader.load(getClass().getResource("hRHomeScene.fxml"));
            Scene scene2 = new Scene(userSceneParent);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

            window.setScene(scene2);
            window.show();
        } 
        else if (type.equals("Finance Department")) 
        {
            Parent userSceneParent = FXMLLoader.load(getClass().getResource("financeDepartmentHomeScene.fxml"));
            Scene scene2 = new Scene(userSceneParent);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

            window.setScene(scene2);
            window.show();
        } 
        else if (type.equals("Legal Advisor")) 
        {
            Parent userSceneParent = FXMLLoader.load(getClass().getResource("legalAdvisorHomeScene.fxml"));
            Scene scene2 = new Scene(userSceneParent);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

            window.setScene(scene2);
            window.show();

        }

    }
    
    /**
     *
     * @param user
     * @param password
     * @param uType
     * @param event
     */
    public void login(String user, String password, String uType, ActionEvent event)
    {
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        File f = null;
        BufferedReader br = null;

    try {
        f = new File("userAccounts.txt");
        if (!f.exists()) {
            a.setTitle("Login Issue");
            a.setHeaderText("Issue found");
            a.setContentText("The login information file is not present!");
            a.showAndWait();
        } else {
            br = new BufferedReader(new FileReader(f));
            String line;
            boolean loggedIn = false;

            while ((line = br.readLine()) != null) {
                String[] userInfo = line.split(",");
                if (user.equals(userInfo[0].trim()) && password.equals(userInfo[1].trim())
                        && uType.equals(userInfo[2].trim())) {
                    loggedIn = true;
                    setUserScene(uType, event);
                    break;
                }
            }

            if (!loggedIn) {
                a.setTitle("Login Issue");
                a.setHeaderText("Invalid login");
                a.setContentText("Invalid login credentials, please try again!");
                a.showAndWait();
            }
        }
    } catch (IOException e) {
    } finally {
        try {
            if (br != null) {
                br.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    }
    
}