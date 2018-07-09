import Model.Calculator;
import Model.Filters.Filter;
import Model.Filters.MonthFilter;
import Model.Scraper;
import Model.Transaction;
import Model.User;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;


public class Main {

    public static void main(String[] args) {

        User saksham = new User();

        File file1 = new File("Deposit Account Details _ CIBC Online Banking.html");
        File file2 = new File("My Accounts _ CIBC Online Banking.html");
        Scraper scraper = new Scraper();

        MonthFilter monthFilter = new MonthFilter();
        Calculator calculator = new Calculator();


        try {

            Document document1 = Jsoup.parse(file1, "UTF-8");
            Document document2 = Jsoup.parse(file2, "UTF-8");

            saksham.setNetWorth(scraper.stringToDouble(scraper.getNetWorth(document2)));
            System.out.println(saksham.getNetWorth());
            saksham.setTransactions(scraper.getTransactions(document1));
            System.out.println(saksham.getExpenseReport());







//            filters
            monthFilter.setMonth("Jul");
            System.out.println(calculator.creditSpent(monthFilter.afterFilter(saksham.getTransactions())));
//            for (Transaction transaction : monthFilter.afterFilter(saksham.getTransactions())) {
//                System.out.println(transaction.getAmount() + ", " + transaction.getDate());
//            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
