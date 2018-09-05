import Controller.LoginController;
import Model.User;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class Main extends Application {

    @Override
    public void init() {
    }

    /**
     * Starts the Application with settings locked.
     *
     * @param stage Stage
     * @throws IOException the Exception that is thrown if a .fxml cannot be found
     */
    @Override
    public void start(Stage stage) throws IOException {

        User saksham = new User();

        try {
            saksham.setMonthlyLimit(500);

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/View/LogIn.fxml"));
            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root);
            LoginController loginController = fxmlLoader.getController();
            loginController.setup(saksham);
            stage.setTitle("Finance Assistant");
            stage.setScene(scene);
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * Stops the Application and serializes important info.
     *
     */
    @Override
    public void stop() throws Exception {
        super.stop();
    }

    /**
     * Launches the Application.
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        launch();
    }

}
