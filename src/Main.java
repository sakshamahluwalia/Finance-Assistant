import Controller.LoginController;
import Model.CsvFileWriter;
import Model.Scraper;
import Model.User;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.io.File;
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
        Scraper scraper = new Scraper();

        //first doc is for networth
        Document document1 = Jsoup.parse(selectFile(), "UTF-8");
        //second doc is for transactions
        Document document2 = Jsoup.parse(selectFile(), "UTF-8");

        try {
//
            saksham.setNetWorth(scraper.stringToDouble(scraper.getNetWorth(document1)));
            saksham.setTransactions(scraper.getTransactions(document2));
            saksham.setMonthlyLimit(500);


//            CsvFileWriter.writeCsvFile(saksham);

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

    private File selectFile() {

        JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        int returnValue = jfc.showOpenDialog(null);
        // int returnValue = jfc.showSaveDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            return jfc.getSelectedFile();
        }
        return null;
    }

}
