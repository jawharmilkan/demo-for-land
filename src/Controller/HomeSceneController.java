
package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.User;

/**
 * FXML Controller class
 *
 * @author jawhar
 */
public class HomeSceneController implements Initializable {

    @FXML
    private PasswordField passwordTextField;
    @FXML
    private ComboBox userTypeComboBox;
    @FXML
    private TextField userNameTextField;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        userTypeComboBox.getItems().addAll("Land Owner", "Employee", "H.R", "Finance Department", "Legal Advisor");

        userTypeComboBox.setValue("Land Owner");
    }

    @FXML
    private void loginButtonOnAction(ActionEvent event) 
    {
        String username = userNameTextField.getText();
        String password = passwordTextField.getText();
        String usertype = userTypeComboBox.getValue().toString();
        
        User u = new User() {};
        u.login(username, password, usertype, event);
    }


}
