package Controller;

import Model.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class LoginController {

    private User user;


    @FXML
    private AnchorPane loginGrid;

    @FXML
    private TextField username;

    @FXML
    private PasswordField password;

    public void setup(User user) {
        this.user = user;
    }

    public void verify() throws IOException {
        if (username.getText().trim().equalsIgnoreCase("saksham") &&
                password.getText().trim().equalsIgnoreCase("ahlus")) {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/View/Home.fxml"));
            Parent root = fxmlLoader.load();
            HomepageController homepageController = fxmlLoader.getController();
            homepageController.setUp(user);
            loginGrid.getChildren().setAll(root);
        } else {
            System.out.println("error");
        }
    }
}
