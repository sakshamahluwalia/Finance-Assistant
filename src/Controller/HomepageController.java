package Controller;

import Model.Calculator;
import Model.Filters.DebitFilter;
import Model.Filters.Filter;
import Model.Scraper;
import Model.Transaction;
import Model.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

public class HomepageController {

    private Scraper scraper = new Scraper();

    private User user = null;

    private Calculator calculator = new Calculator();

    private DebitFilter filter = new DebitFilter();

    @FXML
    private Label netWorthLabel;

    @FXML
    private Label creditLeftLabel;

    @FXML
    private Label creditSpentLabel;

    @FXML
    private TableView<Transaction> transactionTableView;

    @FXML
    private PieChart pieChart;

    @FXML
    private Label transactionNumber;

    /**
     * The column that holds all Ingredient objects
     */
    @FXML
    private TableColumn<Transaction, String> pobColumn;

    /**
     * The column that holds all the Ingredient object's quantity
     */
    @FXML
    private TableColumn<Transaction, Date> dateColumn;

    /**
     * The column that holds all the Ingredient object's quantity
     */
    @FXML
    private TableColumn<Transaction, Integer> amountColumn;


    @FXML
    private Button addTransactionButton;

    @FXML
    private Button loadButton;

    @FXML
    private Button resetButton;


    /**
     * Updates the InventoryTable with new Inventory items.
     */
    private void updateInventoryTable() {
        ObservableList<Transaction> observableList = FXCollections.observableArrayList(user.getTransactions());
        transactionTableView.setItems(observableList);

    }

    private void loadTransactions() {
        pobColumn.setCellValueFactory(new PropertyValueFactory<>("place"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        amountColumn.setCellValueFactory(new PropertyValueFactory<>("amount"));
    }

    public void loadChart() {
        int debit = 0;
        int credit = 0;
        for (Transaction transaction: user.getTransactions()) {
            if (transaction.getType().equalsIgnoreCase("debit")) {
                debit++;
            }
        }
        for (Transaction transaction: user.getTransactions()) {
            if (transaction.getType().equalsIgnoreCase("credit")) {
                credit++;
            }
        }
        PieChart.Data debit1 = new PieChart.Data("Debit", debit);
        PieChart.Data credit1 = new PieChart.Data("Credit", credit);
        pieChart.getData().addAll(debit1, credit1);
//        add logic to hide credit/debit criteria.
    }

    public void setUp(User user) {
        /**
         * Updates the pie chart with the most up to date information of completed orders and wasted orders.
         */
        this.user = user;
        loadInfo();

    }

    private void loadInfo() {
        loadChart();
        loadTransactions();
        updateInventoryTable();
        setNetWorthLabel(new Double(user.getNetWorth()).toString());
        setTransactionNumber(new Double(user.getTransactions().size()).toString());
        setCreditLeftLabel();
        setCreditSpentLabel();
    }

    private void setNetWorthLabel(String text) {
        netWorthLabel.setText(text);
    }

    private void setTransactionNumber(String text) {
        transactionNumber.setText(text);
    }

    private void setCreditLeftLabel() {
        double creditLeft = user.getMonthlyLimit() -
                calculator.creditSpent(filter.afterFilter(user.getTransactions()));
        creditLeftLabel.setText(Double.toString(creditLeft));
    }

    private void setCreditSpentLabel() {
        double creditSpent = calculator.creditSpent(filter.afterFilter(user.getTransactions()));
        creditSpentLabel.setText(Double.toString(creditSpent));
    }

    public void reset() {
        user.setTransactions(new ArrayList<>());
        loadInfo();
    }

    /**
     * Show an open dialog with a file chooser set up according to the
     * parameters of this builder.
     * @return A file if the user clicks the accept button and a file or
     * folder was selected at the time the user clicked cancel.
     */
    public void loadNewTransactions() {

        JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

        int returnValue = jfc.showOpenDialog(null);
        // int returnValue = jfc.showSaveDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = jfc.getSelectedFile();
            try {
                Document document3 = Jsoup.parse(selectedFile, "UTF-8");
                user.addTransactions(scraper.getTransactions(document3));
                loadInfo();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * This method is responsible for creating a window to create a new Transaction.
     */
    @FXML
    public void addTransaction() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/View/GainInfo.fxml"));
            Parent root = fxmlLoader.load();
            addTransactionController addTransactionController = fxmlLoader.getController();
            addTransactionController.setup(user);
            Stage stage = new Stage();
            stage.setTitle("Add Table");
            stage.setScene(new Scene(root, 300, 200));
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setOnCloseRequest(e -> loadInfo());
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
