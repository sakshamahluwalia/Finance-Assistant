import Model.Scraper;
import Model.User;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.IOException;

public class Main extends Application {

//    public static void main(String[] args) {
//
//        User saksham = new User();
//
//        File file1 = new File("Deposit Account Details _ CIBC Online Banking.html");
//        File file2 = new File("My Accounts _ CIBC Online Banking.html");
//        Scraper scraper = new Scraper();
//
//        MonthFilter monthFilter = new MonthFilter();
//        DebitFilter debitFilter = new DebitFilter();
//        CreditFilter creditFilter = new CreditFilter();
//        Calculator calculator = new Calculator();
//
//
//        try {
//
//            Document document1 = Jsoup.parse(file1, "UTF-8");
//            Document document2 = Jsoup.parse(file2, "UTF-8");
//
//            saksham.setNetWorth(scraper.stringToDouble(scraper.getNetWorth(document2)));
//            System.out.println(saksham.getNetWorth());
//            saksham.setTransactions(scraper.getTransactions(document1));
//            System.out.println("I spent " + calculator.creditSpent
//                    (debitFilter.afterFilter(saksham.getTransactions())));
//
//            saksham.setTransactions(scraper.getTransactions(document1));
//            System.out.println("I had " + calculator.creditSpent
//                    (creditFilter.afterFilter(saksham.getTransactions())));
//
//
//
//
//
//
//
////            filters
//            monthFilter.setMonth("Jun");
//            System.out.println(calculator.creditSpent(monthFilter.afterFilter(saksham.getTransactions())));
////            for (Transaction transaction : monthFilter.afterFilter(saksham.getTransactions())) {
////                System.out.println(transaction.getAmount() + ", " + transaction.getDate());
////            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//
//    }

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

        User saksham;
        saksham = new User("s", "s");

        File file1 = new File("2018.html");
        File file2 = new File("2018p2.html");
        File file3 = new File("My Accounts _ CIBC Online Banking.html");
        Scraper scraper = new Scraper();


        try {

            Document document1 = Jsoup.parse(file1, "UTF-8");
            Document document2 = Jsoup.parse(file2, "UTF-8");
            Document document3 = Jsoup.parse(file3, "UTF-8");

            saksham.setNetWorth(scraper.stringToDouble(scraper.getNetWorth(document3)));
            saksham.setTransactions(scraper.getTransactions(document1 ));
            saksham.addTransactions(scraper.getTransactions(document2));
            saksham.setMonthlyLimit(500);


//            CsvFileWriter.writeCsvFile(saksham);

            Parent root = FXMLLoader.load(getClass().getResource("/View/LogIn.fxml"));
            Scene scene = new Scene(root);
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
