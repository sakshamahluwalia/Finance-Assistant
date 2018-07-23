package Controller;

import Model.UserManager;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class LoginController {


    @FXML
    private AnchorPane loginGrid;

    @FXML
    private TextField username;

    @FXML
    private PasswordField password;

    public void verify() throws IOException {
        if (username.getText().trim().equalsIgnoreCase("s") &&
                password.getText().trim().equalsIgnoreCase("s")) {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/View/Home.fxml"));
            Parent root = fxmlLoader.load();
            HomepageController homepageController = fxmlLoader.getController();
            homepageController.setUp(UserManager.findUser(username.getText()));
            loginGrid.getChildren().setAll(root);
        } else {
            System.out.println("error");
        }
    }
}
