package Controller;

import Model.CsvFileWriter;
import Model.Scraper;
import Model.User;
import com.sun.java.swing.plaf.windows.WindowsInternalFrameTitlePane;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class LoginController {

    private User user;

    private Scraper scraper = new Scraper();

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

    public void loadTransactions() throws IOException {
        Document document = getFile();
        user.setTransactions(scraper.getTransactions(document));
        CsvFileWriter.writeCsvFile(user);
    }

    public void loadNetWorth() throws IOException {
        Document document = getFile();
        user.setNetWorth(scraper.stringToDouble(scraper.getNetWorth(document)));
    }

    Document getFile() throws IOException {
        return Jsoup.parse(selectFile(), "UTF-8");
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
